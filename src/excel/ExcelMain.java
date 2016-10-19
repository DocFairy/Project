package excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.naming.ldap.Rdn;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelMain {
 
    public static void main(String[] args) {
    	ReadExcelDemo rd=new ReadExcelDemo();
    	System.out.println(rd.number("20161020.xlsx"));
    	
        // Workbook ����
        Workbook xlsWb = new HSSFWorkbook(); // Excel 2007 ���� ����
        Workbook xlsxWb = new XSSFWorkbook(); // Excel 2007 �̻�
 
        // *** Sheet-------------------------------------------------
        // Sheet ����
        Sheet sheet1 = xlsWb.createSheet("firstSheet");
 
        // �÷� �ʺ� ����
        sheet1.setColumnWidth(0, 10000);
        sheet1.setColumnWidth(9, 10000);
        // ----------------------------------------------------------
         
        // *** Style--------------------------------------------------
        // Cell ��Ÿ�� ����
        CellStyle cellStyle = xlsWb.createCellStyle();
         
        // �� �ٲ�
        cellStyle.setWrapText(true);
         
        // Cell ����, ���� ä���
//        cellStyle.setFillForegroundColor(HSSFColor.LIME.index);
//        cellStyle.setFillPattern(CellStyle.BIG_SPOTS);
         
        Row row = null;
        Cell cell = null;
        //----------------------------------------------------------
         
        // ù ��° ��
        row = sheet1.createRow(0);
         
        // 0-0 = A1
        // 0-1 = B1
        // 0-2 = C1
        
        // ù ��° �ٿ� Cell �����ϱ�-------------
        cell = row.createCell(0);
        cell.setCellValue("근민이");
        cell.setCellStyle(cellStyle); // �� ��Ÿ�� ����
         
        cell = row.createCell(1);
        cell.setCellValue("22");
         
        cell = row.createCell(2);
        cell.setCellValue("33");
        cell.setCellStyle(cellStyle); // �� ��Ÿ�� ����
        //---------------------------------
         
        // �� ��° ��
        row = sheet1.createRow(1);
        
        // 1-0 = A2
        // 1-1 = B2
        // 1-2 = C2
         
        // �� ��° �ٿ� Cell �����ϱ�-------------
        cell = row.createCell(0);
        cell.setCellValue("44");
         
        cell = row.createCell(1);
        cell.setCellValue("55");
         
        cell = row.createCell(2);
        cell.setCellValue("66");
        cell.setCellStyle(cellStyle); // �� ��Ÿ�� ����
        //---------------------------------
        
        row = sheet1.createRow(2);
        
        cell = row.createCell(0);
        cell.setCellValue("77");
        
        cell = row.createCell(1);
        cell.setCellValue("88");
        
        cell = row.createCell(2);
        cell.setCellValue("99");
        
        
        
        // excel ���� ����
        try {
            File xlsFile = new File("D:/확인2.xls");
            FileOutputStream fileOut = new FileOutputStream(xlsFile);
            xlsWb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();;
        }
         
    }
 
}