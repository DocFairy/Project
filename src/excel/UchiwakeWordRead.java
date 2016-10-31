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

public class UchiwakeWordRead {

	public ArrayList<String[]> readWord(String save_filename) {

		try {
			
			FileInputStream fis = new FileInputStream("C:/Upload/" + save_filename);

			XWPFDocument document = new XWPFDocument(fis);
			
			fis.close();

			List<XWPFTable> table = document.getTables();
			
			for (XWPFTable xwpfTable : table) {
				
				List<XWPFTableRow> row = xwpfTable.getRows();
				
				ArrayList<String[]> room = new ArrayList<>();
				
				String[] data0 = new String[5]; 	//여비 교통비
				String[] data1 = new String[5];
				String[] data2 = new String[5];
				String[] data3 = new String[5];
				String[] data4 = new String[5];
				
				
				String[] data5 = new String[5];	//사무 용품비
				
				
				String[] data6 = new String[5];	//도서 인쇄비
				String[] data7 = new String[5];
				String[] data8 = new String[5];
				String[] data9 = new String[5];
				
				
				String[] data10 = new String[5];	//복리 후생비
				String[] data11 = new String[5];
				String[] data12 = new String[5];
				String[] data13 = new String[5];
				String[] data14 = new String[5];
				String[] data15 = new String[5];
				String[] data16 = new String[5];
				String[] data17 = new String[5];
				String[] data18 = new String[5];
				String[] data19 = new String[5];
				String[] data20 = new String[5];
				String[] data21 = new String[5];
				String[] data22 = new String[5];
				
				
				String[] data23 = new String[1];	//합계
				
				
				for (int i = 1; i < data0.length; i++) {		//여비 교통비
					data0[i] = row.get(1).getTableCells().get(i).getText()+" ";
					System.out.print(data0[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {
					data1[i] = row.get(2).getTableCells().get(i).getText()+" ";
					System.out.print(data1[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {
					data2[i] = row.get(3).getTableCells().get(i).getText()+" ";
					System.out.print(data2[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {
					data3[i] = row.get(4).getTableCells().get(i).getText()+" ";
					System.out.print(data3[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {
					data4[i] = row.get(5).getTableCells().get(i).getText()+" ";
					System.out.print(data4[i]);
				}
				
				
				
				
				for (int i = 1; i < data0.length; i++) {		//사무 용품비
					data5[i] = row.get(6).getTableCells().get(i).getText()+" ";
					System.out.print(data5[i]);
				}
				
				
				
				
				
				for (int i = 1; i < data0.length; i++) {		//도서 인쇄비
					data6[i] = row.get(7).getTableCells().get(i).getText()+" ";
					System.out.print(data6[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data7[i] = row.get(8).getTableCells().get(i).getText()+" ";
					System.out.print(data7[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data8[i] = row.get(9).getTableCells().get(i).getText()+" ";
					System.out.print(data8[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data9[i] = row.get(10).getTableCells().get(i).getText()+" ";
					System.out.print(data9[i]);
				}
				
				
				
				
				
				
				for (int i = 1; i < data0.length; i++) {		//복리 후생비
					data10[i] = row.get(11).getTableCells().get(i).getText()+" ";
					System.out.print(data10[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data11[i] = row.get(12).getTableCells().get(i).getText()+" ";
					System.out.print(data11[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data12[i] = row.get(13).getTableCells().get(i).getText()+" ";
					System.out.print(data12[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data13[i] = row.get(14).getTableCells().get(i).getText()+" ";
					System.out.print(data13[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data14[i] = row.get(15).getTableCells().get(i).getText()+" ";
					System.out.print(data14[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data15[i] = row.get(16).getTableCells().get(i).getText()+" ";
					System.out.print(data15[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data16[i] = row.get(17).getTableCells().get(i).getText()+" ";
					System.out.print(data16[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data17[i] = row.get(18).getTableCells().get(i).getText()+" ";
					System.out.print(data17[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data18[i] = row.get(19).getTableCells().get(i).getText()+" ";
					System.out.print(data18[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data19[i] = row.get(20).getTableCells().get(i).getText()+" ";
					System.out.print(data19[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data20[i] = row.get(21).getTableCells().get(i).getText()+" ";
					System.out.print(data20[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data21[i] = row.get(22).getTableCells().get(i).getText()+" ";
					System.out.print(data21[i]);
				}
				
				for (int i = 1; i < data0.length; i++) {		
					data22[i] = row.get(23).getTableCells().get(i).getText()+" ";
					System.out.print(data22[i]);
				}
				
				data23[0] = row.get(24).getTableCells().get(2).getText()+" ";
				
				System.out.println(data23[0]);
				
				room.add(data0);
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
				room.add(data18);
				room.add(data19);
				room.add(data20);
				room.add(data21);
				room.add(data22);
				room.add(data23);
				
				
				return room;
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;

	}


}
