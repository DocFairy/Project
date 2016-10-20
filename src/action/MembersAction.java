package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MembersDAO;
import vo.Members;

public class MembersAction extends ActionSupport implements SessionAware {

	private Members members;
	private String id;
	private String password;
	private boolean duplicated;
	private Map<String, Object> session;
	MembersDAO dao = new MembersDAO();

	public String join() throws Exception {

		System.out.println(members.getName());
		System.out.println(members.getPassword());
		System.out.println(members.getDivision());
		dao.insertMember(members);

		return SUCCESS;
	}

	public String login() throws Exception {
		members = dao.searchMember(id);
		if (members != null) {
			System.out.println(members);
			if (id.equals(members.getId()) && password.equals(members.getPassword())) {
				session.put("members", members);
				return SUCCESS;
			} else {
				return ERROR;
			}
		} else {
			return ERROR;
		}
	}

	public String logout() throws Exception {
		session.clear();
		return SUCCESS;
	}

	public String goIdCheck() throws Exception {
		System.out.println(id);
		members = dao.searchMember(id);

		if (members != null) {
			duplicated = true;
		}
		return SUCCESS;
	}

	public String updateForm() throws Exception {
		members = (Members) session.get("members");
		return SUCCESS;
	}

	public String update() throws Exception {

		System.out.println(members);
		dao.updateMember(members);
		return SUCCESS;
	}

	// getter & setter

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isDuplicated() {
		return duplicated;
	}

	public void setDuplicated(boolean duplicated) {
		this.duplicated = duplicated;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
