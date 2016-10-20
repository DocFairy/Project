package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import vo.MemberGroup;
import vo.Members;

public class GroupingAction extends ActionSupport implements SessionAware{
	MemberGroup membergroup;
	List<MemberGroup>mlist;
	Map<String, Object> session;
	
	public String groupManage()throws Exception{
		GroupingDAO gd=new GroupingDAO();
		if(((Members)session.get("members")).getGroupno()!=null){
		mlist=gd.selectgroup(((Members)session.get("members")).getGroupno());
		}
		return "success";
	}
	public String docManage()throws Exception{
		return "success";
	}
	public String groupDocDownload()throws Exception{
		return "success";
	}
	public String creategroup()throws Exception{
		GroupingDAO gd=new GroupingDAO();
		System.out.println(membergroup);
		gd.creategroup(membergroup);
		return "success";
	}
	public MemberGroup getMembergroup() {
		return membergroup;
	}
	public void setMembergroup(MemberGroup membergroup) {
		this.membergroup = membergroup;
	}
	
	public List<MemberGroup> getMlist() {
		return mlist;
	}
	public void setMlist(List<MemberGroup> mlist) {
		this.mlist = mlist;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
