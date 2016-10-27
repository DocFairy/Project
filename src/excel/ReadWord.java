package excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ReadWord {

	public ArrayList<String[]> readWord(String save_filename) {

		try {
			FileInputStream fis = new FileInputStream("C:/Upload/" + save_filename);
			// read header

			XWPFDocument document = new XWPFDocument(fis);

			List<XWPFParagraph> paragraphs = document.getParagraphs();

			System.out.println("Total no of paragraph " + paragraphs.size());
			for (XWPFParagraph para : paragraphs) {
				System.out.println(para.getText());
			}
			fis.close();

			
			
			List<XWPFTable> table = document.getTables();
			
			

			for (XWPFTable xwpfTable : table) {
				
				List<XWPFTableRow> row = xwpfTable.getRows();
				
				
				
//				System.out.println(row.get(2).getTableCells().get(0).getText());
//				System.out.println(row.get(2).getTableCells().get(1).getText());
//				System.out.println(row.get(2).getTableCells().get(2).getText());
//				System.out.println(row.get(2).getTableCells().get(3).getText());
//				System.out.println(row.get(2).getTableCells().get(4).getText());
//				System.out.println(row.get(2).getTableCells().get(5).getText());
//				System.out.println(row.get(2).getTableCells().get(6).getText());
//				System.out.println(row.get(2).getTableCells().get(7).getText());
//				System.out.println(row.get(2).getTableCells().get(8).getText());
//				System.out.println(row.get(2).getTableCells().get(9).getText());
//				System.out.println(row.get(2).getTableCells().get(10).getText());

				ArrayList<String[]> room = new ArrayList<>();
				
				String[] data1 = new String[11];
				String[] data2 = new String[11];
				String[] data3 = new String[11];
				String[] data4 = new String[11];
				String[] data5 = new String[11];
				String[] data6 = new String[11];
				String[] data7 = new String[11];
				String[] data8 = new String[11];
				String[] data9 = new String[11];
				String[] data10 = new String[11];
				String[] data11 = new String[11];
				String[] data12 = new String[11];
				String[] data13 = new String[11];
				String[] data14 = new String[11];
				String[] data15 = new String[11];
				String[] data16 = new String[11];
				String[] data17 = new String[11];
				
				
				for (int i = 0; i < data1.length; i++) {
					data1[i] = row.get(2).getTableCells().get(i).getText()+" ";
					System.out.print(data1[i]);
				}
				

				for (int i = 0; i < data2.length; i++) {
					data2[i] = row.get(3).getTableCells().get(i).getText()+" ";
					System.out.print(data2[i]);
				}
				
				for (int i = 0; i < data3.length; i++) {
					data3[i] = row.get(4).getTableCells().get(i).getText()+" ";
					System.out.print(data3[i]);
				}
				
				for (int i = 0; i < data4.length; i++) {
					data4[i] = row.get(5).getTableCells().get(i).getText()+" ";
					System.out.print(data4[i]);
				}
		
				
				for (int i = 0; i < data5.length; i++) {
					data5[i] = row.get(6).getTableCells().get(i).getText()+" ";
					System.out.print(data5[i]);
				}
				

				for (int i = 0; i < data6.length; i++) {
					data6[i] = row.get(7).getTableCells().get(i).getText()+" ";
					System.out.print(data6[i]);
				}
				
				for (int i = 0; i < data7.length; i++) {
					data7[i] = row.get(8).getTableCells().get(i).getText()+" ";
					System.out.print(data7[i]);
				}
				
				for (int i = 0; i < data8.length; i++) {
					data8[i] = row.get(9).getTableCells().get(i).getText()+" ";
					System.out.print(data8[i]);
				}
				
				
				for (int i = 0; i < data9.length; i++) {
					data9[i] = row.get(10).getTableCells().get(i).getText()+" ";
					System.out.print(data1[9]);
				}
				

				for (int i = 0; i < data10.length; i++) {
					data10[i] = row.get(11).getTableCells().get(i).getText()+" ";
					System.out.print(data10[i]);
				}
				
				for (int i = 0; i < data11.length; i++) {
					data11[i] = row.get(12).getTableCells().get(i).getText()+" ";
					System.out.print(data11[i]);
				}
				
				for (int i = 0; i < data12.length; i++) {
					data12[i] = row.get(13).getTableCells().get(i).getText()+" ";
					System.out.print(data12[i]);
				}
				
				
				for (int i = 0; i < data13.length; i++) {
					data13[i] = row.get(14).getTableCells().get(i).getText()+" ";
					System.out.print(data13[i]);
				}
				

				for (int i = 0; i < data14.length; i++) {
					data14[i] = row.get(15).getTableCells().get(i).getText()+" ";
					System.out.print(data14[i]);
				}
				
				for (int i = 0; i < data15.length; i++) {
					data15[i] = row.get(16).getTableCells().get(i).getText()+" ";
					System.out.print(data15[i]);
				}
				
				for (int i = 0; i < data16.length; i++) {
					data16[i] = row.get(17).getTableCells().get(i).getText()+" ";
					System.out.print(data16[i]);
				}
				
				for (int i = 0; i < data17.length; i++) {
					data17[i] = row.get(18).getTableCells().get(i).getText()+" ";
					System.out.print(data17[i]);
				}
				
				
				
				
				
				room.add(data1);
				room.add(data2);
				room.add(data3);
				room.add(data4);
				room.add(data5);
				room.add(data6);
				room.add(data7);
				room.add(data8);
				room.add(data9);
				room.add(data10);
				room.add(data11);
				room.add(data12);
				room.add(data13);
				room.add(data14);
				room.add(data15);
				room.add(data16);
				room.add(data17);
				
				
				System.out.println();
				
				return room;
				
				// 2번째 줄 data를 data 배열에 넣는것 까지 성공하였다
				
				
				
				
				
				
				
//				for (XWPFTableRow xwpfTableRow : row) {
//					
//					List<XWPFTableCell> cell = xwpfTableRow.getTableCells();
//					
//					for (XWPFTableCell xwpfTableCell : cell) {
//					
//						if (xwpfTableCell != null) {
//							
//							xwpfTableCell.getText();
//							
//							System.out.print(xwpfTableCell.getText());
							
							
							
							
							
//							List<XWPFTable> itable = xwpfTableCell.getTables();
//							
//							if (itable.size() != 0) {
//								
//								for (XWPFTable xwpfiTable : itable) {
//									
//									List<XWPFTableRow> irow = xwpfiTable.getRows();
//									
//									for (XWPFTableRow xwpfiTableRow : irow) {
//										
//										List<XWPFTableCell> icell = xwpfiTableRow.getTableCells();
//										
//										for (XWPFTableCell xwpfiTableCell : icell) {
//											
//											if (xwpfiTableCell != null) {
//												
////												System.out.print(xwpfiTableCell.getText());
//											}
//										}
//										
//									}
//								}
//							}
//						}
//					}
//				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;

	}

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:/Upload/" + "20161025.docx");
			// read header

			XWPFDocument document = new XWPFDocument(fis);

			List<XWPFParagraph> paragraphs = document.getParagraphs();

			System.out.println("Total no of paragraph " + paragraphs.size());
			for (XWPFParagraph para : paragraphs) {
				System.out.println(para.getText());
			}
			fis.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
