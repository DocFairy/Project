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

public class ExcelReadWrite {

	// public static void main(String[] args) {
	//
	// try {
	// // 엑셀파일
	// File file = new File("C:/upload/20161026.xlsx");
	//
	// // 엑셀 파일 오픈
	// XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
	//
	// XSSFSheet sheet1 = wb.getSheetAt(0);
	//
	// XSSFRow row = sheet1.getRow(4); // 짝수로 맞춘다 56에 쓰고 싶으면 4
	//
	//
	// XSSFCell cell = row.getCell(1); // 통일이 되게 해준다
	//
	// cell = row.getCell(1); // 통일이 되게 해준다
	//
	// cell.setCellValue("aaaaaaa");
	//
	//
	// cell = row.getCell(2); // 통일이 되게 해준다
	//
	// cell = row.getCell(2); // 통일이 되게 해준다
	//
	// cell.setCellValue("aaaaaaa");
	//
	//
	// cell = row.getCell(3); // 통일이 되게 해준다
	//
	// cell = row.getCell(3); // 통일이 되게 해준다
	//
	// cell.setCellValue("aaaaaaa");
	//
	//
	// cell = row.getCell(4); // 통일이 되게 해준다
	//
	// cell = row.getCell(4); // 통일이 되게 해준다
	//
	// cell.setCellValue("뭐냐 ㅡㅡ");
	//
	//
	// cell = row.getCell(5); // 통일이 되게 해준다
	//
	// cell = row.getCell(5); // 통일이 되게 해준다
	//
	// cell.setCellValue("aaaaaaa");
	//
	//
	// // cell = row.getCell(6); // 통일이 되게 해준다
	// //
	// // cell = row.getCell(6); // 통일이 되게 해준다
	// //
	// // cell.setCellValue(data[5]);
	// //
	// //
	// // cell = row.getCell(7); // 통일이 되게 해준다
	// //
	// // cell = row.getCell(7); // 통일이 되게 해준다
	// //
	// // cell.setCellValue(data[6]);
	// //
	// //
	// // cell = row.getCell(8); // 통일이 되게 해준다
	// //
	// // cell = row.getCell(8); // 통일이 되게 해준다
	// //
	// // cell.setCellValue(data[7]);
	// //
	// //
	// // cell = row.getCell(9); // 통일이 되게 해준다
	// //
	// // cell = row.getCell(9); // 통일이 되게 해준다
	// //
	// // cell.setCellValue(data[8]);
	// //
	// //
	// // cell = row.getCell(10); // 통일이 되게 해준다
	// //
	// // cell = row.getCell(10); // 통일이 되게 해준다
	// //
	// // cell.setCellValue(data[9]);
	// //
	// //
	// // cell = row.getCell(11); // 통일이 되게 해준다
	// //
	// // cell = row.getCell(11); // 통일이 되게 해준다
	// //
	// // cell.setCellValue(data[10]);
	//
	//
	//
	// // 엑셀 파일 저장
	// FileOutputStream fileOut = new FileOutputStream(file);
	// wb.write(fileOut);
	//
	// } catch (FileNotFoundException fe) {
	// System.out.println("FileNotFoundException >> " + fe.toString());
	// } catch (IOException ie) {
	// System.out.println("IOException >> " + ie.toString());
	// }
	// }

	// public static void main(String[] args) {
	//
	// ExcelReadWrite erw = new ExcelReadWrite();
	// String[] data = null;
	// erw.write(data);
	//
	// }

	public String write(ArrayList<String[]> room) {
		
			System.out.println("왜 안들어오징");
		
		try {
			System.out.println("1");
			// 엑셀파일
			File file = new File("C:/upload/currentStatus.xlsx");
			System.out.println("2");
			// 엑셀 파일 오픈
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
			System.out.println("3");
			XSSFSheet sheet1 = wb.getSheetAt(0);
			System.out.println("4");

			// for (int i = 0; i < 11; i++) {
			//
			// XSSFCell cell = row.getCell(i + 1);
			// cell = row.getCell(i + 1);
			// cell.setCellValue(data[i]);
			// if(i>=10){
			// cell = row.getCell(12);
			// cell.setCellValue(" ");
			// }
			// }
			
			System.out.println("5");
			System.out.println("6");

			XSSFRow row = sheet1.getRow(4); // 짝수로 맞춘다 56에 쓰고 싶으면 4
			XSSFCell cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(0)[i]);
			}


			row = sheet1.getRow(6);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(1)[i]);
			}
			
			row = sheet1.getRow(8);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(2)[i]);
			}
			
			row = sheet1.getRow(10);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(3)[i]);
			}
			
			
			System.out.println("4줄까지 변환해봅시다");
			System.out.println("완료^^");


			row = sheet1.getRow(12);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(4)[i]);
			}
			
			row = sheet1.getRow(14);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(5)[i]);
			}
			
			row = sheet1.getRow(16);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(6)[i]);
			}
			
			row = sheet1.getRow(18);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(7)[i]);
			}
			
			System.out.println("8줄까지 변환해봅시다");
			
			row = sheet1.getRow(20);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(8)[i]);
			}
			
			row = sheet1.getRow(22);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(9)[i]);
			}
			
			row = sheet1.getRow(24);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(10)[i]);
			}
			
			row = sheet1.getRow(26);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(11)[i]);
			}
			
			
			System.out.println("12줄까지 변환해봅시다"); 
			
			row = sheet1.getRow(28);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(12)[i]);
			}
			
			row = sheet1.getRow(30);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(13)[i]);
			}
			
			row = sheet1.getRow(32);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(14)[i]);
			}
			
			row = sheet1.getRow(34);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(15)[i]);
			}
			
			
			
			
			
			System.out.println("17줄까지 변환해봅시다");
			
			row = sheet1.getRow(36);
			cell = row.getCell(1);

			for (int i = 0; i < 11; i++) {
				cell = row.getCell(i + 1);
				cell.setCellValue(room.get(16)[i]);
			}
			
			
			
			
			
			System.out.println("last !");
//			
//			row = sheet1.getRow(38);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(17)[i]);
//			}
//			
//			row = sheet1.getRow(40);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(18)[i]);
//			}
//			
//			row = sheet1.getRow(42);
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(19)[i]);
//			}
			
			
			System.out.println("변환");
			System.out.println("변환");
			System.out.println("변환");
			System.out.println("변환");
			System.out.println("변환");
			
			

//			//
//			
//			row = sheet1.getRow(2 * 4);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(2)[i]);
//			}
//			
//			row = sheet1.getRow(2 * 5);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(3)[i]);
//			}
//			
//			row = sheet1.getRow(2 * 6);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(4)[i]);
//			}
//			
//			row = sheet1.getRow(2 * 7);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(5)[i]);
//			}
//			
//			row = sheet1.getRow(2 * 8);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(6)[i]);
//			}
//			
//			
//			row = sheet1.getRow(2 * 9);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(7)[i]);
//			}
//			
//			
//			row = sheet1.getRow(2 * 10);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(8)[i]);
//			}
//			
//			
//			row = sheet1.getRow(2 * 11);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(9)[i]);
//			}
//			
//			row = sheet1.getRow(2 * 12);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(10)[i]);
//			}
//			
//			
//			row = sheet1.getRow(2 * 13);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(11)[i]);
//			}
//			
//			row = sheet1.getRow(2 * 14);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(12)[i]);
//			}
//			
//			
//			row = sheet1.getRow(2 * 15);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(13)[i]);
//			}
//			
//			
//			row = sheet1.getRow(2 * 16);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(14)[i]);
//			}
//			
//			
//			row = sheet1.getRow(2 * 17);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(15)[i]);
//			}
//			
//			
//			row = sheet1.getRow(2 * 18);
//
//			cell = row.getCell(1);
//
//			for (int i = 0; i < 11; i++) {
//				cell = row.getCell(i + 1);
//				cell.setCellValue(room.get(16)[i]);
//			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			for (int j = 2; j < 21; j++) {
//				row = sheet1.getRow(2 * (j + 1));
//				for (int i = 0; i < 11; i++) {
//					for (int k = 1; k < 17; k++) {						
//						cell = row.getCell(i + 1);
//						cell.setCellValue(room.get(k)[i]);
//					}
//					
//					}
//
//			}

			//
			// //
			// row = sheet1.getRow(10);
			//
			// cell = row.getCell(1);
			//
			// for (int i = 0; i < 11; i++) {
			// cell = row.getCell(i + 1);
			// cell.setCellValue(room.get(3)[i]);
			// }
			// //
			//
			// //
			// row = sheet1.getRow(12);
			//
			// cell = row.getCell(1);
			//
			// for (int i = 0; i < 11; i++) {
			// cell = row.getCell(i + 1);
			// cell.setCellValue(room.get(4)[i]);
			// }
			// //
			//
			// //
			//
			// row = sheet1.getRow(14);
			//
			// cell = row.getCell(1);
			//
			// for (int i = 0; i < 11; i++) {
			// cell = row.getCell(i + 1);
			// cell.setCellValue(room.get(5)[i]);
			// }
			// //

			// cell = row.getCell(1);
			// cell.setCellValue(data[0]);
			//
			// cell = row.getCell(2);
			// cell.setCellValue(data[1]);
			//
			// cell = row.getCell(3);
			// cell.setCellValue(data[2]);
			//
			// cell = row.getCell(4);
			// cell.setCellValue(data[3]);
			//
			// cell = row.getCell(5);
			// cell.setCellValue(data[4]);
			//
			// cell = row.getCell(6);
			// cell.setCellValue(data[5]);
			//
			// cell = row.getCell(7);
			// cell.setCellValue(data[6]);
			//
			// cell = row.getCell(8);
			// cell.setCellValue(data[7]);
			//
			// cell = row.getCell(9);
			// cell.setCellValue(data[8]);
			// System.out.println("7");
			//
			// System.out.println(data[9]);
			//
			// cell = row.getCell(10);
			// cell.setCellValue(data[9]);
			// System.out.println("8");
			//
			// cell = row.getCell(11);
			// cell.setCellValue(data[10]);
			System.out.println("9");

			// for (int i = 1; i < 11; i++) {
			//
			// cell = row.getCell(i+1);
			// cell.setCellValue(data[i]);
			//
			// }

			// System.out.println("7");
			//
			// cell = row.getCell(1);
			// cell = row.getCell(1);
			// cell.setCellValue(data[2]);
			//
			// System.out.println("8");

			// for (int i = 1; i < 11; i++) {
			//
			// cell = row.getCell(i+1);
			// cell.setCellValue(data[i]);
			//
			// }

			System.out.println("10");

			System.out.println("11");

			// cell = row.getCell(3); // 통일이 되게 해준다
			//
			// cell = row.getCell(3); // 통일이 되게 해준다
			//
			// cell.setCellValue(data[2]);
			//
			// cell = row.getCell(4); // 통일이 되게 해준다
			//
			// cell = row.getCell(4); // 통일이 되게 해준다
			//
			// cell.setCellValue(data[3]);
			//
			// cell = row.getCell(5); // 통일이 되게 해준다
			//
			// cell = row.getCell(5); // 통일이 되게 해준다
			//
			// cell.setCellValue(data[4]);
			//
			// cell = row.getCell(6); // 통일이 되게 해준다
			//
			// cell = row.getCell(6); // 통일이 되게 해준다
			//
			// cell.setCellValue(data[5]);
			//
			// cell = row.getCell(7); // 통일이 되게 해준다
			//
			// cell = row.getCell(7); // 통일이 되게 해준다
			//
			// cell.setCellValue(data[6]);
			//
			// cell = row.getCell(8); // 통일이 되게 해준다
			//
			// cell = row.getCell(8); // 통일이 되게 해준다
			//
			// cell.setCellValue(data[7]);
			//
			// cell = row.getCell(9); // 통일이 되게 해준다
			//
			// cell = row.getCell(9); // 통일이 되게 해준다
			//
			// cell.setCellValue(data[8]);
			//
			// cell = row.getCell(10); // 통일이 되게 해준다
			//
			// cell = row.getCell(10); // 통일이 되게 해준다
			//
			// cell.setCellValue(data[9]);
			//
			// cell = row.getCell(11); // 통일이 되게 해준다
			//
			// cell = row.getCell(11); // 통일이 되게 해준다
			//
			// cell.setCellValue("bbbbbbbbbbbb");

			// 엑셀 파일 저장

			FileOutputStream fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			return "currentStatus.xlsx";
		} catch (FileNotFoundException fe) {
			System.out.println("FileNotFoundException >> " + fe.toString());
		} catch (IOException ie) {
			System.out.println("IOException >> " + ie.toString());
		}
		return null;
	}

}