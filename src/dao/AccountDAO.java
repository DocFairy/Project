package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.Files;

public class AccountDAO {

	SqlSession session = MybatisConfig.getSqlSessionFactory().openSession();
	
	public List<Files> fileList(String date, String memberno){
		List<Files> result = null; 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", date);
		map.put("memberno", memberno);
		result = session.selectList("mapper.AccountMapper.fileList", map );
		return result;
	}
	
	public List<Files> fileListTerm(int dateFrom,int dateTo, String memberno){
		List<Files> result = null;
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("dateFrom", dateFrom);
			map.put("dateTo", dateTo);
			map.put("memberno", memberno);
			result = session.selectList("mapper.AccountMapper.fileListTerm",map);
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

