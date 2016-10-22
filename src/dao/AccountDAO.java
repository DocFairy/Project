package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.Files;

public class AccountDAO {

	SqlSession session = MybatisConfig.getSqlSessionFactory().openSession();
	
	public List<Files> fileList(String date){
		List<Files> result = null; 
		result = session.selectList("mapper.AccountMapper.fileList", date);
		return result;
	}
	
	public int fileDelete(String file){
		int result = 0;
		System.out.println("dao + " + file);
			result = session.delete("mapper.AccountMapper.fileDelete",file);
			session.commit();
		System.out.println("afterdao");
		return result;
	}
	
	public String fileFind(String del){
		String result = null;
			result = session.selectOne("mapper.AccountMapper.fileFind",del);
		return result;
	}
	
}
