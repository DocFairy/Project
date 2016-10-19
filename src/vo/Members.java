package vo;

import java.io.File;

public class Members {

	private String memberno;
	private String id;
	private String password;
	private String name;
	private String address;
	private int phonenum;
	private int division;
	private File accountant;
	private int groupno;
	private String leaderno;
	
	public Members() {
		// TODO Auto-generated constructor stub
	}

	public Members(String memberno, String id, String password, String name, String address, int phonenum, int division,
			File accountant, int groupno, String leaderno) {
		super();
		this.memberno = memberno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phonenum = phonenum;
		this.division = division;
		this.accountant = accountant;
		this.groupno = groupno;
		this.leaderno = leaderno;
	}

	public String getMemberno() {
		return memberno;
	}

	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(int phonenum) {
		this.phonenum = phonenum;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public File getAccountant() {
		return accountant;
	}

	public void setAccountant(File accountant) {
		this.accountant = accountant;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public String getLeaderno() {
		return leaderno;
	}

	public void setLeaderno(String leaderno) {
		this.leaderno = leaderno;
	}

	@Override
	public String toString() {
		return "Members [memberno=" + memberno + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", address=" + address + ", phonenum=" + phonenum + ", division=" + division + ", accountant="
				+ accountant + ", groupno=" + groupno + ", leaderno=" + leaderno + "]";
	}

	
}
