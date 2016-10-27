package action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.DocumentDAO;
import excel.Converter2;
import excel.ExcelMain;
import excel.ExcelReadWrite;
import excel.OpenExcelFile;
import excel.ReadExcelDemo;
import excel.ReadWord;
import vo.DocCustomizing;
import vo.Files;
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
	private String save_fileno;
	private String save_file;
	private String save_filename;
	private String integrate;
	private String msg;
	private String filename_pdf;
	private DocCustomizing aNewCreate;
	private List<Files> createFiles;
	private String arr;
	private String[] createList;
	// 파일 만들기만.

	public String docCreate() throws Exception {
		System.out.println("length : " + arr);
		System.out.println(aNewCreate.toString());
		
		new OpenExcelFile().createExcelDoc(aNewCreate, arr); //
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
		DocumentDAO dd = new DocumentDAO();
		list = dd.selectfile(((Members) session.get("members")).getMemberno());
		return "success";
	}

	public String docForm() throws Exception {
		DocumentDAO dao = new DocumentDAO();
		docFormList = dao.primaryFormList();
		return "success";
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
		dd.insertfile(files);
		return "success";
	}

	public String insertfile_docform() throws Exception {
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
		dd.insertfile(files);
		save_file = files.getSave_file();
		save_filename = files.getSave_filename();

		Converter2 con = new Converter2(); // pdf파일생성2줄
		con.convert2(save_file, save_filename);

		int lastIndex = save_file.lastIndexOf('.');
		filename_pdf = save_file.substring(0, lastIndex);
		System.out.println("DocumentAction:insert_docform() filename_pdf:" + filename_pdf);
		return "success";
	}

	public String insertword() throws Exception {

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
		String fullpath = "C:/upload/" + dd.searchfile(uploadFileName);
		fs.fileDelete(fullpath);
		dd.delfile(uploadFileName);
		return "success";
	}

	public String makefile() throws Exception {
		String[] array = uploadFileName.split(",");
		ReadExcelDemo ex = new ReadExcelDemo();
		ExcelMain em = new ExcelMain();
		DocumentDAO dd = new DocumentDAO();
		String p = "";
		double j, k = 0;
		ArrayList<String> goods = new ArrayList<String>();
		ArrayList<String> size = new ArrayList<String>();
		ArrayList<Double> hob = new ArrayList<Double>();
		ArrayList<Double> month = new ArrayList<Double>();
		ArrayList<Double> day = new ArrayList<Double>();
		ArrayList<Double> kazu = new ArrayList<Double>();
		ArrayList<Double> cost = new ArrayList<Double>();
		ArrayList<Double> all = new ArrayList<Double>();

		for (int i = 0; i < array.length; i++) {
			k += ex.number(dd.searchfile(array[i]), 8, 4);
		}
		hob.add(k);

		for (int i = 1; i < array.length; i++) {
			for (int q = 0; q < 23; q++) {
				if (ex.word(dd.searchfile(array[i]), 11 + q, 2).equals("")) {
					break;
				}
				goods.add(ex.word(dd.searchfile(array[i]), 11 + q, 2));
				size.add(ex.word(dd.searchfile(array[i]), 11 + q, 13));
				month.add(ex.number(dd.searchfile(array[i]), 11 + q, 0));
				day.add(ex.number(dd.searchfile(array[i]), 11 + q, 1));
				kazu.add(ex.number(dd.searchfile(array[i]), 11 + q, 16));
				cost.add(ex.number(dd.searchfile(array[i]), 11 + q, 19));
				all.add(ex.number(dd.searchfile(array[i]), 11 + q, 25));

			}

		}

		ArrayList<String> date = new ArrayList<String>();
		date.add(ex.word(dd.searchfile(array[0]), 1, 0) + "~" + ex.word(dd.searchfile(array[array.length - 1]), 1, 0));

		ArrayList<ArrayList> result = new ArrayList<ArrayList>();
		ArrayList<ArrayList> receive = new ArrayList<ArrayList>();
		receive.add(date);
		receive.add(goods);
		receive.add(size);
		result.add(hob);
		result.add(month);
		result.add(day);
		result.add(kazu);
		result.add(cost);
		result.add(all);
		integrate = em.paste(ex.copy(dd.searchfile(array[0])), result, receive);
		return "success";
	}

	public String changefile() throws Exception {
		System.out.println("찍히는건가");
		String[] array = uploadFileName.split(",");
		System.out.println(array);

		DocumentDAO dd = new DocumentDAO();
		String save_filename = dd.searchfile(array[0]);

		System.out.println(save_filename);

		ReadWord rw = new ReadWord();
		// ReadWord.readDocFile(save_filename);

		ArrayList<String[]> room = new ArrayList<>();

		room = rw.readWord(dd.searchfile(array[0]));

		ExcelReadWrite erw = new ExcelReadWrite();

		erw.write(room);

		return "success";

	}

	public String doctransform() throws Exception {
		DocumentDAO dd = new DocumentDAO();
		list = dd.selectfile(((Members) session.get("members")).getMemberno());
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
	 
	public List<Files> getCreateFiles() {
		return createFiles;
	}

	public void setCreateFiles(List<Files> createFiles) {
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

}
