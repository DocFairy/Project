package action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AccountDAO;
import dao.DocumentDAO;
import excel.ExcelMain;
import excel.ReadExcelDemo;
import vo.Files;
import vo.Members;

public class AccountAction extends ActionSupport implements SessionAware{

	private Files files;
	private File upload;
	private List<Files> list;
	private String uploadFileName;
	private String del;
	private String date;
	private String content;
	private String input;
	private String out;
	private String note;
	private Map<String, Object> session;
	
	AccountDAO dao = new AccountDAO();
	
	public String accountManage()throws Exception{
		return "success";
	}
	public String accountBoard()throws Exception{
		return "success";
	}
	public String calendar()throws Exception{
		return "success";
	}
	public String accountList()throws Exception{
		System.out.println(date);
		
		list = dao.fileList(date);
		System.out.println(list);
		
		return "success";
	}
	public String accountDel()throws Exception{
		System.out.println("action + " + del);
		FileService fs = new FileService();	
		String fullpath="C:/upload/"+ dao.fileFind(del);
		System.out.println(fullpath);
		fs.fileDelete(fullpath);
		dao.fileDelete(del);
		System.out.println("deleteCompleted");
		return "success";
	}
	public String goMakeAccount()throws Exception{
		System.out.println("go make account :" + date);
		return SUCCESS;
	}
	public String accountPage()throws Exception{
		System.out.println("accountPage : " + date);
		return SUCCESS;
	}
	public String saveAccount()throws Exception{
		
		String[] content1 = content.split(", ");
		String[] input1 = input.split(", ");
		String[] out1 = out.split(", ");
		String[] note1 = note.split(", ");
		System.out.println(content1.length);
		
		//가계부 복사
		ReadExcelDemo re=new ReadExcelDemo();
		XSSFWorkbook xw = re.copy("가계부.xlsx");
		
		//복사한 가계부 파일에 값 구겨넣기
		ExcelMain em = new ExcelMain();
		em.pasteAccount(xw, date, content1, input1, out1, note1);
		
		/*FileService fs = new FileService();
		String basePath = "c:/upload";
		upload=new File(em.pasteAccount(xw, date, content1, input1, out1, note1));
		uploadFileName=date+"가계부.xlsx";
		String savedfile = fs.saveFile(upload, basePath, uploadFileName);
		files.setSave_file(savedfile);
		files.setSave_filename(uploadFileName);*/
		
		DocumentDAO dd=new DocumentDAO();
		files=new Files();
		files.setSave_filename(date);
		files.setFiletype("y");
		
		files.setMemberno(((Members)session.get("members")).getMemberno());
		
		files.setSave_file(date + "의 가계부");
		System.out.println(((Members)session.get("members")).getMemberno());
		dd.insertfile(files);
		
		return SUCCESS;
	}
	public String getGraph()throws Exception{
		System.out.println("getGraph");
		
		return SUCCESS;
	}
	
	//setter & getter
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Files> getList() {
		return list;
	}
	public void setList(List<Files> list) {
		this.list = list;
	}
	public Files getFiles() {
		return files;
	}
	public void setFiles(Files files) {
		this.files = files;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	

	
	
	
}
