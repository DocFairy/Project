package vo;

public class MemberGroup {

	private String groupno;
	private String groupname;
	private String save_fileno;
	private String leaderno;
	
    public MemberGroup() {
		// TODO Auto-generated constructor stub
	}

	public MemberGroup(String groupno, String groupname, String save_fileno, String leaderno) {
		super();
		this.groupno = groupno;
		this.groupname = groupname;
		this.save_fileno = save_fileno;
		this.leaderno = leaderno;
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

	public String getSave_fileno() {
		return save_fileno;
	}

	public void setSave_fileno(String save_fileno) {
		this.save_fileno = save_fileno;
	}

	public String getLeaderno() {
		return leaderno;
	}

	public void setLeaderno(String leaderno) {
		this.leaderno = leaderno;
	}

	@Override
	public String toString() {
		return "MemberGroup [groupno=" + groupno + ", groupname=" + groupname + ", save_fileno=" + save_fileno
				+ ", leaderno=" + leaderno + "]";
	}

	
}
