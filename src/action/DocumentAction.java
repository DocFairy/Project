package action;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.apache.poi.hslf.record.ExMCIMovie;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.bouncycastle.asn1.ocsp.Request;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

import dao.DocumentDAO;
import dao.GroupingDAO;
import dao.MembersDAO;
import excel.Converter2;
import excel.ExcelMain;
import excel.ExcelReadWrite;
import excel.OpenExcelFile;
import excel.PathSaver;
import excel.ReadExcelDemo;
import excel.ReadWord;
import excel.TorihikiWordRead;
import excel.TorihikiWordWrite;
import excel.UchiwakeWordRead;
import excel.UchiwakeWordWrite;
import vo.DocCustomizing;
import vo.Files;
import vo.ImageFilenameConnector;
import vo.Members;
public class DocumentAction extends ActionSupport implements SessionAware {
	Files files;
	private File upload;
	/** 업로드할 파일. Form의 <file> 태그의 name. */
	private String uploadFileName;
	/** 업로드할 파일의 파일명 (File타입 속성명 + "FileName") */
	private String uploadContentType;
	/** 업로드할 파일의 컨텐츠 타입 (File타입 속성명 + "ContentType") */
	private List<Files> list;
	private Map<String, Object> session;
	private Members members;
	private List<Files> docFormList;
	private ArrayList<ImageFilenameConnector> imageList; // 이미지 리스트
	private String save_fileno;
	private String save_file;
	private String save_filename;
	private String integrate;
	private String msg;
	private String filename_pdf;
	private DocCustomizing aNewCreate;
	private List<File> createFiles;
	private String arr;
	private String[] createList;
	private String searchKeyword;
	private String searchText;
	private int currentPage = 1;
	private ArrayList<Files> tmpList;
	private String id;
	private ArrayList<String> mobileList;
	// 파일 만들기만.
	private PageNavigator pagenavi;
	  private String delFileName;
	  private String[] array;
	   
	   public String delLeaderFile(){
	      new DocumentDAO().delFile(delFileName);
	      return SUCCESS;
	   }

	   //DB에서 filetype이 't'인 데이터 지우기, 아이디검사도 함께.
	   public String delTempDoc() {
	      System.out.println("delTempDoc() start");
	      new DocumentDAO().deleteTempFiles(((Members) session.get("members")).getMemberno());
	      System.out.println("delTempDoc() end");
	      return SUCCESS;
	   }
	   //Files객체 ArrayList로 넣어서 자바스크립트로 보내기.
	   public String docCreate() throws Exception {
	      /*System.out.println("length : " + arr);
	      System.out.println(aNewCreate.toString());*/
	      String temp = aNewCreate.getCompanyNo();
	       temp = temp.substring(0, 3) + "-" + temp.substring(3, 5) + "-" + temp.substring(5);
	       aNewCreate.setCompanyNo(temp);
	      createFiles = new OpenExcelFile().createExcelDoc(aNewCreate, arr); 
	      System.out.println("createFiles size:" + createFiles.size());
	      DocumentDAO dd = new DocumentDAO();
	      tmpList = new ArrayList<>();
	      for (File fileInfo : createFiles) {
	         Files temp_file = new Files();
	         FileService fs = new FileService();
	         String basePath = "C:/upload"; // user.properties에 지정된 파일 저장 경로
	         String savedfile = fs.saveFile(fileInfo, basePath, fileInfo.getName());
	         System.out.println("savedfile : "+savedfile);
	         temp_file.setSave_file(savedfile);
	         temp_file.setSave_filename(fileInfo.getName());
	         temp_file.setMemberno(((Members) session.get("members")).getMemberno());
	         temp_file.setFiletype("t");
	         dd.insertfile(temp_file);
	         System.out.println("temp : " + temp_file);
	         tmpList.add(temp_file);
	      }
	      System.out.println("tmpList:"+tmpList);
	      
	      return SUCCESS;
	   } 
	   // 공유시 데이터베이스를 업데이트.
	   public String docShare(){
	      System.out.println("doc Share Method Call");
	      boolean result = false;
	      System.out.println("shared arr:" + arr);
	      String[] access = new String[arr.split(",").length];
	      for(int i=0; i<access.length; i++){
	         access[i] = arr.split(",")[i];
	      }
	      String[] fileT = new String[access.length];
	      for (int i = 0; i < access.length; i++) {
	         int number = Integer.parseInt(access[i]);
	         System.out.println("number is " + number);
	         if(DocCustomizing.STATEMENT_OF_ACCOUNT == number){
	            fileT[i] = "cost";
	         }else{
	            fileT[i] = "g";
	         }
	      }
	      if(new GroupingDAO().selectgroupone(((Members) session.get("members")).getMemberno())!=null){
	         result = new DocumentDAO().shareUpdate(((Members) session.get("members")).getGroupno()
	                                    , ((Members) session.get("members")).getMemberno()
	                                    , fileT);
	      }
	      if(result){
	         return SUCCESS; 
	      }else{
	         return ERROR;
	      }
	   }
	public String customizingList() {
		createList = DocCustomizing.list;
		return SUCCESS;
	}

	public String docTransform() throws Exception {
		return "success";
	}

	public String docIntegrate() throws Exception {
		DocumentDAO dd = new DocumentDAO()	;
		//현재 페이지에 해당하는 글 목록 읽기 (전체 레코드 중 보여줄 첫번째 글의 위치, 페이지당 글 수 )
		list = dd.selectfile(((Members) session.get("members")).getMemberno());
		return "success";
	}
	public String mobileIntegrate()throws Exception{
		DocumentDAO dd = new DocumentDAO();
		MembersDAO md=new MembersDAO();
		list=dd.selectfile(((Members)md.searchMember(id)).getMemberno());
		return "success";
	}
	
	
	public String docForm() throws Exception {
		DocumentDAO dao = new DocumentDAO();
	      docFormList = dao.primaryFormList();
	      imageList = new ArrayList<ImageFilenameConnector>();
	      for(int i = 0; i<docFormList.size();i++){
	         String imageName = "";
	         String save_fileno2 = docFormList.get(i).getSave_fileno();
	         imageName= docFormList.get(i).getSave_file();
	         String imageFilenameWithoutType = ""; 
	         int lastIndex = imageName.lastIndexOf('.');
	          if (lastIndex == -1){
	             imageName = "";
		         imageFilenameWithoutType = ""; 
	          }else{ 
	        	 imageFilenameWithoutType = imageName.substring(0, lastIndex); 
	             imageName = imageName.substring(0, lastIndex)+".png";
	          }
	          ImageFilenameConnector temp = new ImageFilenameConnector(save_fileno2, imageName, docFormList.get(i).getSave_filename(), imageFilenameWithoutType);
	          imageList.add(temp);
	      }//for

	      return "success";
	}
	public String docFormDeleteF() throws Exception{
		DocumentDAO dd = new DocumentDAO();
		System.out.println("docFormDeleteF(): "+save_fileno);
		dd.docFormDeleteF(save_fileno);
		docFormList = dd.primaryFormList();
	      imageList = new ArrayList<ImageFilenameConnector>();
	      for(int i = 0; i<docFormList.size();i++){
	         String imageName = "";
	         String save_fileno2 = docFormList.get(i).getSave_fileno();
	         imageName= docFormList.get(i).getSave_file();
	         String imageFilenameWithoutType = ""; 
	         int lastIndex = imageName.lastIndexOf('.');
	          if (lastIndex == -1){
	             imageName = "";
		         imageFilenameWithoutType = ""; 
	          }else{ 
	        	 imageFilenameWithoutType = imageName.substring(0, lastIndex); 
	             imageName = imageName.substring(0, lastIndex)+".png";
	          }
	          ImageFilenameConnector temp = new ImageFilenameConnector(save_fileno2, imageName, docFormList.get(i).getSave_filename(), imageFilenameWithoutType);
	          imageList.add(temp);
	      }//for

		return "success";
	}
	public String docFormSearch() throws Exception{
		System.out.println("docFormSearch():"+searchKeyword);
		DocumentDAO dao = new DocumentDAO();
		docFormList = dao.docFormSearch(searchKeyword);
		ArrayList<ImageFilenameConnector> imageListTemp = new ArrayList<ImageFilenameConnector>();
		for(int i = 0; i<docFormList.size(); i++){
			String imageFilenameWithoutType = ""; 
			String imageName = docFormList.get(i).getSave_file();
			int lastIndex = docFormList.get(i).getSave_file().lastIndexOf('.');
	        if (lastIndex == -1){
	        	imageName = "";
	        	imageFilenameWithoutType = ""; 
	        }else{ 
	        	imageFilenameWithoutType = docFormList.get(i).getSave_file().substring(0, lastIndex); 
	        	imageName = imageName.substring(0, lastIndex)+".png";
			docFormList.get(i).getSave_file().substring(0, lastIndex);
	        ImageFilenameConnector temp = new ImageFilenameConnector(docFormList.get(i).getSave_fileno(), imageName, docFormList.get(i).getSave_filename(), imageFilenameWithoutType);
	        imageListTemp.add(temp);
	        }
		}
		imageList = imageListTemp;
		for(int i=0; i<imageList.size();i++){
			System.out.println(imageList.get(i));
		}
		return SUCCESS;
	}
	public String fileShow() throws Exception {
		System.out.println("DocumentAction:fileShow():save_fileno=" + save_fileno);
		DocumentDAO dao = new DocumentDAO();
		files = dao.fileshow(save_fileno);
		// excel.Converter.createPDF();
		// this.convert();
		save_file = files.getSave_file();
		int lastIndex = save_file.lastIndexOf('.');
		if (lastIndex == -1) {
			filename_pdf = "";
		} else {
			filename_pdf = save_file.substring(0, lastIndex);
		}
		System.out.println("DocumentAction:pdfcreate() filename_pdf:" + filename_pdf);
		return SUCCESS;
	}

	public String pdfcreate() throws Exception {
		System.out.println("DocumentAction:pdfcreate() in");
		System.out.println("save_file:" + save_file + ", save_filename:" + save_filename);
		// DocumentDAO dao = new DocumentDAO();
		// files = dao.selectfileone(save_fileno);
		Converter2 con = new Converter2(); // pdf파일생성2줄
		con.convert2(save_file, save_filename);

		int lastIndex = save_file.lastIndexOf('.');
		if (lastIndex == -1) {
			filename_pdf = "";
		} else {
			filename_pdf = save_file.substring(0, lastIndex) + ".pdf";
		}
		System.out.println("DocumentAction:pdfcreate() filename_pdf:" + filename_pdf);
		return SUCCESS;
	}

	public String insertfile() throws Exception {
		if (uploadFileName.contains(".xlsx") == false) {
			msg = "2007버전 이상의 엑셀 파일을 올려야 합니다!";
			return "error";
		}
		if (upload != null) {
			FileService fs = new FileService();
			String basePath = "C:/upload"; // user.properties에 지정된 파일 저장 경로
			String savedfile = fs.saveFile(upload, basePath, uploadFileName); // 서버에
																				// 임시
																				// 업로드된
																				// 파일객체,
																				// 저장경로,
																				// 업로드당시의
																				// 파일명
																				// 전달하고
																				// 실제
																				// 저장된
																				// 파일명
																				// 리턴받음
			files.setSave_file(savedfile);
			files.setSave_filename(uploadFileName);
		}
		DocumentDAO dd = new DocumentDAO();
		if(dd.searchfile(files.getSave_filename(),((Members)session.get("members")).getMemberno())!=null){
			msg="이미 같은 이름의 파일이 존재합니다!";
			return "error";
		}
		dd.insertfile(files);
		return "success";
	}

	public String insertfile_docform() throws Exception{
		if (upload != null) { 
			FileService fs = new FileService();
			String basePath = "C:/upload";		//user.properties에 지정된 파일 저장 경로
			String savedfile = fs.saveFile(upload, basePath, uploadFileName);	//서버에 임시 업로드된 파일객체, 저장경로, 업로드당시의 파일명 전달하고 실제 저장된 파일명 리턴받음
			files.setSave_file(savedfile);
			files.setSave_filename(uploadFileName);
		}
		DocumentDAO dd=new DocumentDAO();
		dd.insertfile(files);
		save_file = files.getSave_file();
		save_filename = files.getSave_filename();
		
		Converter2 con = new Converter2(); //pdf파일생성2줄
		con.convert2(save_file, save_filename);
		System.out.println("convert2() done: png creating");
 		int lastIndex = save_file.lastIndexOf('.');
		filename_pdf = save_file.substring(0, lastIndex);
 		System.out.println("DocumentAction:insert_docform() filename_pdf:"+filename_pdf);
 		
 		File file = new File(PathSaver.filePath()+"/pdf/"+filename_pdf+".pdf");
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        PDFFile pdffile = new PDFFile(buf);
     // draw the first page to an image
        PDFPage page = pdffile.getPage(0);
        
        //get the width and height for the doc at the default zoom 
        Rectangle rect = new Rectangle(0,0,
                (int)page.getBBox().getWidth(),
                (int)page.getBBox().getHeight());
        
        //generate the image
        Image img = page.getImage(
                200, 332, //width & height
                rect, // clip rect
                null, // null for the ImageObserver
                true, // fill background with white
                true  // block until drawing is done
                );
        try {
            BufferedImage bi = (BufferedImage)img;
            File outputfile = new File(PathSaver.filePath()+"/pdf/"+filename_pdf+".png");
            ImageIO.write(bi, "png", outputfile);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        //show the image in a frame
    /*    JFrame frame = new JFrame("PDF Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(img)));
        frame.pack();
        frame.setVisible(true);*/
 		
        
		return "success";
	}

	public String insertword() throws Exception {

		if(uploadFileName.contains(".docx") == false){
	
			msg = "docx형식의 문서를 올려주셔야 됩니다";
			return "error";
			
		}
		
		if (upload != null) {
			FileService fs = new FileService();
			String basePath = "C:/upload"; // user.properties에 지정된 파일 저장 경로
			String savedfile = fs.saveFile(upload, basePath, uploadFileName); // 서버에
																				// 임시
																				// 업로드된
																				// 파일객체,
																				// 저장경로,
																				// 업로드당시의
																				// 파일명
																				// 전달하고
																				// 실제
																				// 저장된
																				// 파일명
																				// //
																				// 리턴받음
			files.setSave_file(savedfile);
			files.setSave_filename(uploadFileName);
		}

		DocumentDAO dd = new DocumentDAO();
		dd.insertfile(files);
		return "success";

	}

	public String delfile() throws Exception {
		DocumentDAO dd = new DocumentDAO();
		FileService fs = new FileService();
		String fullpath = "C:/upload/" + dd.searchfile(uploadFileName,((Members)session.get("members")).getMemberno());
		fs.fileDelete(fullpath);
		dd.delfile(uploadFileName);
		return "success";
	}

	public String makefile() throws Exception {
		MembersDAO md=new MembersDAO();
		DocumentDAO dd = new DocumentDAO();
		boolean wh=false;
		if(uploadFileName!=null){
		array = uploadFileName.split(",");
		wh=true;
		}else{
		System.out.println("y");
		HttpServletRequest request = ServletActionContext.getRequest();
		Enumeration<String> names =  request.getParameterNames();
		String data = names.nextElement();
		JSONObject jo=new JSONObject(data);
		array=new String[jo.length()-1];
		for(int i=0;i<jo.length()-1;i++){
			array[i]=jo.getString("mobileList"+i);
		}
		session.put("members",md.searchMember(jo.getString("id")));
		System.out.println("j");
		switch(dd.calltype(array[0])){

		case "y":
			arr="가계부";
			break;
		case "cost":
			arr="거래명세서";
			break;
		case "uum":
			arr="지급어음명세서";
			break;
		case "left":
			arr="재고관리대장";
			break;
		case "getu":
			arr="월말경비정산표";
			break;
		case "dept":
			arr="외상매출내역";
			break;
		case "print":
			arr="인쇄물 발주서";
			break;
		case "misu":
			arr="미수금 현황표";
			break;
		}
		wh=true;
		}
		if(wh){
		ReadExcelDemo ex = new ReadExcelDemo();
		ExcelMain em = new ExcelMain();
		double k = 0;
		ArrayList<String> st1 = new ArrayList<String>();
		ArrayList<String> st2 = new ArrayList<String>();
		ArrayList<String> st3 = new ArrayList<String>();
		ArrayList<String> st4 = new ArrayList<String>();
		ArrayList<String> st5 = new ArrayList<String>();
		ArrayList<String> st6 = new ArrayList<String>();
		ArrayList<String> st7 = new ArrayList<String>();	
		ArrayList<Double> db1 = new ArrayList<Double>();
		ArrayList<Double> db2 = new ArrayList<Double>();
		ArrayList<Double> db3 = new ArrayList<Double>();
		ArrayList<Double> db4 = new ArrayList<Double>();
		ArrayList<Double> db5 = new ArrayList<Double>();
		ArrayList<Double> db6 = new ArrayList<Double>();
		ArrayList<Double> db7 = new ArrayList<Double>();
		ArrayList<Double> db8 = new ArrayList<Double>();
		ArrayList<Double> db9 = new ArrayList<Double>();
		ArrayList<ArrayList> result= new ArrayList<ArrayList>();
		ArrayList<ArrayList> receive = new ArrayList<ArrayList>();
		if(arr.equals("거래명세서")){
			System.out.println("^");
		for (int i = 0; i < array.length; i++) {
			k += ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8, 4);
		}
		db4.add(k);

		for (int i = 1; i < array.length; i++) {
			for (int q = 0; q < 23; q++) {
				if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 2).equals("")) {
					break;
				}
				st1.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 2));
				st2.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 13));
				db5.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 0));
				db6.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 1));
				db7.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 16));
				db8.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 19));
				db9.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 25));

			}

		}
	
		st3.add(ex.word(dd.searchfile(array[array.length - 1],((Members)session.get("members")).getMemberno()), 1, 0));	
		receive.add(st3);
		receive.add(st1);
		receive.add(st2);
		result.add(db4);
		result.add(db5);
		result.add(db6);
		result.add(db7);
		result.add(db8);
		result.add(db9);
		integrate = em.paste((ex.copy(dd.searchfile(array[0],((Members)session.get("members")).getMemberno()))), result, receive,"거래명세서");
		}else if(arr.equals("가계부")){
			System.out.println("*");
			for (int i = 1; i < array.length; i++) {
				for (int q = 0; q < 23; q++) {
					if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5 + q, 2).equals("")) {
						break;
					}
					st3.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5+q, 2));
					st1.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5 + q, 3));
					db7.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5 + q, 4));
					db8.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5 + q, 5));
					st2.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5+q, 6));
				}
			}
			System.out.println(st3.get(0));
			receive.add(st3);
			receive.add(st1);
			receive.add(st2);
			result.add(db7);
			result.add(db8);
			integrate = em.paste(ex.copy(dd.searchfile(array[0],((Members)session.get("members")).getMemberno())), result, receive,"가계부");
		}else if(arr.equals("지급어음명세서")){
			System.out.println(ex.word(dd.searchfile(array[0],((Members)session.get("members")).getMemberno()), 8, 1));
			for (int i = 1; i < array.length; i++) {
				for (int q = 0; q < 41; q++) {
					if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8 + q, 1).equals("")) {
						break;
					}
					st3.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 1));
					st1.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()),8+q, 2));
					st2.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 3));
					st4.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 4));
					db8.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 5));
					st5.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 6));
					st6.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 7));
					st7.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 8));
				}
			}
			receive.add(st3); receive.add(st1); receive.add(st2); receive.add(st4); receive.add(st5); receive.add(st6); receive.add(st7);
			result.add(db8);
			integrate=em.paste(ex.copy(dd.searchfile(array[0], ((Members)session.get("members")).getMemberno())), result, receive, "지급어음명세서");
			
		}else if(arr.equals("재고관리대장")){
			System.out.println("(");
			for (int i = 1; i < array.length; i++) {
				for (int q = 0; q < 35; q++) {
					if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6 + q, 1).equals("")) {
						break;
					}
					st3.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 1));
					st1.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()),6+q, 2));
					st2.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 3));
					db4.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 4));
					db8.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 5));
					db9.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 7));
					db1.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 8));
					db2.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 10));
					db3.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 11));
					st7.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 13));
					
				}
			}
			receive.add(st3); receive.add(st1); receive.add(st2); receive.add(st7);
			result.add(db4); result.add(db8); result.add(db9); result.add(db1); result.add(db2); result.add(db3);
			integrate=em.paste(ex.copy(dd.searchfile(array[0], ((Members)session.get("members")).getMemberno())), result, receive, "재고관리대장");
		}else if(arr.equals("월말경비정산표")){
			System.out.println(")");
			for (int i = 1; i < array.length; i++) {
				for (int q = 0; q < 40; q++) {
					if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 2).equals("")) {
						break;
					}
					
					db1.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11+q, 0));
					db2.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11+q, 1));
					st1.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11+q, 2));
					db3.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11+q, 3));
					db4.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11+q, 4));
					st2.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11+q, 6));
					st3.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11+q, 7));
					st4.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11+q, 8));
					
				}
			}
			receive.add(st1);receive.add(st2); receive.add(st3); receive.add(st4);
			result.add(db1); result.add(db2); result.add(db3); result.add(db4);
			integrate=em.paste(ex.copy(dd.searchfile(array[0], ((Members)session.get("members")).getMemberno())), result, receive, "월말경비정산표");
		}else if(arr.equals("외상매출내역")){
			System.out.println("@@");
			for (int i = 1; i < array.length; i++) {
				for (int q = 0; q < 29; q++) {
					if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6 + q, 3).equals("")) {
						break;
					}
					
					db1.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 1));
					db2.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 2));
					st1.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 3));
					db3.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 4));
					db4.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 7));
					db5.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 9));
					db6.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 10));
					db7.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 11));
					db8.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 12));
					
				}
			}
			st2.add(ex.word(dd.searchfile(array[array.length - 1],((Members)session.get("members")).getMemberno()), 3, 4));
			receive.add(st1);receive.add(st2);
			result.add(db1); result.add(db2); result.add(db3); result.add(db4); result.add(db5); result.add(db6); result.add(db7); result.add(db8);
			integrate=em.paste(ex.copy(dd.searchfile(array[0], ((Members)session.get("members")).getMemberno())), result, receive, "외상매출내역");
		}else if(arr.equals("인쇄물발주서")){
			for (int i = 1; i < array.length; i++) {
				for (int q = 0; q < 22; q++) {
					if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 16 + q, 0).equals("")) {
						break;
					}
					
					st1.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 16+q, 0));
					st2.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 16+q, 3));
					db1.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 16+q, 4));
					db2.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 16+q, 5));
					st3.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 16+q, 7));
					st4.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 16+q, 8));
					
					
				}
			}

			receive.add(st1);receive.add(st2); receive.add(st3); receive.add(st4);
			result.add(db1); result.add(db2); 
			integrate=em.paste(ex.copy(dd.searchfile(array[0], ((Members)session.get("members")).getMemberno())), result, receive, "인쇄물발주서");
		}else if(arr.equals("미수금현황표")){
			for (int i = 1; i < array.length; i++) {
				for (int q = 0; q < 29; q++) {
					if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5 + q, 1).equals("")) {
						break;
					}
					
					st1.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5+q, 0));
					st2.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5+q, 1));
					st3.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5+q, 2));
					st4.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5+q, 3));
					db1.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5+q, 4));
					db2.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5+q, 5));
					st5.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5+q, 7));
					
					
				}
			}

			receive.add(st1);receive.add(st2); receive.add(st3); receive.add(st4);receive.add(st5);
			result.add(db1); result.add(db2); 
			integrate=em.paste(ex.copy(dd.searchfile(array[0], ((Members)session.get("members")).getMemberno())), result, receive, "미수금현황표");
		}
		}
		return "success";
	}

public String changefile() throws Exception {
	System.out.println(arr);
		
		if(arr.equals("거래처별 현황")){ 		//거래처별 현황 처리하는 메소드
			
		
		
		DocumentDAO dd = new DocumentDAO();
		
		String save_filename = dd.searchfile(uploadFileName,((Members)session.get("members")).getMemberno());
		
		System.out.println(save_filename);
		
		ReadWord rw = new ReadWord();
		// ReadWord.readDocFile(save_filename);
		
		ArrayList<String[]> room = new ArrayList<>();

		room = rw.readWord(dd.searchfile(uploadFileName,((Members)session.get("members")).getMemberno()));

		ExcelReadWrite erw = new ExcelReadWrite();
		
		integrate = erw.write(room);
		
		System.out.println(integrate);
		
		
		}else if(arr.equals("거래처별 미수현황표")){		//거래처별 미수현황표 처리하는 메소드
			
			System.out.println("들어오나?");
			
			
			
			DocumentDAO dd = new DocumentDAO();
			
			String save_filename = dd.searchfile(uploadFileName,((Members)session.get("members")).getMemberno());
			
			System.out.println(save_filename);
			
			TorihikiWordRead twr = new TorihikiWordRead();
			
			ArrayList<String[]> room = new ArrayList<>();
			
			room = twr.readWord(dd.searchfile(uploadFileName,((Members)session.get("members")).getMemberno()));
			
			TorihikiWordWrite tww = new TorihikiWordWrite();
			
			integrate = tww.write(room);
			
			System.out.println(integrate);

			
			
		}else if(arr.equals("경비사용내역")){		//경비사용내역 처리하는 메소드
			
			System.out.println("3.docx, 들어오나?");
			
		
			
			DocumentDAO dd = new DocumentDAO();
			
			String save_filename = dd.searchfile(uploadFileName,((Members)session.get("members")).getMemberno());
			
			System.out.println(save_filename);
			
			UchiwakeWordRead uwr = new UchiwakeWordRead();
			
			ArrayList<String[]> room = new ArrayList<>();
			
			room = uwr.readWord(dd.searchfile(uploadFileName,((Members)session.get("members")).getMemberno()));
			
			UchiwakeWordWrite uww = new UchiwakeWordWrite();
			
			integrate = uww.write(room);
			
			System.out.println(integrate);

			
		}

		return "success";

	}


	public String doctransform() throws Exception {
		DocumentDAO dd = new DocumentDAO();
		list = dd.selectword(((Members) session.get("members")).getMemberno());
		return "success";

	}
	public String move()throws Exception{
		DocumentDAO dd = new DocumentDAO();
		if(dd.calltype(save_filename).equals("y")){
			msg="가계부";
		}else if(dd.calltype(save_filename).equals("cost")){
			msg="거래명세서";
		}else if(dd.calltype(save_filename).equals("uum")){
			msg="지급어음명세서";
		}else if(dd.calltype(save_filename).equals("left")){
			msg="재고관리대장";
		}else if(dd.calltype(save_filename).equals("getu")){
			msg="월말경비정산표";
		}else if(dd.calltype(save_filename).equals("dept")){
			msg="외상매출내역";
		}else if(dd.calltype(save_filename).equals("print")){
			msg="인쇄물발주서";
		}else if(dd.calltype(save_filename).equals("misu")){
			msg="미수금현황표";
		}
			
		return "success";
	}
	public String move2()throws Exception{
		DocumentDAO dd = new DocumentDAO();
		System.out.println(save_filename);
		if(dd.calltype(save_filename).equals("ima")){
			msg="거래처별 현황";
		}else if(dd.calltype(save_filename).equals("genjou")){
			msg="거래처별 미수현황표";
		}else if(dd.calltype(save_filename).equals("keibi")){
			msg="경비사용내역";
		}
		return "success";
	}

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public List<Files> getList() {
		return list;
	}

	public void setList(List<Files> list) {
		this.list = list;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	public List<Files> getDocFormList() {
		return docFormList;
	}

	public void setDocFormList(List<Files> docFormList) {
		this.docFormList = docFormList;
	}

	public String getSave_fileno() {
		return save_fileno;
	}

	public void setSave_fileno(String save_fileno) {
		this.save_fileno = save_fileno;
	}

	public String getSave_file() {
		return save_file;
	}

	public void setSave_file(String save_file) {
		this.save_file = save_file;
	}

	public String getIntegrate() {
		return integrate;
	}

	public void setIntegrate(String integrate) {
		this.integrate = integrate;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSave_filename() {
		return save_filename;
	}

	public void setSave_filename(String save_filename) {
		this.save_filename = save_filename;
	}

	public String getFilename_pdf() {
		return filename_pdf;
	}

	public void setFilename_pdf(String filename_pdf) {
		this.filename_pdf = filename_pdf;
	}

	
	public DocCustomizing getaNewCreate() { return aNewCreate; } 
	public void setaNewCreate(DocCustomizing aNewCreate) { this.aNewCreate = aNewCreate;
	  }
	 
	public List<File> getCreateFiles() {
		return createFiles;
	}

	public void setCreateFiles(List<File> createFiles) {
		this.createFiles = createFiles;
	}

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	public String[] getCreateList() {
		return createList;
	}

	public void setCreateList(String[] createList) {
		this.createList = createList;
	}

	public ArrayList<ImageFilenameConnector> getImageList() {
		return imageList;
	}

	public void setImageList(ArrayList<ImageFilenameConnector> imageList) {
		this.imageList = imageList;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public PageNavigator getPagenavi() {
		return pagenavi;
	}

	public void setPagenavi(PageNavigator pagenavi) {
		this.pagenavi = pagenavi;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ArrayList<Files> getTmpList() {
		return tmpList;
	}
	public void setTmpList(ArrayList<Files> tmpList) {
		this.tmpList = tmpList;
	}

	public String getDelFileName() {
		return delFileName;
	}

	public void setDelFileName(String delFileName) {
		this.delFileName = delFileName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<String> getMobileList() {
		return mobileList;
	}

	public void setMobileList(ArrayList<String> mobileList) {
		this.mobileList = mobileList;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}
	
	

}
