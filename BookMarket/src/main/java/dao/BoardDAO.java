package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BoardBean;

public class BoardDAO {
	private DBConnector dbconn;
	private static BoardDAO dao = new BoardDAO();
	
	public BoardDAO() {
		dbconn = DBConnector.getInstance();
	}
	
	public static BoardDAO getDao() {
		return dao;
	}
	// Connection 이 필요하면 각 기능에서 dbconn.getConnection()
	
	// 해당 페이지의 모든 게시글을 가져와서 리턴
	
	// 전체 게시글 수 가져오기
	public int getTotalArticles() {
		int cnt = 0;
		// 데이터베이스 접근해서 
		// 총 레코드 수 가져오기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbconn.getConnection();
			String sql = "select count(num) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return cnt;
	}

	public ArrayList<BoardBean> getArticles(int start, int end) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardBean> articles = null;
		try {
			String sql = " select * from"
						+ " (select rownum RN, A.* from \r\n" 
						+ " (select num, id, name, subject,"
						+ " content, regist_day, hit, ip \r\n"
						+ " from board"
						+ " order by num desc) A) \r\n"
						+ " where RN between ? and ? \r\n";
			
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			articles = new ArrayList<BoardBean>();
			
			while (rs.next()) {
				// 받아온 모든 게시글을 하나씩 저장해서 리스트에 저장
				BoardBean dto = new BoardBean();
				dto.setRn(rs.getInt("rn"));
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegist_day(rs.getString("regist_day"));
				dto.setHit(rs.getInt("hit"));
				dto.setIp(rs.getString("ip"));
				articles.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return articles;
	}
	
	public ArrayList<BoardBean> getArticles(int start, int end, String items, String text) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardBean> articles = null;
		try {
			String sql = " select * from"
						+ " (select rownum rn, A.* from \r\n" 
						+ " (select num, id, name, subject,"
						+ " content, regist_day, hit, ip \r\n"
						+ " from board \r\n"
						+ " where "+items+" like '%' || ? || '%' \r\n"
						+ " order by num desc) A) \r\n"
						+ " where RN between ? and ? \r\n";
			
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, text); 
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			articles = new ArrayList<BoardBean>();
			
			while (rs.next()) {
				// 받아온 모든 게시글을 하나씩 저장해서 리스트에 저장
				BoardBean dto = new BoardBean();
				dto.setRn(rs.getInt("rn"));
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegist_day(rs.getString("regist_day"));
				dto.setHit(rs.getInt("hit"));
				dto.setIp(rs.getString("ip"));
				articles.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return articles;
	}
	
	public void insertArticle(BoardBean dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into board(NUM,ID,NAME,SUBJECT,CONTENT,REGIST_DAY,HIT,IP)\r\n"
					+ "values(num_seq.nextval, ?, ?, ?, ?, to_char(sysdate, 'yyyy/mm/dd(HH:mm:ss)'), 0, ?)";
			
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getIp());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}

	public BoardBean getArticle(int num) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		
		try {
			String sql = "select num, id, name, subject,"
					+ " content, regist_day, hit, ip from board \r\n"
					+ " where num = ?";
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			BoardBean dto = new BoardBean();

			if (rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegist_day(rs.getString("regist_day"));
				dto.setHit(rs.getInt("hit"));
				dto.setIp(rs.getString("ip"));
				
				String sql2 = "update board set hit=hit+1 where num = ?";
				pstmt1 = conn.prepareStatement(sql2);
				pstmt1.setInt(1, num);
				int r = pstmt1.executeUpdate();
				if (r == 0) return null;
			}
			return dto;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (pstmt1 != null) try {pstmt1.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		
		return null;
	}
	
	public void updateArticle(BoardBean article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update board set name=?, subject=?, content=?, ip=?\r\n"
						+ " where num=?";
			
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getName());
			pstmt.setString(2, article.getSubject());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getIp());
			pstmt.setInt(5, article.getNum());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}
	
	public void deleteArticle(BoardBean article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from board where num=?";
			
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article.getNum());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}
}
