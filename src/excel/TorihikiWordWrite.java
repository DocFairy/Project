package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TorihikiWordWrite {

	public String write(ArrayList<String[]> room) {
		
		
		
		
		System.out.println("TorihikiWordWrite()");
		
		try {
			System.out.println("1");
			// 엑셀파일
			File file = new File("C:/upload/expensesStatus.xlsx");
			System.out.println("2");
			// 엑셀 파일 오픈
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
			System.out.println("3");
			XSSFSheet sheet1 = wb.getSheetAt(0);
			System.out.println("4");

			System.out.println("5");
			System.out.println("6");
			
			// ArrayList<String[]> room의 구성은 0번방 데이터 2개
			
			// data 0방 데이터 2개
			// data1 ~ data20방 데이터 7개
			System.out.println(room.get(0)[0]);	//	년 월 일
			System.out.println(room.get(0)[1]);
			
			System.out.println(room.get(1)[1]);	//	메뉴바
			System.out.println(room.get(1)[2]);
			System.out.println(room.get(1)[3]);
			System.out.println(room.get(1)[4]);
			
			System.out.println(room.get(2)[1]); //	데이터 -> 여기서부터 중요 ! 
			System.out.println(room.get(2)[2]);
			System.out.println(room.get(2)[3]);
			System.out.println(room.get(2)[4]);
			
			System.out.println(room.get(3)[1]);
			System.out.println(room.get(3)[2]);
			System.out.println(room.get(3)[3]);
			System.out.println(room.get(3)[4]);
			
			
			
			System.out.println("돌아라1");
			XSSFRow row = sheet1.getRow(5); 	// 짝수로 맞춘다 56에 쓰고 싶으면 4
			XSSFCell cell = row.getCell(3);			// 작 성 년 월 일
			cell.setCellValue(room.get(0)[0]);
			cell = row.getCell(10);
			cell.setCellValue(room.get(0)[1]);

			row = sheet1.getRow(7); 	// 짝수로 맞춘다 56에 쓰고 싶으면 4
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(2)[0]);
			
			cell = row.getCell(2);			// 작 성 년 월 일
			cell.setCellValue(room.get(2)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(2)[2]);
			
			cell = row.getCell(5);			// 작 성 년 월 일
			cell.setCellValue(room.get(2)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(2)[4]);
			
			cell = row.getCell(10);			// 작 성 년 월 일
			cell.setCellValue(room.get(2)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(2)[6]);
			
			
			row = sheet1.getRow(8); 	// 짝수로 맞춘다 56에 쓰고 싶으면 4
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(3)[0]);
			
			cell = row.getCell(2);			// 작 성 년 월 일
			cell.setCellValue(room.get(3)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(3)[2]);
			
			cell = row.getCell(5);			// 작 성 년 월 일
			cell.setCellValue(room.get(3)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(3)[4]);
			
			cell = row.getCell(10);			// 작 성 년 월 일
			cell.setCellValue(room.get(3)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(3)[6]);
			
			
			
			row = sheet1.getRow(9); 	// 짝수로 맞춘다 56에 쓰고 싶으면 4
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(4)[0]);
			
			cell = row.getCell(2);			// 작 성 년 월 일
			cell.setCellValue(room.get(4)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(4)[2]);
			
			cell = row.getCell(5);			// 작 성 년 월 일
			cell.setCellValue(room.get(4)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(4)[4]);
			
			cell = row.getCell(10);			// 작 성 년 월 일
			cell.setCellValue(room.get(4)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(4)[6]);
			
			
			row = sheet1.getRow(10); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(5)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(5)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(5)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(5)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(5)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(5)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(5)[6]);
			
			
			
			row = sheet1.getRow(11); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(6)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(6)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(6)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(6)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(6)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(6)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(6)[6]);
			
			
			
			row = sheet1.getRow(12); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(7)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(7)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(7)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(7)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(7)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(7)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(7)[6]);
			
			
			row = sheet1.getRow(13); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(8)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(8)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(8)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(8)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(8)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(8)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(8)[6]);
			
			
			
			row = sheet1.getRow(14); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(9)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(9)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(9)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(9)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(9)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(9)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(9)[6]);
			
			
			
			row = sheet1.getRow(15); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(10)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(10)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(10)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(10)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(10)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(10)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(10)[6]);
			
			
			
			row = sheet1.getRow(16); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(11)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(11)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(11)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(11)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(11)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(11)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(11)[6]);
			
			
			row = sheet1.getRow(17); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(12)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(12)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(12)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(12)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(12)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(12)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(12)[6]);
			
			
			
			row = sheet1.getRow(18); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(13)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(13)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(13)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(13)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(13)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(13)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(13)[6]);
			
			
			
			row = sheet1.getRow(19); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(14)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(14)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(14)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(14)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(14)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(14)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(14)[6]);
			
			
			
			row = sheet1.getRow(20); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(15)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(15)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(15)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(15)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(15)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(15)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(15)[6]);
			
			
			
			row = sheet1.getRow(21); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(16)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(16)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(16)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(16)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(16)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(16)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(16)[6]);
			
			
			row = sheet1.getRow(22); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(17)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(17)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(17)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(17)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(17)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(17)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(17)[6]);
			
			
			
			row = sheet1.getRow(23); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(18)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(18)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(18)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(18)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(18)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(18)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(18)[6]);
			
			
			row = sheet1.getRow(24); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(19)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(19)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(19)[2]);
			
			cell = row.getCell(5);			
			cell.setCellValue(room.get(19)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(19)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(19)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(19)[6]);
			
			
			row = sheet1.getRow(25); 	// 26까지 돌린다.
			System.out.println("돌아라2");
			
			cell = row.getCell(1);
			cell.setCellValue(room.get(20)[0]);
			
			cell = row.getCell(2);			
			cell.setCellValue(room.get(20)[1]);
			
			cell = row.getCell(4);
			cell.setCellValue(room.get(20)[2]);
		
			cell = row.getCell(5);			
			cell.setCellValue(room.get(20)[3]);
			
			cell = row.getCell(6);
			cell.setCellValue(room.get(20)[4]);
			
			cell = row.getCell(10);			
			cell.setCellValue(room.get(20)[5]);
			
			cell = row.getCell(15);
			cell.setCellValue(room.get(20)[6]);
			
			
			
			
			
			
//			cell = row.getCell(4);				 	// 부서명
//			cell.setCellValue(room.get(0)[1]);

//			row = sheet1.getRow(6);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 7; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(1)[i]);
//			}
//			
//			row = sheet1.getRow(7);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(2)[i]);
//			}
//			
//			row = sheet1.getRow(8);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(3)[i]);
//			}
	
			
			System.out.println("4줄까지 변환해봅시다");
			System.out.println("완료^^");

//
//			row = sheet1.getRow(12);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(4)[i]);
//			}
//			
//			row = sheet1.getRow(14);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(5)[i]);
//			}
//			
//			row = sheet1.getRow(16);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(6)[i]);
//			}
//			
//			row = sheet1.getRow(18);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(7)[i]);
//			}
//			
//			System.out.println("8줄까지 변환해봅시다");
//			
//			row = sheet1.getRow(20);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(8)[i]);
//			}
//			
//			row = sheet1.getRow(22);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(9)[i]);
//			}
//			
//			row = sheet1.getRow(24);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(10)[i]);
//			}
//			
//			row = sheet1.getRow(26);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(11)[i]);
//			}
//			
//			
//			System.out.println("12줄까지 변환해봅시다"); 
//			
//			row = sheet1.getRow(28);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(12)[i]);
//			}
//			
//			row = sheet1.getRow(30);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(13)[i]);
//			}
//			
//			row = sheet1.getRow(32);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(14)[i]);
//			}
//			
//			row = sheet1.getRow(34);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(15)[i]);
//			}
//			
//			System.out.println("17줄까지 변환해봅시다");
//			
//			row = sheet1.getRow(36);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(16)[i]);
//			}
			
			
			System.out.println("last !");
			
			

			FileOutputStream fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			return "expensesStatus.xlsx";
		} catch (FileNotFoundException fe) {
			System.out.println("FileNotFoundException >> " + fe.toString());
		} catch (IOException ie) {
			System.out.println("IOException >> " + ie.toString());
		}
		return null;

	}

}