package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.Members;

public class MembersDAO {

	SqlSession sqlsession = MybatisConfig.getSqlSessionFactory().openSession();
	
	public int insertMember(Members members){
		int result=sqlsession.insert("Members.insertMembers", members);
		sqlsession.commit();
		return result;
	}
	
	public Members searchMember(String id){
		Members result;
			result = sqlsession.selectOne("Members.searchMember", id);
		return result;
	}
	
	public int updateMember(Members members){
		int result = 0;
			sqlsession.update("Members.updateMember",members);
			sqlsession.commit();
		return result;
	}
	public List<String> searchid(String id){
		return sqlsession.selectList("Members.searchid", id);
	}
	public int inviteid(String memberno,String msg){
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("memberno", memberno);
		map.put("msg",msg);
		int result=sqlsession.update("Members.inviteid", map);
		sqlsession.commit();
		return result;
	}
	public int confirm(String memberno,String groupno){
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("memberno", memberno);
		map.put("groupno",groupno);
		int result=sqlsession.update("Members.confirm", map);
		sqlsession.commit();
		return result;
	}
	public int reject(String memberno){
		int result=sqlsession.update("Members.reject", memberno);
		sqlsession.commit();
		return result;
	}
	
}
