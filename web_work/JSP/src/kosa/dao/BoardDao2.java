package kosa.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosa.mapper.BoardMapper;
import kosa.model.Board;

public class BoardDao2 {
	private static BoardDao2 dao = new BoardDao2();

	public static BoardDao2 getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSesstionFactory() {
		// mybatis-config.xml -> SqlSesstionFactory
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
//	public List<Board> listBoard(Search search) {
	public List<Board> listBoard(Map map) {
		SqlSession sqlSession = getSqlSesstionFactory().openSession();
		List<Board> list = null;
		
		try {
			list = sqlSession.getMapper(BoardMapper.class).listBoard(map); // 매퍼를 통해 메소드 호출 (권장)
//			list = sqlSession.selectList("kosa.mapper.BoardMapper.listBoard"); // 리스트를 통해 메소드 호출
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}
	
	public Board detailBoard(int seq) {
		SqlSession sqlSession = getSqlSesstionFactory().openSession();
		Board board = null;
		
		try {
			board = sqlSession.getMapper(BoardMapper.class).detailBoard(seq);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return board;
	}
	
	public int insertBoard(Board board) {
		SqlSession sqlSession = getSqlSesstionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(BoardMapper.class).insertBoard(board);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	public int updateBoard(Board board) {
		SqlSession sqlSession = getSqlSesstionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(BoardMapper.class).updateBoard(board);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
}
