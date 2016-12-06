package action;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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

public class AccountAction extends ActionSupport implements SessionAware {

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
	private int dateFrom;
	private int dateTo;
	private ArrayList<Double> firstDay;
	private ArrayList<ArrayList> secondDay;
	private ArrayList<String> outdate;
	private String arr;
	int cloth = 0;
	int food = 0;
	int health = 0;
	int cost = 0;
	int save = 0;
	int house = 0;
	int ex = 0;

	AccountDAO dao = new AccountDAO();

	public String accountManage() throws Exception {
		return "success";
	}

	public String accountBoard() throws Exception {
		return "success";
	}

	public String calendar() throws Exception {
		return "success";
	}

	public String accountList() throws Exception {
		System.out.println("in action : " + date);
		String memberno = ((Members) session.get("members")).getMemberno();
		System.out.println("in action : " + memberno);
		list = dao.fileList(date, memberno);
		System.out.println("in action : " + list);

		return "success";
	}

	public String accountDel() throws Exception {
		System.out.println("action + " + del);
		FileService fs = new FileService();
		String fullpath = "C:/upload/" + dao.fileFind(del);
		System.out.println(fullpath);
		fs.fileDelete(fullpath);
		dao.fileDelete(del);
		System.out.println("deleteCompleted");
		return "success";
	}

	public String goMakeAccount() throws Exception {
		System.out.println("go make account :" + date);
		return SUCCESS;
	}

	public String accountPage() throws Exception {
		System.out.println("accountPage : " + date);
		return SUCCESS;
	}

	public String saveAccount() throws Exception {

		String[] content1 = content.split(", ");
		String[] input1 = input.split(", ");
		String[] out1 = out.split(", ");
		String[] note1 = note.split(", ");
		System.out.println(content1.length);

		// 가계부 복사
		ReadExcelDemo re = new ReadExcelDemo();
		XSSFWorkbook xw = re.copy("가계부.xlsx");

		// 복사한 가계부 파일에 값 구겨넣기
		ExcelMain em = new ExcelMain();
		String id = ((Members) session.get("members")).getId();
		em.pasteAccount(xw, date, content1, input1, out1, note1, id);

		/*
		 * FileService fs = new FileService(); String basePath = "c:/upload";
		 * upload=new File(em.pasteAccount(xw, date, content1, input1, out1,
		 * note1)); uploadFileName=date+"가계부.xlsx"; String savedfile =
		 * fs.saveFile(upload, basePath, uploadFileName);
		 * files.setSave_file(savedfile);
		 * files.setSave_filename(uploadFileName);
		 */

		DocumentDAO dd = new DocumentDAO();
		files = new Files();
		files.setSave_filename(((Members) session.get("members")).getId() + "님의 " + date + ".xlsx");
		files.setFiletype("y");

		files.setMemberno(((Members) session.get("members")).getMemberno());

		files.setSave_file(((Members) session.get("members")).getId() + "님의 " + date + "의 가계부.xlsx");
		dd.insertfile(files);

		return SUCCESS;
	}

	public String gogoGraph() throws Exception {
		System.out.println("gogoGraph : " + date);
		String memberno = (((Members) session.get("members")).getMemberno());
		list = dao.fileList(date, memberno);
		System.out.println("gogoGraph : " + list);

		ReadExcelDemo re = new ReadExcelDemo();
		XSSFWorkbook workbook = re.copyGraph(((Members) session.get("members")).getId(), date);
		XSSFSheet sheet = workbook.getSheetAt(0);
		ArrayList<String> note = new ArrayList<>();
		/*
		 * ArrayList<String> input = new ArrayList<>(); ArrayList<String> out =
		 * new ArrayList<>();
		 */
		XSSFRow row = null;
		XSSFCell cell = null;

		/*
		 * int inputmoney = 0; int outmoney = 0 ;
		 */
		/*
		 * for(int i = 0 ; i < 50 ; i++){ row = sheet.getRow(i+5); cell =
		 * row.getCell(4);
		 * if(row.getCell(4).getStringCellValue().equals("")){break;} inputmoney
		 * = Integer.parseInt(inputmoney + cell.getStringCellValue());
		 * input.add(cell.getStringCellValue()); }
		 */

		/*
		 * for(int i = 0 ; i <50 ; i++){ row = sheet.getRow(i+5); cell =
		 * row.getCell(5);
		 * if(row.getCell(5).getStringCellValue().equals("")){break;} outmoney =
		 * Integer.parseInt(outmoney + cell.getStringCellValue());
		 * out.add(cell.getStringCellValue()); }
		 */
		for (int i = 0; i < 50; i++) {

			row = sheet.getRow(i + 5);
			cell = row.getCell(6);
			if (row.getCell(6).getStringCellValue().equals("")) {
				break;
			}
			if (row.getCell(6).getStringCellValue().equals("의류비")) {
				cloth = cloth + 1;
			} else if (row.getCell(6).getStringCellValue().equals("식비")) {
				food = food + 1;
			} else if (row.getCell(6).getStringCellValue().equals("건강/문화")) {
				health = health + 1;
			} else if (row.getCell(6).getStringCellValue().equals("경조사/회비")) {
				cost = cost + 1;
			} else if (row.getCell(6).getStringCellValue().equals("저축/보험")) {
				save = save + 1;
			} else if (row.getCell(6).getStringCellValue().equals("주거/통신")) {
				house = house + 1;
			} else if (row.getCell(6).getStringCellValue().equals("기타")) {
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

		/*
		 * System.out.println(input); System.out.println(out);
		 */
		System.out.println(note);

		return SUCCESS;
	}

	public String receiveData() throws Exception {
		System.out.println(date);
		ReadExcelDemo re = new ReadExcelDemo();
		XSSFWorkbook workbook = re.copyGraph(((Members) session.get("members")).getId(), date);
		XSSFSheet sheet = workbook.getSheetAt(0);
		ArrayList<String> note = new ArrayList<>();
		/*
		 * ArrayList<String> input = new ArrayList<>(); ArrayList<String> out =
		 * new ArrayList<>();
		 */
		XSSFRow row = null;
		XSSFCell cell = null;

		for (int i = 0; i < 50; i++) {

			row = sheet.getRow(i + 5);
			cell = row.getCell(6);
			if (row.getCell(6).getStringCellValue().equals("")) {
				break;
			}
			if (row.getCell(6).getStringCellValue().equals("의류비")) {
				cloth = cloth + 1;
			} else if (row.getCell(6).getStringCellValue().equals("식비")) {
				food = food + 1;
			} else if (row.getCell(6).getStringCellValue().equals("건강/문화")) {
				health = health + 1;
			} else if (row.getCell(6).getStringCellValue().equals("경조사/회비")) {
				cost = cost + 1;
			} else if (row.getCell(6).getStringCellValue().equals("저축/보험")) {
				save = save + 1;
			} else if (row.getCell(6).getStringCellValue().equals("주거/통신")) {
				house = house + 1;
			} else if (row.getCell(6).getStringCellValue().equals("기타")) {
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

	public String gogoChart() throws Exception {
		System.out.println("gogoChart : " + dateFrom);
		System.out.println("gogoChart : " + dateTo);
		String memberno = (((Members) session.get("members")).getMemberno());
		list = dao.fileListTerm(dateFrom, dateTo, memberno);
		ReadExcelDemo re = new ReadExcelDemo();
		System.out.println("gogoChart:" + list);
		secondDay = new ArrayList<>();
		outdate = new ArrayList<>();
		/*
		 * ArrayList<String> input = new ArrayList<>(); ArrayList<String> out =
		 * new ArrayList<>();
		 */
		XSSFRow row = null;
		XSSFCell cell = null;
		for (int i = 0; i < list.size(); i++) {
			firstDay = new ArrayList<>();
			String save_file = list.get(i).getSave_file();

			XSSFWorkbook workbook = re.copyChart(save_file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			double p = 0;
			double e = 0;
			for (int t = 5; t < 54; t++) {
				row = sheet.getRow(t);
				cell = row.getCell(4);
				p += cell.getNumericCellValue();
				cell = row.getCell(5);
				e += cell.getNumericCellValue();
			}
			firstDay.add(p);
			firstDay.add(e);
			row = sheet.getRow(5);
			cell = row.getCell(2);
			outdate.add(cell.getStringCellValue());
			secondDay.add(firstDay);
		}

		System.out.println("gogoChart end : " + list);
		return SUCCESS;
	}

	public String groupAccount() {
		DocumentDAO dd = new DocumentDAO();
		// 현재 페이지에 해당하는 글 목록 읽기 (전체 레코드 중 보여줄 첫번째 글의 위치, 페이지당 글 수 )
		list = dd.selectfile(((Members) session.get("members")).getMemberno());

		return SUCCESS;
	}

	public String goMakeMultiChart() {
		System.out.println("filename : " + uploadFileName);
		System.out.println("arr : " + arr);
		AccountDAO dao = new AccountDAO();

		String[] nameList = uploadFileName.split(",");
		ArrayList<String> fileName = new ArrayList<>();
		for (int i = 0; i < nameList.length; i++) {
			fileName.add(dao.fileFind(nameList[i]));
		}
		System.out.println(fileName);

		outdate = new ArrayList<>();
		firstDay = new ArrayList<>();
		ReadExcelDemo re = new ReadExcelDemo();
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFRow row1 = null;
		XSSFCell cell1 = null;
		System.out.println("for 위에서의 : " + fileName.get(0));
		for (int i = 0; i < fileName.size(); i++) {
			String save_file = fileName.get(i);
			System.out.println("for 안에서의 : " + save_file);

			XSSFWorkbook workbook = re.copy(save_file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			row = sheet.getRow(2);
			cell = row.getCell(4); // 회사이름

			row1 = sheet.getRow(8);
			cell1 = row1.getCell(4); // 매출액

			String company = cell.getStringCellValue();
			double expense = cell1.getNumericCellValue();
			if (outdate.size() == 0) {
				outdate.add(cell.getStringCellValue());
				firstDay.add(cell1.getNumericCellValue());
			} else {
				for (int j = 0; j < outdate.size(); j++) {
					if (company.equals(outdate.get(j))) {
						double money = firstDay.get(j) + expense;
						firstDay.add(j + 1, money);
						firstDay.remove(j);
					}
				}
				System.out.println("cell의 내용 : " + cell);
				outdate.add(cell.getStringCellValue());
				System.out.println("두번째 cell의 내용 : " + cell1.getNumericCellValue());
				firstDay.add(cell1.getNumericCellValue());
				
				

			}
		}

		return SUCCESS;
	}

	// setter & getter
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

	public int getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(int dateFrom) {
		this.dateFrom = dateFrom;
	}

	public int getDateTo() {
		return dateTo;
	}

	public void setDateTo(int dateTo) {
		this.dateTo = dateTo;
	}

	public ArrayList<Double> getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(ArrayList<Double> firstDay) {
		this.firstDay = firstDay;
	}

	public ArrayList<ArrayList> getSecondDay() {
		return secondDay;
	}

	public void setSecondDay(ArrayList<ArrayList> secondDay) {
		this.secondDay = secondDay;
	}

	public ArrayList<String> getOutdate() {
		return outdate;
	}

	public void setOutdate(ArrayList<String> outdate) {
		this.outdate = outdate;
	}

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

}
