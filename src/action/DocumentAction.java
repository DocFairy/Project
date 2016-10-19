package action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.DocumentDAO;
import vo.Files;
import vo.Members;

public class DocumentAction extends ActionSupport implements SessionAware{
	Files files;
	private File upload;					/** 업로드할 파일. Form의 <file> 태그의 name. */
	private String uploadFileName;			/** 업로드할 파일의 파일명 (File타입 속성명 + "FileName") */
	private String uploadContentType;		/** 업로드할 파일의 컨텐츠 타입 (File타입 속성명 + "ContentType") */
	private List<Files>list;
	private Map<String, Object> session;
	private Members members;
	
	public String docTransform()throws Exception{
		return "success";
	}
	public String docIntegrate()throws Exception{
		DocumentDAO dd=new DocumentDAO();
		list=dd.selectfile(((Members)session.get("members")).getMemberno());
		return "success";
	}
	public String docForm()throws Exception{
		return "success";
	}
	public String insertfile()throws Exception{
		if (upload != null) { 
			FileService fs = new FileService();
			String basePath = "D:/upload";		//user.properties에 지정된 파일 저장 경로
			String savedfile = fs.saveFile(upload, basePath, uploadFileName);	//서버에 임시 업로드된 파일객체, 저장경로, 업로드당시의 파일명 전달하고 실제 저장된 파일명 리턴받음
			files.setSave_file(savedfile);
			files.setSave_filename(uploadFileName);
		}
		DocumentDAO dd=new DocumentDAO();
		dd.insertfile(files);
		return "success";
	}
	public String delfile()throws Exception{
		DocumentDAO dd=new DocumentDAO();
		FileService fs = new FileService();
		String fullpath="D:/upload/"+dd.searchfile(uploadFileName);
		fs.fileDelete(fullpath);
		return "success";
	}

	public String makefile()throws Exception{
		String[]array=uploadFileName.split(",");
		for(int i=0;i<array.length;i++){
			
		}
		
		return "success";
	}
	public Files getFiles() {
		return files;
	}
	public void setFiles(Files files) {
		this.files = files;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public List<Files> getList() {
		return list;
	}
	public void setList(List<Files> list) {
		this.list = list;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	public Members getMembers() {
		return members;
	}
	public void setMembers(Members members) {
		this.members = members;
	}
	
	
	
}
