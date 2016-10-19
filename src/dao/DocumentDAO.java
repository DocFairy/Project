package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.Files;

public class DocumentDAO {
	SqlSession sqlSession=MybatisConfig.getSqlSessionFactory().openSession();
	
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
	public String searchfile(String save_filename){
		return sqlSession.selectOne("mapper.DocumentMapper.searchfile", save_filename);
	}
}
