package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return sqlSession.selectList("mapper.DocumentMapper.selectfile", memberno);
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

	 public Files fileshow(String save_fileno) { //fileshow.jsp로 페이지이동하면서, 해당파일정보를 가져옴
		SqlSession session = sessionFactory.openSession();
		 Files returner = session.selectOne("mapper.DocumentMapper.selectfileone",save_fileno);
		 System.out.println("DocumentDAO:getfileshow()returner:"+returner);
		 return returner;
	 }
	 public String calltype(String save_filename){
		return sqlSession.selectOne("mapper.DocumentMapper.calltype", save_filename); 
	 }
}
