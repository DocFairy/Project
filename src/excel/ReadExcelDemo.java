package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo {
	double a;
	String b;
	XSSFWorkbook c;
	public double number(String save_file,int r, int c){
		try
      {
          FileInputStream file = new FileInputStream(new File("C:/upload/"+save_file));
          //Create Workbook instance holding reference to .xlsx file
          XSSFWorkbook workbook = new XSSFWorkbook(file);
          //Get first/desired sheet from the workbook
          XSSFSheet sheet = workbook.getSheetAt(0);
          XSSFRow row = sheet.getRow(r);
          XSSFCell cell=row.getCell(c);
          a=cell.getNumericCellValue();
          file.close();
      } 
      catch (Exception e) 
      {
          e.printStackTrace();
      }
		return a;
    }
	public String word(String save_file,int r, int c){
		try
      {
          FileInputStream file = new FileInputStream(new File("C:/upload/"+save_file));
          //Create Workbook instance holding reference to .xlsx file
          XSSFWorkbook workbook = new XSSFWorkbook(file);
          //Get first/desired sheet from the workbook
          XSSFSheet sheet = workbook.getSheetAt(2);
          XSSFRow row = sheet.getRow(r);
          XSSFCell cell=row.getCell(c);
          b=cell.getCellFormula();
          file.close();
      } 
      catch (Exception e) 
      {
          e.printStackTrace();
      }
		return b;
    }
	public XSSFWorkbook copy(String save_file){
		FileInputStream file;
		try {
			file = new FileInputStream(new File("C:/upload/"+save_file));
			c = new XSSFWorkbook(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Create Workbook instance holding reference to .xlsx file
        return c;
	}
//		try
//        {
//            FileInputStream file = new FileInputStream(new File("C:/upload/"+save_file));
//            System.out.println("cc");
//            //Create Workbook instance holding reference to .xlsx file
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            System.out.println("dd");
//            //Get first/desired sheet from the workbook
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            System.out.println("ee");
//            XSSFRow row = sheet.getRow(0);
//            XSSFCell cell=row.getCell(0);
//            System.out.println("aa");
//            System.out.println(cell.getStringCellValue());
//           System.out.println("bb");
//            file.close();
//        } 
//        catch (Exception e) 
//        {
//            e.printStackTrace();
//        }
//		return "a";
	
	
/*	public static void main(String[] args) {
		try
        {
            FileInputStream file = new FileInputStream(new File("C:/upload/201610201476893636053.xls"));
            System.out.println("cc");
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            System.out.println("dd");
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            System.out.println("ee");
            XSSFRow row = sheet.getRow(0);
            XSSFCell cell=row.getCell(0);
            System.out.println("aa");
            System.out.println(cell.getStringCellValue());
           System.out.println("bb");
            file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}*/
   public static void main(String[] args) 
    {
        try
        {
            FileInputStream file = new FileInputStream(new File("C:/upload/20161023.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(2);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue());
                            break;
                            
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue());
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
   }
