package kosa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kosa.model.Board;

public class BoardDao {
	private static BoardDao dao = new BoardDao();

	// Dao 메소드 호출
	public static BoardDao getInstance() {
		return dao;
	}

	// JNDI 기술을 이용해서 DBCP 구현
	// DataSource 객체(Connection Pool) => JNDI 이름으로 jdbc/oracle
	public Connection getDBCPConnection() {
		DataSource ds = null;

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");

			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 글 1개 보기
	public Board detailBoard(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = new Board();

		String sql = "select * from board where seq = ?";

		try {
			conn = getDBCPConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();

			if (rs.next()) { // rs는 이전 값을 가리킴, 따라서 next 해주면 첫 번째 row를 가리킴
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setHitcount(rs.getInt("hitcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {}
			}
		}

		return board;

	}

	// 글 목록 보기
	public List<Board> listBoard() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();

		String sql = "select * from board order by seq desc";

		try {
			conn = getDBCPConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 하나의 row board 객체에 들어감
			while (rs.next()) { // 첫 번째 row
				Board board = new Board();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setHitcount(rs.getInt("hitcount"));

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
				}
			}
		}

		return list;
	}

	// 싱글톤 방식
	public int insert(Board board) {
		// Connection 객체 생성
		Connection conn = null;
		PreparedStatement pstmt = null;

		// url, user, password
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kcc";
		String password = "1234";
		int re = -1;

		// ?: 무슨 값이 들어올지 모르기 때문
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";

		try {
			// 1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB 연결(Connection 객체 생성)
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn: " + conn);

			// 3. PrepareStatement 객체 생성(SQL 질의)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContents());

			// 4. SQL 실행(insert, update, delete => executeUpdate() => 정수 return (row 갯수))
			re = pstmt.executeUpdate(); // insert 되고 sql문 끝
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
				}
			}
		}

		return re;
	}
}
