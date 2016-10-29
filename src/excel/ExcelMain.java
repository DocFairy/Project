package excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
	
	public String paste(XSSFWorkbook xw,ArrayList<ArrayList>db,ArrayList<ArrayList> st,String type){
		 try {
			 	ReadExcelDemo re=new ReadExcelDemo();
	            File xlsxFile = new File("C:/upload/integrate.xlsx");
	            FileOutputStream fileOut = new FileOutputStream(xlsxFile);
	            System.out.println("1");
	            if(type.equals("거래명세서")){
	            input(xw,8,4).setCellValue((double)db.get(0).get(0));
	            input(xw,35,25).setCellValue((double)db.get(0).get(0));
	            input(xw,36,24).setCellValue((double)db.get(0).get(0));
	            input(xw,1,0).setCellValue((String)st.get(0).get(0));
	            XSSFSheet sheet = xw.getSheetAt(0);
	            int h=0;
	            System.out.println("3");
	            for(int i=11;i<34;i++){
	            	 XSSFRow row = sheet.getRow(i);
	            	 XSSFCell cell=row.getCell(2);
	            	 if(cell.getStringCellValue().equals("")){
	            		 h=i;
	            		 System.out.println(h);
	            		 break;
	            	 }
	            }
	            System.out.println((String)st.get(2).get(0));
	           
	            for(int i=h;i<db.get(1).size()+h;i++){
	            	input(xw,i,0).setCellValue((double)db.get(1).get(i-h));//월
	            	input(xw,i,1).setCellValue((double)db.get(2).get(i-h));//일
	            	input(xw,i,2).setCellValue((String)st.get(1).get(i-h));//품목명
	            	input(xw,i,13).setCellValue((String)st.get(2).get(i-h));//규격
	            	input(xw,i,16).setCellValue((double)db.get(3).get(i-h));//수량
	            	input(xw,i,19).setCellValue((double)db.get(4).get(i-h));//단가
	            	input(xw,i,25).setCellValue((double)db.get(5).get(i-h));//수량*단가(금액)
	            }
	
	            xw.write(fileOut);
	            fileOut.close();
	            }else if(type.equals("가계부")){
	            	XSSFSheet sheet = xw.getSheetAt(0);
		            int h=0;
		            System.out.println("3");
		            for(int i=5;i<29;i++){
		            	 XSSFRow row = sheet.getRow(i);
		            	 XSSFCell cell=row.getCell(2);
		            	 if(cell.getStringCellValue().equals("")){
		            		 h=i;
		            		 System.out.println(h);
		            		 break;
		            	 }
		            }
		            System.out.println((String)st.get(0).get(0));
		            for(int i=h;i<db.get(1).size()+h;i++){
		            	input(xw,i,2).setCellValue((String)st.get(0).get(i-h));//월
		            	input(xw,i,3).setCellValue((String)st.get(1).get(i-h));//품목
		            	input(xw,i,4).setCellValue((double)db.get(0).get(i-h));//수량
		            	input(xw,i,5).setCellValue((double)db.get(1).get(i-h));//단가
		            	input(xw,i,6).setCellValue((String)st.get(2).get(i-h));//규격
		            }
		            xw.setForceFormulaRecalculation(true);
		            xw.write(fileOut);
		            fileOut.close();
	            }else if(type.equals("지급어음명세서")){
	            	XSSFSheet sheet = xw.getSheetAt(0);
		            int h=0;
		            System.out.println("3");
		            for(int i=8;i<41;i++){
		            	 XSSFRow row = sheet.getRow(i);
		            	 XSSFCell cell=row.getCell(1);
		            	 if(cell.getStringCellValue().equals("")){
		            		 h=i;
		            		 System.out.println(h);
		            		 break;
		            	 }
		            }
		            for(int i=h;i<db.get(0).size()+h;i++){
		            	input(xw,i,1).setCellValue((String)st.get(0).get(i-h));//월
		            	input(xw,i,2).setCellValue((String)st.get(1).get(i-h));//품목
		            	input(xw,i,3).setCellValue((String)st.get(2).get(i-h));//수량
		            	input(xw,i,4).setCellValue((String)st.get(3).get(i-h));//단가
		            	input(xw,i,5).setCellValue((double)db.get(0).get(i-h));//규격
		            	input(xw,i,6).setCellValue((String)st.get(4).get(i-h));
		            	input(xw,i,7).setCellValue((String)st.get(5).get(i-h));
		            	input(xw,i,8).setCellValue((String)st.get(6).get(i-h));
		            }
		            xw.setForceFormulaRecalculation(true);
		            xw.write(fileOut);
		            fileOut.close();
	            }else if(type.equals("거래관리대장")){
	            	XSSFSheet sheet = xw.getSheetAt(0);
		            int h=0;
		            System.out.println("3");
		            for(int i=6;i<35;i++){
		            	 XSSFRow row = sheet.getRow(i);
		            	 XSSFCell cell=row.getCell(1);
		            	 if(cell.getStringCellValue().equals("")){
		            		 h=i;
		            		 System.out.println(h);
		            		 break;
		            	 }
		            }
		            for(int i=h;i<db.get(0).size()+h;i++){
		            	input(xw,i,1).setCellValue((String)st.get(0).get(i-h));//월
		            	input(xw,i,2).setCellValue((String)st.get(1).get(i-h));//품목
		            	input(xw,i,3).setCellValue((String)st.get(2).get(i-h));//수량
		            	input(xw,i,4).setCellValue((double)db.get(0).get(i-h));//단가
		            	input(xw,i,5).setCellValue((double)db.get(1).get(i-h));//규격
		            	input(xw,i,7).setCellValue((double)db.get(2).get(i-h));
		            	input(xw,i,8).setCellValue((double)db.get(3).get(i-h));
		            	input(xw,i,10).setCellValue((double)db.get(4).get(i-h));
		            	input(xw,i,11).setCellValue((double)db.get(5).get(i-h));
		            	input(xw,i,13).setCellValue((String)st.get(3).get(i-h));
		            }
		            xw.setForceFormulaRecalculation(true);
		            xw.write(fileOut);
		            fileOut.close();
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 return "integrate.xlsx";
	}
	public XSSFCell input(XSSFWorkbook xw,int r,int c){
		 XSSFSheet sheet1=xw.getSheetAt(0);
		 XSSFRow row=sheet1.getRow(r);
		 XSSFCell cell=row.getCell(c);
		 cell.setCellValue("");
		 return cell;
	}
	public String pasteAccount(XSSFWorkbook xw,String date, String[] content, String[] in, String[] out, String[] note){
		 try {
	            File xlsxFile = new File("C:/upload/" + date + "의 가계부.xlsx");
	            FileOutputStream fileOut = new FileOutputStream(xlsxFile);
	            XSSFSheet sheet1=xw.getSheetAt(0);
	            
	          
	            /*for(int i = 0 ; i < content.length; i++){
	        	    row = sheet1.createRow(i+4);
	        	    
	        	    cell = row.createCell(2);
	        	    cell.setCellValue(date);
	        	    
	        	    cell = row.createCell(3);
	        	    cell.setCellValue(content[i]);
	        	    
	        	    cell = row.createCell(4);
	        	    cell.setCellValue(in[i]);

	        	    cell = row.createCell(5);
	        	    cell.setCellValue(out[i]);
	        	    
	        	    cell = row.createCell(6);
	        	    cell.setCellValue(note[i]);
	        	    
	        	    }*/
	            for(int i = 0; i < content.length ; i++){
	            XSSFRow row = sheet1.getRow(i+5);
	           
	            XSSFCell cell=row.getCell(2);
	            cell.setCellValue(date);

	            cell = row.getCell(3);
	            cell.setCellValue(content[i]);
	            
	            cell = row.getCell(4);
	            cell.setCellValue(in[i]);
	            
	            cell = row.getCell(5);
	            cell.setCellValue(out[i]);
	            
	            cell = row.getCell(6);
	            cell.setCellValue(note[i]);
	            }
	            xw.write(fileOut);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 return date + "의 가계부.xlsx";
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
	
	public String makeArray(String date, String[] content, String[] in, String[] out, String[] note){	 
	    // Workbook 생성
	    Workbook xlsWb = new HSSFWorkbook(); // Excel 2007 이전 버전
	    Workbook xlsxWb = new XSSFWorkbook(); // Excel 2007 이상
	    // *** Sheet-------------------------------------------------
	    // Sheet 생성
	    Sheet sheet1 = xlsxWb.createSheet("firstSheet");
	  
	    // 컬럼 너비 설정
	  //  sheet1.setColumnWidth(0, 10000);
	  //  sheet1.setColumnWidth(9, 10000);
	    // ----------------------------------------------------------        
	    // *** Style--------------------------------------------------
	    // Cell 스타일 생성
	    CellStyle cellStyle = xlsxWb.createCellStyle();
	     
	    // 줄 바꿈
	    cellStyle.setWrapText(true);
	     
	    // Cell 색깔, 무늬 채우기
	   cellStyle.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
	   // cellStyle.setFillPattern(CellStyle.ALIGN_CENTER);
	     
	    Row row = null;
	    Cell cell = null;
	    //----------------------------------------------------------
	     
	    // 첫 번째 줄
	    row = sheet1.createRow(0);
	     
	    // 0-0 = A1
	    // 0-1 = B1
	    // 0-2 = C1
	    
	   
	    
	    
	    for(int i = 0 ; i < content.length; i++){
	    row = sheet1.createRow(i+4);
	    
	    cell = row.createCell(2);
	    cell.setCellValue(date);
	    
	    cell = row.createCell(3);
	    cell.setCellValue(content[i]);
	    
	    cell = row.createCell(4);
	    cell.setCellValue(in[i]);

	    cell = row.createCell(5);
	    cell.setCellValue(out[i]);
	    
	    cell = row.createCell(6);
	    cell.setCellValue(note[i]);
	    
	    }
	    
	/*  
	    //세번째 줄
	    row = sheet1.createRow(2);
	    
	    //세번째 줄에 Cell 설정하기 --------------------
	    cell = row.createCell(0);
	    cell.setCellValue(date);
	    
	    cell = row.createCell(1);
	    cell.setCellValue(content[1]);
	    
	    cell = row.createCell(2);
	    cell.setCellValue(in[1]);
	    
	    cell = row.createCell(3);
	    cell.setCellValue(out[1]);
	    
	    cell = row.createCell(4);
	    cell.setCellValue(note[1]);;
	 */   
	    
	    // excel 파일 저장
	    try {
	        File xlsxFile = new File("C:/upload/" + date + "의 가계부.xlsx");
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
