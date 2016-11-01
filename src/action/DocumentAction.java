package action;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.poi.hslf.record.ExMCIMovie;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

import dao.DocumentDAO;
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
	private ArrayList<String> createFileNames;
	private String arr;
	private String[] createList;
	private String searchKeyword;
	private String searchText;
	private int currentPage = 1;
	// 파일 만들기만.
	private PageNavigator pagenavi;

	public String docCreate() throws Exception {
		System.out.println("length : " + arr);
		System.out.println(aNewCreate.toString());
		
		createFiles = new OpenExcelFile().createExcelDoc(aNewCreate, arr); //
//		System.out.println(createFiles.get(0).getName());
//		System.out.println("size = " + createFiles.size());
		createFileNames = new ArrayList<>();
		for (int i = 0; i < createFiles.size(); i++) {
			createFileNames.add(createFiles.get(i).getName());
		}
		return SUCCESS;
	} // 공유시 데이터베이스에 업로드. public String docShare(){ return SUCCESS; }

	public String customizingList() {
		createList = DocCustomizing.list;
		return SUCCESS;
	}

	public String docTransform() throws Exception {
		return "success";
	}

	public String docIntegrate() throws Exception {
		System.out.println("1");
		System.out.println(searchText);
		System.out.println("2");
		DocumentDAO dd = new DocumentDAO();
		int countPerPage = 5;		//페이지당 글목록 수
		int pagePerGroup = 5;		//그룹당 페이지 수
		//전체 글수 구하기
		int total=0;
		if(searchText!=null){
			total = dd.getTotal(null);
		}else{
			total = dd.getTotal(searchText);
		}	
		//PageNavigator 객체 생성 (페이지당 글수, 그룹당 페이지 수, 현재 페이지, 전체 글수)
		pagenavi = new PageNavigator(countPerPage, pagePerGroup, currentPage, total);		
		//현재 페이지에 해당하는 글 목록 읽기 (전체 레코드 중 보여줄 첫번째 글의 위치, 페이지당 글 수 )
		list = dd.selectfile(((Members) session.get("members")).getMemberno(), pagenavi.getStartRecord(), pagenavi.getCountPerPage(),searchText);
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
		String[] array = uploadFileName.split(",");
		ReadExcelDemo ex = new ReadExcelDemo();
		ExcelMain em = new ExcelMain();
		DocumentDAO dd = new DocumentDAO();
		double k = 0;
		ArrayList<String> goods = new ArrayList<String>();
		ArrayList<String> size = new ArrayList<String>();
		ArrayList<Double> hob = new ArrayList<Double>();
		ArrayList<Double> month = new ArrayList<Double>();
		ArrayList<Double> day = new ArrayList<Double>();
		ArrayList<Double> kazu = new ArrayList<Double>();
		ArrayList<Double> cost = new ArrayList<Double>();
		ArrayList<Double> all = new ArrayList<Double>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> uno = new ArrayList<String>();
		ArrayList<String> expire = new ArrayList<String>();
		ArrayList<String> yotei = new ArrayList<String>();
		ArrayList<String> sanko = new ArrayList<String>();
		ArrayList<ArrayList> result= new ArrayList<ArrayList>();
		ArrayList<ArrayList> receive = new ArrayList<ArrayList>();
		ArrayList<Double> cost2 = new ArrayList<Double>();
		ArrayList<Double> cost3 = new ArrayList<Double>();
		ArrayList<Double> cost4 = new ArrayList<Double>();
		if(arr.equals("거래명세서")){
		for (int i = 0; i < array.length; i++) {
			k += ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8, 4);
		}
		hob.add(k);

		for (int i = 1; i < array.length; i++) {
			for (int q = 0; q < 23; q++) {
				if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 2).equals("")) {
					break;
				}
				goods.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 2));
				size.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 13));
				month.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 0));
				day.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 1));
				kazu.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 16));
				cost.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 19));
				all.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 11 + q, 25));

			}

		}

		
		date.add(ex.word(dd.searchfile(array[array.length - 1],((Members)session.get("members")).getMemberno()), 1, 0));

		
		receive.add(date);
		receive.add(goods);
		receive.add(size);
		result.add(hob);
		result.add(month);
		result.add(day);
		result.add(kazu);
		result.add(cost);
		result.add(all);
		integrate = em.paste((ex.copy(dd.searchfile(array[0],((Members)session.get("members")).getMemberno()))), result, receive,"거래명세서");
		}else if(arr.equals("가계부")){
			for (int i = 1; i < array.length; i++) {
				for (int q = 0; q < 23; q++) {
					if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5 + q, 2).equals("")) {
						break;
					}
					date.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5+q, 2));
					goods.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5 + q, 3));
					kazu.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5 + q, 4));
					cost.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5 + q, 5));
					size.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 5+q, 6));
				}
			}
			System.out.println(date.get(0));
			receive.add(date);
			receive.add(goods);
			receive.add(size);
			result.add(kazu);
			result.add(cost);
			integrate = em.paste(ex.copy(dd.searchfile(array[0],((Members)session.get("members")).getMemberno())), result, receive,"가계부");
		}else if(arr.equals("지급어음명세서")){
			System.out.println(ex.word(dd.searchfile(array[0],((Members)session.get("members")).getMemberno()), 8, 1));
			for (int i = 1; i < array.length; i++) {
				for (int q = 0; q < 41; q++) {
					if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8 + q, 1).equals("")) {
						break;
					}
					date.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 1));
					goods.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()),8+q, 2));
					size.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 3));
					uno.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 4));
					cost.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 5));
					expire.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 6));
					yotei.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 7));
					sanko.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 8+q, 8));
				}
			}
			receive.add(date); receive.add(goods); receive.add(size); receive.add(uno); receive.add(expire); receive.add(yotei); receive.add(sanko);
			result.add(cost);
			integrate=em.paste(ex.copy(dd.searchfile(array[0], ((Members)session.get("members")).getMemberno())), result, receive, "지급어음명세서");
			
		}else if(arr.equals("재고관리대장")){
			for (int i = 1; i < array.length; i++) {
				for (int q = 0; q < 35; q++) {
					if (ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6 + q, 1).equals("")) {
						break;
					}
					date.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 1));
					goods.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()),6+q, 2));
					size.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 3));
					hob.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 4));
					cost.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 5));
					all.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 7));
					cost2.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 8));
					cost3.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 10));
					cost4.add(ex.number(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 11));
					sanko.add(ex.word(dd.searchfile(array[i],((Members)session.get("members")).getMemberno()), 6+q, 13));
					
				}
			}
			receive.add(date); receive.add(goods); receive.add(size); receive.add(sanko);
			result.add(hob); result.add(cost); result.add(all); result.add(cost2); result.add(cost3); result.add(cost4);
			integrate=em.paste(ex.copy(dd.searchfile(array[0], ((Members)session.get("members")).getMemberno())), result, receive, "재고관리대장");
		}
		return "success";
	}

public String changefile() throws Exception {
		
		if(uploadFileName.equals("currentStatus.docx,")){ 		//거래처별 현황 처리하는 메소드
			
		String[] array = uploadFileName.split(",");
		
		DocumentDAO dd = new DocumentDAO();
		
		String save_filename = dd.searchfile(array[0],((Members)session.get("members")).getMemberno());
		
		System.out.println(save_filename);
		
		ReadWord rw = new ReadWord();
		// ReadWord.readDocFile(save_filename);
		
		ArrayList<String[]> room = new ArrayList<>();

		room = rw.readWord(dd.searchfile(array[0],((Members)session.get("members")).getMemberno()));

		ExcelReadWrite erw = new ExcelReadWrite();
		
		integrate = erw.write(room);
		
		System.out.println(integrate);
		
		
		}else if(uploadFileName.equals("unpaymentStatus.docx,")){		//거래처별 미수현황표 처리하는 메소드
			
			System.out.println("들어오나?");
			
			String[] array = uploadFileName.split(",");
			
			DocumentDAO dd = new DocumentDAO();
			
			String save_filename = dd.searchfile(array[0],((Members)session.get("members")).getMemberno());
			
			System.out.println(save_filename);
			
			TorihikiWordRead twr = new TorihikiWordRead();
			
			ArrayList<String[]> room = new ArrayList<>();
			
			room = twr.readWord(dd.searchfile(array[0],((Members)session.get("members")).getMemberno()));
			
			TorihikiWordWrite tww = new TorihikiWordWrite();
			
			integrate = tww.write(room);
			
			System.out.println(integrate);

			
			
		}else if(uploadFileName.equals("expensesStatus.docx,")){		//경비사용내역 처리하는 메소드
			
			System.out.println("3.docx, 들어오나?");
			
			String[] array = uploadFileName.split(",");
			
			DocumentDAO dd = new DocumentDAO();
			
			String save_filename = dd.searchfile(array[0],((Members)session.get("members")).getMemberno());
			
			System.out.println(save_filename);
			
			UchiwakeWordRead uwr = new UchiwakeWordRead();
			
			ArrayList<String[]> room = new ArrayList<>();
			
			room = uwr.readWord(dd.searchfile(array[0],((Members)session.get("members")).getMemberno()));
			
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
			return "success";
		}else if(dd.calltype(save_filename).equals("cost")){
			msg="거래명세서";
		}else if(dd.calltype(save_filename).equals("uum")){
			msg="지급어음명세서";
		}else if(dd.calltype(save_filename).equals("left")){
			msg="재고관리대장";
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

	public ArrayList<String> getCreateFileNames() {
		return createFileNames;
	}

	public void setCreateFileNames(ArrayList<String> createFileNames) {
		this.createFileNames = createFileNames;
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
	
	

}
