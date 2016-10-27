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
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import vo.DocCustomizing;


public class OpenExcelFile {
   public File createExcelDoc(DocCustomizing object, String arr) throws Exception{
      File xlsxFile = new File("C:/FinalProject/거래명세표 (자동입력).xlsx");
     System.out.println("1");
      FileInputStream fis = new FileInputStream(xlsxFile);
      System.out.println("2"); 
      Workbook workbook1 = new XSSFWorkbook(fis);
      System.out.println("3"); 
//      ArrayList<Sheet> sheet = new ArrayList<>(workbook1.getNumberOfSheets());
      ArrayList<Sheet> sheet= null;
      System.out.println("4"); 
      String[] access = new String[arr.split(",").length];
      System.out.println("5"); 
      File file = null;
      System.out.println("6");
      for(int i=0; i<access.length; i++){
         access[i] = arr.split(",")[i];
      }
      System.out.println("7");
      for (int i=0; i<access.length; i++) {
         int number = Integer.parseInt(access[i]);
         if(DocCustomizing.STATEMENT_OF_ACCOUNT == number){
            //데이터를 넣을 인덱스 정보를 저장 시켜서 각 파일을 처리.. 
            //상호명
            sheet = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
               sheet.add(workbook1.getSheetAt(j));
            }
            System.out.println("8");     
            for (int j = 0; j < sheet.size(); j++) {
               if(j==0){
                  sheet.get(j).getRow(3).getCell(2).setCellValue(object.getCompanyName());
                  sheet.get(j).getRow(4).getCell(2).setCellValue(object.getCompanyNo());
                  sheet.get(j).getRow(5).getCell(2).setCellValue(object.getOwnerName());
                  sheet.get(j).getRow(6).getCell(2).setCellValue(object.getAddress());
                  sheet.get(j).getRow(7).getCell(2).setCellValue(object.getPhoneNumber());
                  sheet.get(j).getRow(8).getCell(2).setCellValue(object.getFax());
                  System.out.println("sheet1");
               }
               else{
                  sheet.get(j).getRow(4).getCell(20).setCellFormula(sheet.get(j).getRow(4).getCell(20)+"");
                  //2,20부터  2,31 -3,6
//                  for (int k = 0; k < object.getCompanyNo().length(); k++) {
//                     sheet.get(j).getRow(2).getCell(k+20).setCellFormula(sheet.get(j).getRow(2).getCell(k+20)+"");
//                  }
                  sheet.get(j).getRow(4).getCell(20).setCellFormula(sheet.get(j).getRow(4).getCell(20)+"");
                  sheet.get(j).getRow(4).getCell(28).setCellFormula(sheet.get(j).getRow(4).getCell(28)+"");
                  sheet.get(j).getRow(6).getCell(20).setCellFormula(sheet.get(j).getRow(6).getCell(20)+"");
                  sheet.get(j).getRow(8).getCell(20).setCellFormula(sheet.get(j).getRow(8).getCell(20)+"");
                  sheet.get(j).getRow(8).getCell(27).setCellFormula(sheet.get(j).getRow(8).getCell(27)+"");
               }
            }
         }else if(DocCustomizing.CORPORATE_CARD == number){
            System.out.println("법인카드사용내역서");
         }else if(DocCustomizing.TAX_INVOICE == number){
            System.out.println("세금명세표 바꾸기");
         }
      }
       try {
          
               FileOutputStream fileOut = new FileOutputStream(xlsxFile);
               workbook1.write(fileOut);
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
      return file;
   }
   

}