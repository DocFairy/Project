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
		dao.fileDelete(del);
		FileService fs = new FileService();	
		String fullpath="C:/upload/"+del;
		fs.fileDelete(fullpath);
		System.out.println("deleteCompleted");
		return "success";
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
	
	
	
}
