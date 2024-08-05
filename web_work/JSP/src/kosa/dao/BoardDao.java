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

	// Dao 硫붿?���뱶 �샇?���?
	public static BoardDao getInstance() {
		return dao;
	}

	// JNDI 湲곗?���쓣 �씠�슜�빐�꽌 DBCP ?��?�쁽
	// DataSource 媛앹�?(Connection Pool) => JNDI �씠?��꾩쑝濡� jdbc/oracle
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

	// 湲� 1媛� 蹂닿�?
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

			if (rs.next()) { // rs�뒗 �씠�쟾 媛�?�쓣 媛�?��?�궡, �뵲�씪�꽌 next �빐二쇰?�� 泥� 踰덉?�� row?���? 媛�?��?�궡
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

	// 湲� 紐⑸�? 蹂닿�?
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

			// �븯�굹�쓽 row board 媛앹껜��? �뱾�뼱媛�
			while (rs.next()) { // 泥� 踰덉?�� row
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

	// �떛湲��넠 諛⑹?��
	public int insert(Board board) {
		// Connection 媛앹�? �깮�꽦
		Connection conn = null;
		PreparedStatement pstmt = null;

		// url, user, password
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kcc";
		String password = "1234";
		int re = -1;

		// ?: ?��?��?�� 媛�?�씠 �뱾�뼱�삱吏� 紐⑤?��湲� �븣?���?
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";

		try {
			// 1. JDBC �뱶�씪�씠踰� 濡쒕�?
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB �뿰寃�(Connection 媛앹�? �깮�꽦)
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn: " + conn);

			// 3. PrepareStatement 媛앹�? �깮�꽦(SQL 吏덉?��)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContents());

			// 4. SQL �떎�뻾(insert, update, delete => executeUpdate() => �젙�닔 return (row 媛��닔))
			re = pstmt.executeUpdate(); // insert �릺?�� sql?���? �걹
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
