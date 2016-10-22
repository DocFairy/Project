package vo;

public class MemberGroup {

	private String groupno;
	private String groupname;
	private String leaderno;
	
    public MemberGroup() {
		// TODO Auto-generated constructor stub
	}


	public String getGroupno() {
		return groupno;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}


	public String getLeaderno() {
		return leaderno;
	}

	public void setLeaderno(String leaderno) {
		this.leaderno = leaderno;
	}


	@Override
	public String toString() {
		return "MemberGroup [groupno=" + groupno + ", groupname=" + groupname + ", leaderno=" + leaderno + "]";
	}

	

	
}
