package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.MemberGroup;
import vo.Members;

public class GroupingDAO {
	SqlSession sqlSession=MybatisConfig.getSqlSessionFactory().openSession();
	
	public int creategroup(MemberGroup membergroup){
		int result=sqlSession.insert("mapper.GroupingMapper.creategroup", membergroup);
		sqlSession.commit();
		return result;
	}
	public List<Members> selectgroup(String groupno){
		return sqlSession.selectList("mapper.GroupingMapper.selectgroup",groupno);
	}
	public int updategroup(String groupno, String memberno){
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("groupno", groupno);
		map.put("memberno",memberno);
		int result=sqlSession.update("mapper.GroupingMapper.updategroup", map);
		sqlSession.commit();
		return result;
	}
	public MemberGroup selectgroupone(String leaderno){
		return sqlSession.selectOne("mapper.GroupingMapper.selectgroupone", leaderno);
	}
	public MemberGroup searchgroupone(String groupno){
		return sqlSession.selectOne("mapper.GroupingMapper.searchgroupone", groupno);
	}
	public int deletegroup(String groupno){
		int result= sqlSession.delete("mapper.GroupingMapper.deletegroup", groupno);
		sqlSession.commit();
		return result;
	}
	public int expiremember(String groupno){
		int result=sqlSession.update("mapper.GroupingMapper.expiremember", groupno);
		sqlSession.commit();
		return result;
	}
	public String findgroupone(String groupname){
		return sqlSession.selectOne("mapper.GroupingMapper.findgroupone", groupname);
	}
	public int leave(String memberno){
		int result=sqlSession.update("mapper.GroupingMapper.leave", memberno);
		sqlSession.commit();
		return result;
	}
}
