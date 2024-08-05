package kosa.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosa.mapper.MemberMapper;
import kosa.model.Member;

public class MemberDao {
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public int insertMember(Member member) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(MemberMapper.class).insertMember(member);
			
			if(re > 0) {
				sqlSession.commit();
			} else { 
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	public Member loginMember(String userId) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Member member = null;
		
		try {
			member = sqlSession.getMapper(MemberMapper.class).loginMember(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return member;
	}

}
