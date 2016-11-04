package excel;

public class PathSaver {

	private PathSaver(){
		
	}
	
	//"C:/ServerUtils/workspace_projectDocFairy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Project
	//이게 저장되어 있는 주소라고 친다면, 
	//C:/ServerUtils/workspace_projectDocFairy/ 이곳이 자신의 eclipse의 workspace의 주소입니다. 이 위치를 자신이 사용중인 workspace경로로 바꾸시면 됩니다.
	//"C:/FinalProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Project";
	public static String filePath(){ //톰캣에 올라가진 실제 파일 주소
		return "C:/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Project";
	}
	
	public static String librePath(){ //libreOffice가 저장된 주소
		return "C:/Program Files (x86)/LibreOffice 5";
	}
}
