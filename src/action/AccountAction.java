package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.AccountDAO;
import vo.Files;

public class AccountAction extends ActionSupport{

	private String date;
	private Files files;
	private List<Files> list;
	private String del;
	private String content;
	private int in;
	private int out;
	private String note;
	
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
		return SUCCESS;
	}
	public String saveAccount()throws Exception{
		System.out.println("date : " + date);
		System.out.println("content : " + content);
		System.out.println("in : " + in);
		System.out.println("out : " + out);
		System.out.println("note : " + note);
		
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
	public int getIn() {
		return in;
	}
	public void setIn(int in) {
		this.in = in;
	}
	public int getOut() {
		return out;
	}
	public void setOut(int out) {
		this.out = out;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
