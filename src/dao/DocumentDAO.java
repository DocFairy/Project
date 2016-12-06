package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Files;

public class DocumentDAO {
	SqlSession sqlSession=MybatisConfig.getSqlSessionFactory().openSession();
	SqlSessionFactory sessionFactory = MybatisConfig.getSqlSessionFactory();
	
	public int insertfile(Files files){
		int result=sqlSession.insert("mapper.DocumentMapper.insertfile",files);
		sqlSession.commit();
		
		return result;
	}
	public List<Files> selectfile(String memberno){
		
		//쿼리로 전달할 Parameter들
		return sqlSession.selectList("mapper.DocumentMapper.selectfile", memberno);	
		
	}
	
	public List<Files> selectDocument(String memberno){
		return sqlSession.selectList("mapper.DocumentMapper.selectDocument", memberno);
	}
	
	public Files selectfileone(String save_fileno){
		return sqlSession.selectOne("mapper.DocumentMapper.selectfileone", save_fileno);
	}
	public int delfile(String save_filename){
		int result=sqlSession.delete("mapper.DocumentMapper.delfile", save_filename);
		sqlSession.commit();
		return result;
	}
	public String searchfile(String save_filename, String memberno){
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("save_filename", save_filename);
		map.put("memberno", memberno);
		return sqlSession.selectOne("mapper.DocumentMapper.searchfile", map);
	}
	
	public List<Files> primaryFormList(){ //문서양식의 기본문서양식파일리스트를 불러온다.
		 SqlSession session = sessionFactory.openSession();
		 List<Files> returner = session.selectList("mapper.DocumentMapper.primaryDocList",null);
		 return returner;
	 }
	public void docFormDeleteF(String save_fileno) {
		SqlSession session = sessionFactory.openSession();
		session.delete("mapper.DocumentMapper.docFormDeleteF", save_fileno);
		session.commit();
		if(session!=null){
			session.close();
		}
	}
	 public Files fileshow(String save_fileno) { //fileshow.jsp로 페이지이동하면서, 해당파일정보를 가져옴
		SqlSession session = sessionFactory.openSession();
		 Files returner = session.selectOne("mapper.DocumentMapper.selectfileone",save_fileno);
		 System.out.println("DocumentDAO:getfileshow()returner:"+returner);
		 return returner;
	 }
	 public String calltype(String save_filename){
		return sqlSession.selectOne("mapper.DocumentMapper.calltype", save_filename); 
	 }
	public List<Files> docFormSearch(String searchKeyword) {
		List<Files> returner = null;
		SqlSession session = sessionFactory.openSession();
		returner = session.selectList("mapper.DocumentMapper.DocFormSearch", searchKeyword);
		for(int i = 0; i<returner.size(); i++){
			System.out.println("dao.docFormSearch():result----"+returner.get(i));
		}
		if(session!=null){
			session.close();
		}
		return returner;
	}
	public List<Files> selectword(String memberno) {
		
		return sqlSession.selectList("mapper.DocumentMapper.selectword", memberno);
	}
	public String searchCreateFile(String tmpName) {
	      System.out.println("DAO :" + tmpName);
	      String result = sqlSession.selectOne("mapper.DocumentMapper.searchCreateFile", tmpName);
	      System.out.println("result : " + result);
	      return  result;
	   }
	   public boolean shareUpdate(String groupno, String memeberno, String[] fileType) {
	      int result = 0;
	      boolean chk = false;
	      HashMap<String, String> map = new HashMap<>();
	      map.put("groupno", groupno);
	      map.put("memberno", memeberno);
	      System.out.println("fileType length:"+ fileType.length);
	      for (int i = 0; i < fileType.length; i++) {
	         map.put("filetype", fileType[i]);
	         if(sqlSession.update("mapper.DocumentMapper.shareCreateFile", map)>0){
	            sqlSession.commit();
	            result++;
	            System.out.println("share dao result:"+result);
	         }
	      }
	      if(result == fileType.length){
	         return true;
	      }else{
	         return false;
	      }
	   }
	   public List<Files> searchGroupFiles(String groupno) {
	      List<Files> groupFiles = null;
	      System.out.println("group 1");
	      groupFiles = sqlSession.selectList("mapper.DocumentMapper.searchGroupFile", groupno);
	      System.out.println("group 1");
	      return groupFiles;
	   }
	   public void deleteTempFiles(String memberno) {
	      sqlSession.delete("mapper.DocumentMapper.deleteTempFile",memberno);
	      sqlSession.commit();
	   }
	   public void delFile(String delFileName) {
		      sqlSession.delete("mapper.DocumentMapper.deleteFile", delFileName);
		      sqlSession.commit();
		   }
}
