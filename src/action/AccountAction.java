package action;

import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport{

	private String date;
	
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
		System.out.println("ddd");
		System.out.println(date);
		return "success";
	}
	
	//setter & getter
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
