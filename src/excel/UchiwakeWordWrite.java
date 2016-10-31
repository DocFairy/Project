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

public class UchiwakeWordWrite {

	public String write(ArrayList<String[]> room) {

		System.out.println("TorihikiWordWrite()");

		try {
			System.out.println("1");
			// 엑셀파일
			File file = new File("C:/upload/3.xlsx");
			System.out.println("2");
			// 엑셀 파일 오픈
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
			System.out.println("3");
			XSSFSheet sheet1 = wb.getSheetAt(0);
			System.out.println("4");

			System.out.println("5");
			System.out.println("6");

			// ArrayList<String[]> room의 구성은 마지막방 데이터 1개

			System.out.println(room.get(0)[1]); // 여비 교통비
			System.out.println(room.get(0)[2]);
			System.out.println(room.get(0)[3]);
			System.out.println(room.get(0)[4]);

			System.out.println(room.get(1)[1]); // 여비 교통비
			System.out.println(room.get(1)[2]);
			System.out.println(room.get(1)[3]);
			System.out.println(room.get(1)[4]);

			System.out.println(room.get(2)[1]);
			System.out.println(room.get(2)[2]);
			System.out.println(room.get(2)[3]);
			System.out.println(room.get(2)[4]);

			System.out.println(room.get(3)[1]);
			System.out.println(room.get(3)[2]);
			System.out.println(room.get(3)[3]);
			System.out.println(room.get(3)[4]);

			System.out.println(room.get(4)[1]);
			System.out.println(room.get(4)[2]);
			System.out.println(room.get(4)[3]);
			System.out.println(room.get(4)[4]);

			System.out.println(room.get(5)[1]);
			System.out.println(room.get(5)[2]);
			System.out.println(room.get(5)[3]);
			System.out.println(room.get(5)[4]);

			System.out.println("돌아라1");

			XSSFRow row = sheet1.getRow(4); // 짝수로 맞춘다 56에 쓰고 싶으면 4
			XSSFCell cell = row.getCell(2);
			cell.setCellValue(room.get(0)[1]);
			cell = row.getCell(3);
			cell.setCellValue(room.get(0)[2]);
			cell = row.getCell(4);
			cell.setCellValue(room.get(0)[3]);
			cell = row.getCell(5);
			cell.setCellValue(room.get(0)[4]);

			
			
			
			row = sheet1.getRow(5); // 26까지

			for (int i = 1; i < 5; i++) {

				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(1)[i]);

			}
			
			
			for (int i = 6; i < 27; i++) {
				
				row = sheet1.getRow(i);
				
				for (int j = 0; j < 5; j++) {
					
					cell = row.getCell(j + 1);
					cell.setCellValue(room.get(i-4)[j]);
					
				}
				
			}
			
			
			System.out.println("숫자는 다 찍힌건가");
			
			// data0 ~ data22 까지의 5번방을 전부 Int로 바꾸어서 더한뒤에
			String dat0 = room.get(0)[4]; 
			String dat1 = room.get(1)[4]; 
			String dat2 = room.get(2)[4]; 
			String dat3 = room.get(3)[4]; 
			String dat4 = room.get(4)[4]; 
			String dat5 = room.get(5)[4]; 
			String dat6 = room.get(6)[4]; 
			String dat7 = room.get(7)[4];
			String dat8 = room.get(8)[4]; 
			String dat9 = room.get(9)[4]; 
			String dat10 = room.get(10)[4]; 
			String dat11 = room.get(11)[4]; 
			String dat12 = room.get(12)[4]; 
			String dat13 = room.get(13)[4]; 
			String dat14 = room.get(14)[4]; 
			String dat15 = room.get(15)[4]; 
			String dat16 = room.get(16)[4]; 
			String dat17 = room.get(17)[4]; 
			String dat18 = room.get(18)[4]; 
			String dat19 = room.get(19)[4]; 
			String dat20 = room.get(20)[4]; 
			String dat21 = room.get(21)[4]; 
			String dat22 = room.get(22)[4];
			

			dat0 = dat0.trim();
			dat1 = dat1.trim();
			dat2 = dat2.trim();
			dat3 = dat3.trim();
			dat4 = dat4.trim();
			dat5 = dat5.trim();
			dat6 = dat6.trim();
			dat7 = dat7.trim();
			dat8 = dat8.trim();
			dat9 = dat9.trim();
			dat10 = dat10.trim();
			dat11 = dat11.trim();
			dat12 = dat12.trim();
			dat13 = dat13.trim();
			dat14 = dat14.trim();
			dat15 = dat15.trim();
			dat16 = dat16.trim();
			dat17 = dat17.trim();
			dat18 = dat18.trim();
			dat19 = dat19.trim();
			dat20 = dat20.trim();
			dat21 = dat21.trim();
			dat22 = dat22.trim();
			
			System.out.println(dat0);
			System.out.println(dat22);
			System.out.println("너 뭐가 문젠데");
			
			int data0 = Integer.parseInt(dat0);
			
			System.out.println(data0);
			
			
			int data1 = Integer.parseInt(dat1);
			int data2 = Integer.parseInt(dat2);
			int data3 = Integer.parseInt(dat3);
			int data4 = Integer.parseInt(dat4);
			int data5 = Integer.parseInt(dat5);
			int data6 = Integer.parseInt(dat6);
			int data7 = Integer.parseInt(dat7);
			int data8 = Integer.parseInt(dat8);
			int data9 = Integer.parseInt(dat9);
			int data10 = Integer.parseInt(dat10);
			int data11 = Integer.parseInt(dat11);
			int data12 = Integer.parseInt(dat12);
			int data13 = Integer.parseInt(dat13);
			int data14 = Integer.parseInt(dat14);
			int data15 = Integer.parseInt(dat15);
			int data16 = Integer.parseInt(dat16);
			int data17 = Integer.parseInt(dat17);
			int data18 = Integer.parseInt(dat18);
			int data19 = Integer.parseInt(dat19);
			int data20 = Integer.parseInt(dat20);
			int data21 = Integer.parseInt(dat21);
			int data22 = Integer.parseInt(dat22);
			
			System.out.println("어디까지 오는가 보자");

			
			int sum = data0 + data1 +data2 + data3 +data4 + data5 +data6 + data7 +data8 + data9 +
					data10 + data11 +data12 + data13 +data14 + data15 +data16 + data17 +data18 + data19 +
					data20 + data21 + data22;
			
			
			String result = Integer.toString(sum);
			
			System.out.println(result);
			
			
			// 그 값을 다시 스트링으로 바꾸어서 작성하면 된다
			
			row = sheet1.getRow(27);
			
			cell = row.getCell(5);
			cell.setCellValue(result);
			
			

//			row = sheet1.getRow(7); // 26까지
//
//			for (int i = 1; i < 5; i++) {
//
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(3)[i]);
//
//			}
//
//			row = sheet1.getRow(8); // 26까지
//
//			for (int i = 1; i < 5; i++) {
//
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(4)[i]);
//
//			}
//
//			row = sheet1.getRow(9); // 26까지
//
//			for (int i = 1; i < 5; i++) {
//
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(5)[i]);
//
//			}
//
//			row = sheet1.getRow(10); // 26까지
//
//			for (int i = 1; i < 5; i++) {
//
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(6)[i]);
//
//			}
//
//			row = sheet1.getRow(11); // 26까지
//
//			for (int i = 1; i < 5; i++) {
//
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(7)[i]);
//
//			}
//
//			row = sheet1.getRow(12); // 26까지
//
//			for (int i = 1; i < 5; i++) {
//
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(8)[i]);
//
//			}
//
//			row = sheet1.getRow(13); // 26까지
//
//			for (int i = 1; i < 5; i++) {
//
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(9)[i]);
//
//			}

			System.out.println("last !");

			FileOutputStream fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			return "3.xlsx";
		} catch (FileNotFoundException fe) {
			System.out.println("FileNotFoundException >> " + fe.toString());
		} catch (IOException ie) {
			System.out.println("IOException >> " + ie.toString());
		}
		return null;
	}

}