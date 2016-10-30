package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import vo.DocCustomizing;
import vo.Files;


public class OpenExcelFile {
	List<Files> files;
	public List<Files> createExcelDoc(DocCustomizing object, String arr) throws Exception{
		files = new ArrayList<>();
		File xlsxFile = null;
		FileInputStream fis = null;
		Workbook workbook1 = null;
		ArrayList<Sheet> sheet= null;
		
		String[] access = new String[arr.split(",").length];
		File file = null;
		for(int i=0; i<access.length; i++){
			access[i] = arr.split(",")[i];
		}
		for (int i=0; i<access.length; i++) {
			int number = Integer.parseInt(access[i]);
			//업로드 시켜놓은 파일을 불러와서 데이터 셋팅
			if(DocCustomizing.STATEMENT_OF_ACCOUNT == number){
				//파일 경로는 디비에 업로드 되어었는 파일임.
				xlsxFile = new File("C:/Users/lg/Desktop/account/auto_account.xlsx");
				fis = new FileInputStream(xlsxFile);
				workbook1 = new XSSFWorkbook(fis);
				//데이터를 넣을 인덱스 정보를 저장 시켜서 각 파일을 처리.. 
				sheet = new ArrayList<>();
				//시트 3개 저장
				for (int j = 0; j < 3; j++) {
					sheet.add(workbook1.getSheetAt(j));
				}
				//시트개수만큼 반복하면서 시트 데이터가 들어갈 위치의 셀에 데이터 저장
				for (int j = 0; j < sheet.size(); j++) {
					if(j==0){
						sheet.get(j).getRow(3).getCell(2).setCellValue(object.getCompanyName());
						sheet.get(j).getRow(4).getCell(2).setCellValue(object.getCompanyNo());
						sheet.get(j).getRow(5).getCell(2).setCellValue(object.getOwnerName());
						sheet.get(j).getRow(6).getCell(2).setCellValue(object.getAddress());
						sheet.get(j).getRow(7).getCell(2).setCellValue(object.getPhoneNumber());
						sheet.get(j).getRow(8).getCell(2).setCellValue(object.getFax());
					}else{
						//2,20부터  2,31 -3,6
						for (int k =0; k < object.getCompanyNo().trim().length(); k++) {
							if(k==3 || k==6){
								continue;
							}else{
								sheet.get(j).getRow(2).getCell(k+20).setCellFormula(sheet.get(j).getRow(2).getCell(k+20).getCellFormula());
							}
						}
						sheet.get(j).getRow(4).getCell(20).setCellFormula(sheet.get(j).getRow(4).getCell(20)+"");
						sheet.get(j).getRow(4).getCell(28).setCellFormula(sheet.get(j).getRow(4).getCell(28)+"");
						sheet.get(j).getRow(6).getCell(20).setCellFormula(sheet.get(j).getRow(6).getCell(20)+"");
						sheet.get(j).getRow(8).getCell(20).setCellFormula(sheet.get(j).getRow(8).getCell(20)+"");
						sheet.get(j).getRow(8).getCell(27).setCellFormula(sheet.get(j).getRow(8).getCell(27)+"");
						if(j==1){
							for (int k =0; k < object.getCompanyNo().trim().length(); k++) {
								if(k==3 || k==6){
									continue;
								}else{
									sheet.get(j).getRow(26).getCell(k+20).setCellFormula(sheet.get(j).getRow(2).getCell(k+20).getCellFormula());
								}
							}
							sheet.get(j).getRow(28).getCell(20).setCellFormula(sheet.get(j).getRow(4).getCell(20)+"");
							sheet.get(j).getRow(28).getCell(28).setCellFormula(sheet.get(j).getRow(4).getCell(28)+"");
							sheet.get(j).getRow(30).getCell(20).setCellFormula(sheet.get(j).getRow(6).getCell(20)+"");
							sheet.get(j).getRow(32).getCell(20).setCellFormula(sheet.get(j).getRow(8).getCell(20)+"");
							sheet.get(j).getRow(32).getCell(27).setCellFormula(sheet.get(j).getRow(8).getCell(27)+"");
						}
					}
				}
				 FileOutputStream fileOut = new FileOutputStream(xlsxFile);
				 workbook1.write(fileOut);
				System.out.println("거래명세서 Done");
			}else if(DocCustomizing.CORPORATE_CARD == number){
				//딱히 바꿀 부분이 없음...
				System.out.println("법인카드사용내역서");
			}else if(DocCustomizing.TAX_INVOICE == number){
//				System.out.println("세금계산서 바꾸기");
				xlsxFile = new File("C:/Users/lg/Desktop/account/세금계산서.xlsx");
				fis = new FileInputStream(xlsxFile);
				workbook1 = new XSSFWorkbook(fis);
				sheet = new ArrayList<>();
				sheet.add(workbook1.getSheetAt(0));
				
				sheet.get(0).getRow(4).getCell(5).setCellValue(object.getCompanyNo());
				sheet.get(0).getRow(6).getCell(5).setCellValue(object.getCompanyName());
				sheet.get(0).getRow(6).getCell(12).setCellValue(object.getOwnerName());
				sheet.get(0).getRow(8).getCell(5).setCellValue(object.getAddress());
				//업태
				sheet.get(0).getRow(10).getCell(5).setCellValue("업태입력");
				//종목
				sheet.get(0).getRow(10).getCell(12).setCellValue("종목입력");
				
				FileOutputStream fileOut = new FileOutputStream(xlsxFile);
				workbook1.write(fileOut);
				System.out.println("세금계산서 Done");
			}else if(DocCustomizing.BUYER_MANAGEMENT == number){
				
			}else if(DocCustomizing.UNPAYMENT_STATUS == number){
				
			}else if(DocCustomizing.EXPENSE_ACCOUNT == number){
				
			}
		}
		return files;
	}
	

}
