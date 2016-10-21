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
	private String accountant;
	private String groupno;
	private String invite;
	
	public Members() {
		// TODO Auto-generated constructor stub
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



	public String getAccountant() {
		return accountant;
	}

	public void setAccountant(String accountant) {
		this.accountant = accountant;
	}

	public String getInvite() {
		return invite;
	}

	public void setInvite(String invite) {
		this.invite = invite;
	}

	public String getGroupno() {
		return groupno;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	@Override
	public String toString() {
		return "Members [memberno=" + memberno + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", address=" + address + ", phonenum=" + phonenum + ", division=" + division + ", accountant="
				+ accountant + ", groupno=" + groupno + ", invite=" + invite + "]";
	}

}
