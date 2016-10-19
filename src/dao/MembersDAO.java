package dao;

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
	
}
