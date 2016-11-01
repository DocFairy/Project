package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import com.opensymphony.xwork2.ActionSupport;

import dao.DocumentDAO;
import vo.Files;

//파일 다운로드 액션
public class FileDownloadAction extends ActionSupport {
	private String save_fileno;				//파일이 첨부된 글번호	
	private String contentType;
	private String contentDisposition;
	private InputStream inputStream;
	private long contentLength;
	private String integrate;
	private String fname;
	public String execute() {
		try {
			String savedfile = null;
			String originalfile = null;
			String basePath = null;
			if(save_fileno!=null){
			Files files=new DocumentDAO().selectfileone(save_fileno);//해당 번호의 Board객체
		    savedfile = files.getSave_file();					//서버에 저장된 파일명
			originalfile = files.getSave_filename();
			}else if(fname!=null){
				
				savedfile=integrate;//원래 파일명				
				originalfile=fname+".xlsx";
				
			}
			else{
				savedfile=integrate;//원래 파일명
				originalfile="integrate.xlsx";
			}
			basePath = "C:/upload";				//user.properties에 정의된 파일 저장 경로		
			String serverFullPath = basePath + "/" + savedfile;	//서버에 저장된 파일의 전체 경로
			File file = new File(serverFullPath);
			setContentLength(file.length());					//파일크기
			setContentDisposition("attachment;filename=" + URLEncoder.encode(originalfile, "UTF-8")); 	//파일의 원래 이름
			
			inputStream = new FileInputStream(serverFullPath);	//다운로드할 스트림
		
		}
		catch (Exception ex) {
			
		}
		return SUCCESS;
	}
	



	public String getSave_fileno() {
		return save_fileno;
	}

	public void setSave_fileno(String save_fileno) {
		this.save_fileno = save_fileno;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}


	public String getIntegrate() {
		return integrate;
	}


	public void setIntegrate(String integrate) {
		this.integrate = integrate;
	}




	public String getFname() {
		return fname;
	}




	public void setFname(String fname) {
		this.fname = fname;
	}
	
}
