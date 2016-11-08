package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.DocumentDAO;
import dao.GroupingDAO;
import dao.MembersDAO;
import vo.Files;
import vo.MemberGroup;
import vo.Members;

public class GroupingAction extends ActionSupport implements SessionAware{
	MemberGroup membergroup;
	List<Members>mlist;
	Map<String, Object> session;
	String id;
	List<String>idlist;
	String groupname;
	String fri;
	List<Files> groupFiles;
	
	public String groupManage()throws Exception{
		GroupingDAO gd=new GroupingDAO();
		if(((Members)session.get("members")).getGroupno()!=null){
		mlist=gd.selectgroup(((Members)session.get("members")).getGroupno());
		membergroup=gd.searchgroupone(((Members)session.get("members")).getGroupno());
		}
		return "success";
	}
	public String groupDocs(){
	      System.out.println("groupNo:" + ((Members)session.get("members")).getGroupno());
	      groupFiles = new DocumentDAO().searchGroupFiles(((Members)session.get("members")).getGroupno());
	      return SUCCESS;
	   }
	public String docManage()throws Exception{
		return "success";
	}
	public String groupDocDownload()throws Exception{
		return "success";
	}
	public String creategroup()throws Exception{
		GroupingDAO gd=new GroupingDAO();
		MembersDAO md=new MembersDAO();
		if(membergroup.getGroupname().equals("")){
			fri="그룹 이름을 입력하세요.";
			return "error";
		}else if(membergroup.getGroupname().length()>50){
			fri="그룹 이름이 너무 깁니다.";
			return "error";
		}
		gd.creategroup(membergroup);
		String mno=((Members)session.get("members")).getMemberno();
		membergroup=gd.selectgroupone(mno);
		gd.updategroup(membergroup.getGroupno(),mno);
		session.put("members", md.searchMember(((Members)session.get("members")).getId()));
		return "success";
	}
	public String dest()throws Exception{
		MembersDAO md=new MembersDAO();
		GroupingDAO gd=new GroupingDAO();
		String gno=((Members)session.get("members")).getGroupno();
		gd.expiremember(gno);
		gd.deletegroup(gno);
		session.put("members", md.searchMember(((Members)session.get("members")).getId()));
		return "success";
	}
	public String invite()throws Exception{
		GroupingDAO gd=new GroupingDAO();
		String mno=((Members)session.get("members")).getMemberno();
		membergroup=gd.selectgroupone(mno);
		return "success";
	}
	
	public String searchid()throws Exception{
		MembersDAO md=new MembersDAO();
		idlist=md.searchid(id);		
		return "success";
	}
	
	public String msg()throws Exception{
		MembersDAO md=new MembersDAO();
		String msg=id+","+groupname;
		String friend=md.searchMember(fri).getMemberno();
		md.inviteid(friend, msg);
		return "success";
	}
	public String leave()throws Exception{
		MembersDAO md=new MembersDAO();
		GroupingDAO gd=new GroupingDAO();
		gd.leave(((Members)session.get("members")).getMemberno());
		session.put("members", md.searchMember(((Members)session.get("members")).getId()));
		return "success";
	}
	public MemberGroup getMembergroup() {
		return membergroup;
	}
	public void setMembergroup(MemberGroup membergroup) {
		this.membergroup = membergroup;
	}
	
	public List<String> getIdlist() {
		return idlist;
	}
	public void setIdlist(List<String> idlist) {
		this.idlist = idlist;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Members> getMlist() {
		return mlist;
	}
	public void setMlist(List<Members> mlist) {
		this.mlist = mlist;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getFri() {
		return fri;
	}
	public void setFri(String fri) {
		this.fri = fri;
	}
	public List<Files> getGroupFiles() {
		return groupFiles;
	}
	public void setGroupFiles(List<Files> groupFiles) {
		this.groupFiles = groupFiles;
	}
	
	
}
