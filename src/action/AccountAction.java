package action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AccountDAO;
import dao.DocumentDAO;
import excel.ExcelMain;
import excel.ReadExcelDemo;
import vo.Files;
import vo.Members;

public class AccountAction extends ActionSupport implements SessionAware{

	private Files files;
	private File upload;
	private List<Files> list;
	private String uploadFileName;
	private String del;
	private String date;
	private String content;
	private String input;
	private String out;
	private String note;
	private Map<String, Object> session;
	
	 int cloth = 0;
	 int food = 0;
	 int health = 0;
	 int cost = 0;
	 int save = 0;
	 int house = 0;
	 int ex = 0;
	
	AccountDAO dao = new AccountDAO();
	
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
		System.out.println(date);
		
		list = dao.fileList(date);
		System.out.println(list);
		
		return "success";
	}
	public String accountDel()throws Exception{
		System.out.println("action + " + del);
		FileService fs = new FileService();	
		String fullpath="C:/upload/"+ dao.fileFind(del);
		System.out.println(fullpath);
		fs.fileDelete(fullpath);
		dao.fileDelete(del);
		System.out.println("deleteCompleted");
		return "success";
	}
	public String goMakeAccount()throws Exception{
		System.out.println("go make account :" + date);
		return SUCCESS;
	}
	public String accountPage()throws Exception{
		System.out.println("accountPage : " + date);
		return SUCCESS;
	}
	public String saveAccount()throws Exception{
		
		String[] content1 = content.split(", ");
		String[] input1 = input.split(", ");
		String[] out1 = out.split(", ");
		String[] note1 = note.split(", ");
		System.out.println(content1.length);
		
		//가계부 복사
		ReadExcelDemo re=new ReadExcelDemo();
		XSSFWorkbook xw = re.copy("가계부.xlsx");
		
		//복사한 가계부 파일에 값 구겨넣기
		ExcelMain em = new ExcelMain();
		em.pasteAccount(xw, date, content1, input1, out1, note1);
		
		/*FileService fs = new FileService();
		String basePath = "c:/upload";
		upload=new File(em.pasteAccount(xw, date, content1, input1, out1, note1));
		uploadFileName=date+"가계부.xlsx";
		String savedfile = fs.saveFile(upload, basePath, uploadFileName);
		files.setSave_file(savedfile);
		files.setSave_filename(uploadFileName);*/
		
		DocumentDAO dd=new DocumentDAO();
		files=new Files();
		files.setSave_filename(date + "의 가계부");
		files.setFiletype("y");
		
		files.setMemberno(((Members)session.get("members")).getMemberno());
		
		files.setSave_file(date);
		System.out.println(((Members)session.get("members")).getMemberno());
		dd.insertfile(files);
		
		return SUCCESS;
	}
	public String gogoGraph()throws Exception{
		System.out.println(date);
		ReadExcelDemo re = new ReadExcelDemo();
		XSSFWorkbook workbook = re.copyGraph(date);
		 XSSFSheet sheet = workbook.getSheetAt(0);
         ArrayList<String> note = new ArrayList<>();
        /* ArrayList<String> input = new ArrayList<>();
         ArrayList<String> out = new ArrayList<>();*/
		 XSSFRow row = null; 
		 XSSFCell cell = null;
		
		/* int inputmoney = 0;
		 int outmoney = 0 ;*/
		/*for(int i = 0 ; i < 50 ; i++){
			row = sheet.getRow(i+5);
			cell = row.getCell(4);
			if(row.getCell(4).getStringCellValue().equals("")){break;}
			inputmoney = Integer.parseInt(inputmoney + cell.getStringCellValue());
			input.add(cell.getStringCellValue());
		}*/
		
		/*for(int i = 0 ; i <50 ; i++){
			row = sheet.getRow(i+5);
			cell = row.getCell(5);
			if(row.getCell(5).getStringCellValue().equals("")){break;}
			outmoney = Integer.parseInt(outmoney + cell.getStringCellValue());
			out.add(cell.getStringCellValue());
		}*/
		for(int i = 0 ; i < 50 ; i++){ 
			
			row = sheet.getRow(i+5);
			cell = row.getCell(6);
			if(row.getCell(6).getStringCellValue().equals("")){break;}
			if(row.getCell(6).getStringCellValue().equals("의류비")){
				cloth = cloth + 1;
			} else if (row.getCell(6).getStringCellValue().equals("식비")){
				food = food + 1;
			} else if (row.getCell(6).getStringCellValue().equals("건강/문화")){
				health = health + 1;
			} else if (row.getCell(6).getStringCellValue().equals("경조사/회비")){
				cost = cost + 1;
			} else if (row.getCell(6).getStringCellValue().equals("저축/보험")){
				save = save + 1;
			} else if (row.getCell(6).getStringCellValue().equals("주거/통신")){
				house = house + 1;
			} else if (row.getCell(6).getStringCellValue().equals("기타")){
				ex = ex + 1;
			}
			note.add(cell.getStringCellValue());
		}
	
		System.out.println("의류비의 개수:" + cloth);
		System.out.println("식비의 개수 : " + food);
		System.out.println("건강의 개수 : " + health);
		System.out.println("경조사의 개수 : " + cost);
		System.out.println("저축보험의 개수 : " + save);
		System.out.println("주거통신의 개수 : " + house);
		System.out.println("기타의 개수 " + ex);
		
		
	/*	System.out.println(input);
        System.out.println(out);*/
		System.out.println(note);
		
		return SUCCESS;
	}
	public String receiveData() throws Exception{
		System.out.println(date);
		ReadExcelDemo re = new ReadExcelDemo();
		XSSFWorkbook workbook = re.copyGraph(date);
		 XSSFSheet sheet = workbook.getSheetAt(0);
         ArrayList<String> note = new ArrayList<>();
        /* ArrayList<String> input = new ArrayList<>();
         ArrayList<String> out = new ArrayList<>();*/
		 XSSFRow row = null; 
		 XSSFCell cell = null;
		 
		 for(int i = 0 ; i < 50 ; i++){ 
				
				row = sheet.getRow(i+5);
				cell = row.getCell(6);
				if(row.getCell(6).getStringCellValue().equals("")){break;}
				if(row.getCell(6).getStringCellValue().equals("의류비")){
					cloth = cloth + 1;
				} else if (row.getCell(6).getStringCellValue().equals("식비")){
					food = food + 1;
				} else if (row.getCell(6).getStringCellValue().equals("건강/문화")){
					health = health + 1;
				} else if (row.getCell(6).getStringCellValue().equals("경조사/회비")){
					cost = cost + 1;
				} else if (row.getCell(6).getStringCellValue().equals("저축/보험")){
					save = save + 1;
				} else if (row.getCell(6).getStringCellValue().equals("주거/통신")){
					house = house + 1;
				} else if (row.getCell(6).getStringCellValue().equals("기타")){
					ex = ex + 1;
				}
				note.add(cell.getStringCellValue());
			}
		
			System.out.println("의류비의 개수:" + cloth);
			System.out.println("식비의 개수 : " + food);
			System.out.println("건강의 개수 : " + health);
			System.out.println("경조사의 개수 : " + cost);
			System.out.println("저축보험의 개수 : " + save);
			System.out.println("주거통신의 개수 : " + house);
			System.out.println("기타의 개수 " + ex);
			
		 
		return SUCCESS;
	}
	
	
	//setter & getter
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Files> getList() {
		return list;
	}
	public void setList(List<Files> list) {
		this.list = list;
	}
	public Files getFiles() {
		return files;
	}
	public void setFiles(Files files) {
		this.files = files;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public int getCloth() {
		return cloth;
	}
	public void setCloth(int cloth) {
		this.cloth = cloth;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getSave() {
		return save;
	}
	public void setSave(int save) {
		this.save = save;
	}
	public int getHouse() {
		return house;
	}
	public void setHouse(int house) {
		this.house = house;
	}
	public int getEx() {
		return ex;
	}
	public void setEx(int ex) {
		this.ex = ex;
	}
	
	
	
}

