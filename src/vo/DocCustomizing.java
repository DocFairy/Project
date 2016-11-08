package vo;


public class DocCustomizing {
	public static int STATEMENT_OF_ACCOUNT = 0;
	public static int CORPORATE_CARD = 1;
	public static int TAX_INVOICE = 2;
	public static int BUYER_MANAGEMENT = 3;
	public static int UNPAYMENT_STATUS = 4;
	public static int EXPENSE_ACCOUNT = 5;
	public static String[] list = {"거래명세서","법인카드사용내역서","세금계산서",
									"거래처관리대장","거래처별미수현황표","일반경비내역서"};
	
	private String companyName;
	private String companyNo;
	private String ownerName;
	private String address;
	private String phoneNumber;
	private String fax;
	//업태
	//종목
	private String division;
	
	public DocCustomizing() {
	}
	
	public DocCustomizing(String companyName, String companyNo, String ownerName, String address,
																String phoneNumber, String fax) {
		this.companyName = companyName;
		this.companyNo = companyNo;
		this.ownerName = ownerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.fax = fax;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String toString() {
		return "DocCustomizing [companyName=" + companyName + ", companyNo=" + companyNo + ", ownerName=" + ownerName
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", fax=" + fax + "]";
	}
	
}
