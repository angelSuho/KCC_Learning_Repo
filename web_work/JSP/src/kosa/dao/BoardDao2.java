package kosa.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosa.mapper.BlogMapper;
import kosa.mapper.BoardMapper;
import kosa.model.Blog;
import kosa.model.Board;
import kosa.model.Search;

public class BoardDao2 {
	private static BoardDao2 dao = new BoardDao2();

	public static BoardDao2 getInstance() {
		return dao;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		// mybatis-config.xml => SqlSessionFactorytory
		String resource = "mybatis-config.xml";
		InputStream in = null;

		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public Blog selectBlog(int id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Blog blog = null;

		try {
			blog = sqlSession.getMapper(BlogMapper.class).selectBlog(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return blog;
	}

	// public List<Board> listBoard(Search search) {
	public List<Board> listBoard(Map map) {
		// SqlSessionFactory는 데이터베이스와 연결 설정, 데이터베이스 연결에 필요한 정보 제공
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Board> list = null;

		try {
			// mapper 방식
			 list = sqlSession.getMapper(BoardMapper.class).listBoard(map);
			// CRUD 메서드 호출
//			list = sqlSession.selectList("kosa.mapper.BoardMapper.listBoard");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

	public Board detailBoard(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Board board = null;

		try {
			board = sqlSession.getMapper(BoardMapper.class).detailBoard(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return board;
	}

	public int insertBoard(Board board) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			// insert 성공 시 re = 1
			re = sqlSession.getMapper(BoardMapper.class).insertBoard(board);
			
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return re;
	}

	public int updateBoard(Board board) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(BoardMapper.class).updateBoard(board);
			
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return re;
	}

}
