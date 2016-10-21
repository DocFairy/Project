package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.GroupingDAO;
import dao.MembersDAO;
import vo.Members;

public class MembersAction extends ActionSupport implements SessionAware {

	private Members members;
	private String id;
	private String password;
	private boolean duplicated;
	private Map<String, Object> session;
	MembersDAO dao = new MembersDAO();
	private String friendid;
	private String groupname;
	


	public String join() throws Exception {
		dao.insertMember(members);

		return SUCCESS;
	}

	public String login() throws Exception {
		members = dao.searchMember(id);
		if (members != null) {
			if (id.equals(members.getId()) && password.equals(members.getPassword())) {
				session.put("members", members);
				if(((Members)session.get("members")).getInvite()!=null){
				String[]ivt=((Members)session.get("members")).getInvite().split(",");
				friendid=ivt[0];
				groupname=ivt[1];
				}
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

	public String confirm()throws Exception{
		MembersDAO md=new MembersDAO();
		GroupingDAO gd=new GroupingDAO();
		String groupno=gd.findgroupone(groupname);		
		dao.confirm(((Members)session.get("members")).getMemberno(), groupno);
		dao.reject(((Members)session.get("members")).getMemberno());
		session.put("members", md.searchMember(((Members)session.get("members")).getId()));
		return "success";
	}
	
	public String reject()throws Exception{
		MembersDAO md=new MembersDAO();
		dao.reject(((Members)session.get("members")).getMemberno());
		session.put("members", md.searchMember(((Members)session.get("members")).getId()));
		return "success";
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

	public String getFriendid() {
		return friendid;
	}

	public void setFriendid(String friendid) {
		this.friendid = friendid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

}
