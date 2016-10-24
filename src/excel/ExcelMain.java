package excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelMain {
	
	public String paste(XSSFWorkbook xw,double st,int r,int c) throws InterruptedException{
		 try {
	            File xlsxFile = new File("C:/upload/integrate.xlsx");
	            FileOutputStream fileOut = new FileOutputStream(xlsxFile);
	            XSSFSheet sheet1=xw.getSheetAt(2);
	            XSSFRow row = sheet1.getRow(r);
	            XSSFCell cell=row.getCell(c);
	            
	            cell.setCellValue(st);
	            cell=row.getCell(c-1);
	            cell.setCellValue(2);
	            xw.write(fileOut);
	            fileOut.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 return "integrate.xlsx";
	}
	
	public String makeinter(String word,double value){	 
        // Workbook 생성
        Workbook xlsWb = new HSSFWorkbook(); // Excel 2007 이전 버전
        Workbook xlsxWb = new XSSFWorkbook(); // Excel 2007 이상
        // *** Sheet-------------------------------------------------
        // Sheet 생성
        Sheet sheet1 = xlsxWb.createSheet("firstSheet");
        // 컬럼 너비 설정
        sheet1.setColumnWidth(0, 10000);
        sheet1.setColumnWidth(9, 10000);
        // ----------------------------------------------------------        
        // *** Style--------------------------------------------------
        // Cell 스타일 생성
        CellStyle cellStyle = xlsxWb.createCellStyle();
         
        // 줄 바꿈
        cellStyle.setWrapText(true);
         
        // Cell 색깔, 무늬 채우기
//        cellStyle.setFillForegroundColor(HSSFColor.LIME.index);
//        cellStyle.setFillPattern(CellStyle.BIG_SPOTS);
         
        Row row = null;
        Cell cell = null;
        //----------------------------------------------------------
         
        // 첫 번째 줄
        row = sheet1.createRow(0);
         
        // 0-0 = A1
        // 0-1 = B1
        // 0-2 = C1
        
        // 첫 번째 줄에 Cell 설정하기-------------
        cell = row.createCell(0);
        cell.setCellValue(word);
        cell.setCellStyle(cellStyle); // 셀 스타일 적용
         
        cell = row.createCell(1);
        cell.setCellValue(value);
         
//        cell = row.createCell(2);
//        cell.setCellValue("쵸파");
//        cell.setCellStyle(cellStyle); // 셀 스타일 적용
        //---------------------------------
         
        // 두 번째 줄
//        row = sheet1.createRow(1);
//        
//        // 1-0 = A2
//        // 1-1 = B2
//        // 1-2 = C2
//         
//        // 두 번째 줄에 Cell 설정하기-------------
//        cell = row.createCell(0);
//        cell.setCellValue("조로");
//         
//        cell = row.createCell(1);
//        cell.setCellValue("브룩");
//         
//        cell = row.createCell(2);
//        cell.setCellValue("상디");
//        cell.setCellStyle(cellStyle); // 셀 스타일 적용
        //---------------------------------
        
//        row = sheet1.createRow(2);
//        
//        cell = row.createCell(0);
//        cell.setCellValue("나미");
//        
//        cell = row.createCell(1);
//        cell.setCellValue("로빈");
//        
//        cell = row.createCell(2);
//        cell.setCellValue("프랑키");
        
        
        
        // excel 파일 저장
        try {
            File xlsxFile = new File("C:/upload/integrate.xlsx");
            FileOutputStream fileOut = new FileOutputStream(xlsxFile);
            xlsxWb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         return "integrate.xlsx";
    }
}
 
//    public static void main(String[] args) {
//         
//        // Workbook 생성
//        Workbook xlsWb = new HSSFWorkbook(); // Excel 2007 이전 버전
//        Workbook xlsxWb = new XSSFWorkbook(); // Excel 2007 이상
// 
//        // *** Sheet-------------------------------------------------
//        // Sheet 생성
//        Sheet sheet1 = xlsxWb.createSheet("firstSheet");
// 
//        // 컬럼 너비 설정
//        sheet1.setColumnWidth(0, 10000);
//        sheet1.setColumnWidth(9, 10000);
//        // ----------------------------------------------------------
//         
//        // *** Style--------------------------------------------------
//        // Cell 스타일 생성
//        CellStyle cellStyle = xlsxWb.createCellStyle();
//         
//        // 줄 바꿈
//        cellStyle.setWrapText(true);
//         
//        // Cell 색깔, 무늬 채우기
////        cellStyle.setFillForegroundColor(HSSFColor.LIME.index);
////        cellStyle.setFillPattern(CellStyle.BIG_SPOTS);
//         
//        Row row = null;
//        Cell cell = null;
//        //----------------------------------------------------------
//         
//        // 첫 번째 줄
//        row = sheet1.createRow(0);
//         
//        // 0-0 = A1
//        // 0-1 = B1
//        // 0-2 = C1
//        
//        // 첫 번째 줄에 Cell 설정하기-------------
//        cell = row.createCell(0);
//        cell.setCellValue("핸콕");
//        cell.setCellStyle(cellStyle); // 셀 스타일 적용
//         
//        cell = row.createCell(1);
//        cell.setCellValue("루피");
//         
//        cell = row.createCell(2);
//        cell.setCellValue("쵸파");
//        cell.setCellStyle(cellStyle); // 셀 스타일 적용
//        //---------------------------------
//         
//        // 두 번째 줄
//        row = sheet1.createRow(1);
//        
//        // 1-0 = A2
//        // 1-1 = B2
//        // 1-2 = C2
//         
//        // 두 번째 줄에 Cell 설정하기-------------
//        cell = row.createCell(0);
//        cell.setCellValue("조로");
//         
//        cell = row.createCell(1);
//        cell.setCellValue("브룩");
//         
//        cell = row.createCell(2);
//        cell.setCellValue("상디");
//        cell.setCellStyle(cellStyle); // 셀 스타일 적용
//        //---------------------------------
//        
//        row = sheet1.createRow(2);
//        
//        cell = row.createCell(0);
//        cell.setCellValue("나미");
//        
//        cell = row.createCell(1);
//        cell.setCellValue("로빈");
//        
//        cell = row.createCell(2);
//        cell.setCellValue("프랑키");
//        
//        
//        
//        // excel 파일 저장
//        try {
//            File xlsxFile = new File("D:/해적단.xls");
//            FileOutputStream fileOut = new FileOutputStream(xlsxFile);
//            xlsxWb.write(fileOut);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//         
//    }
//}