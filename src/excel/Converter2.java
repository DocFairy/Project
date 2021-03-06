package excel;


import java.io.File;
 
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;
 
public class Converter2 {
 
    public void convert2(String save_file, String save_filename){
    	System.out.println("convert2() in");
    	// 1) Start LibreOffice in headless mode.
        OfficeManager officeManager = null;
        try {
            officeManager = new DefaultOfficeManagerConfiguration()
                    .setOfficeHome(new File(PathSaver.librePath())) //주의!!  Program Files (x86) 과 Program Files 중 자신의 폴더에 맞는 경로를 골라야 합니다
                    .buildOfficeManager();
            officeManager.start();
 
            // 2) Create JODConverter converter
            OfficeDocumentConverter converter = new OfficeDocumentConverter(
                    officeManager);
 
            // 3) Create PDF
            createPDF(converter, save_file, save_filename);
           // createPDF(converter, save_file, save_filename);
 
        } finally {
            // 4) Stop LibreOffice in headless mode.
            if (officeManager != null) {
                officeManager.stop();
            }
        }
    }
 
    private static void createPDF(OfficeDocumentConverter converter, String save_file, String save_filename) {
        try {

        	long start = System.currentTimeMillis();
            String filename_pdf="";
    		int lastIndex = save_file.lastIndexOf('.');
    		if (lastIndex == -1){
    			filename_pdf = "";
    		}else{ 
    			filename_pdf = save_file.substring(0, lastIndex)+".pdf";
    		}
    		System.out.println(filename_pdf);
            File existFile = new File(PathSaver.filePath()+"/pdf/"+filename_pdf);
	            if(existFile.isFile()){
	            	existFile.delete();
	            	System.out.println("Converter2:existing pdf deleted");
	            }
            converter.convert(new File("C:/upload/"+save_file), new File(
            		PathSaver.filePath()+"/pdf/"+filename_pdf));
            System.err.println("Generate pdf with "
                    + (System.currentTimeMillis() - start) + "ms");//sdfg
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
