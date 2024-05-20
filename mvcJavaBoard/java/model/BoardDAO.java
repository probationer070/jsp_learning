package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

public class BoardDAO {
	private DBConnector dbconn;
	private static BoardDAO dao = new BoardDAO();
	
	private BoardDAO() {
		dbconn = DBConnector.getInstance();
	}
	
	public static BoardDAO getDAO() {
		return dao;
	}
	
	public int getTotal() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbconn.getConnection();
			String sql = "select count(bno) from board_list";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return cnt;
	}
	
	public List<BoardDTO> getArticles(int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> articles = null;
		try {
			
			String sql = " select * from"
				+ " (select rownum RN, A.* from \r\n" 
				+ " (select * from board_list"
				+ " order by bno desc) A) \r\n"
				+ " where RN between ? and ? \r\n";
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			articles = new ArrayList<BoardDTO>();
			
			while (rs.next()) {
				// 받아온 모든 게시글을 하나씩 저장해서 리스트에 저장
				BoardDTO dto = new BoardDTO();
				dto.setRn(rs.getInt("rn"));
				dto.setBno(rs.getInt("bno"));
				dto.setBref(rs.getInt("bref"));
				dto.setBstep(rs.getInt("bstep"));
				dto.setBlevel(rs.getInt("blevel"));
				dto.setReadcount(rs.getInt("readcount"));
				
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setIp(rs.getString("ip"));
				dto.setPasswd(rs.getString("passwd"));
				articles.add(dto);
			}
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}

		return articles;
	}

	public int writeArticle(BoardDTO article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int r = 0;
		
		// 새로운 번호를 가져오는 쿼리 작성
		try {
			conn = dbconn.getConnection();
			String sql = "select nvl(max(bno), 0)+1 from board_list";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int newNum = 0;
			if (rs.next()) {
				newNum = rs.getInt(1);
			}
			if (article.getBno() == 0) {	// 제목글
				article.setBno(newNum);
				article.setBref(newNum);
			} else {	// 답글
				article.setBno(newNum);
				article.setBlevel(article.getBlevel()+1);
				article.setBstep(article.getBstep()+1);
			}
			pstmt.close();
			sql = "insert into board_list(bno, bref, bstep, blevel, readcount,"
				+ " subject, content, writer, regdate, ip, passwd)\r\n"
				+ " values(?,?,?,?,0,?,?,?,to_char(sysdate, 'yyyy/mm/dd(HH:mm:ss)'),?,?)";
			
			System.out.println(article.getBno());
			System.out.println(article.getBref());
			System.out.println(article.getBstep());
			System.out.println(article.getBlevel());
			System.out.println(article.getSubject());
			System.out.println(article.getContent());
			System.out.println(article.getWriter());
			System.out.println(article.getIp());
			System.out.println(article.getPasswd());
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article.getBno());
			pstmt.setInt(2, article.getBref());
			pstmt.setInt(3, article.getBstep());
			pstmt.setInt(4, article.getBlevel());
			pstmt.setString(5, article.getSubject());
			pstmt.setString(6, article.getContent());
			pstmt.setString(7, article.getWriter());
			pstmt.setString(8, article.getIp());
			pstmt.setString(9, article.getPasswd());
			r = pstmt.executeUpdate();
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return r;
	}

	public BoardDTO getArticle(int bno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO article = null;
		try {
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);	// autocommit 취소 됨
			// 조회수 증가하고 가져오기 dao에서. autocommit 이 되어있음
			String sql = "update board_list set readcount = readcount+1"
						+ " where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			// 취소하고 에러가 없으면 commit
			pstmt.close();
			
			sql = "select * from board_list where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article = new BoardDTO();
				article.setBno(rs.getInt("bno"));
				article.setBref(rs.getInt("bref"));
				article.setBstep(rs.getInt("bstep"));
				article.setBlevel(rs.getInt("blevel"));
				article.setReadcount(rs.getInt("readcount"));
				
				article.setSubject(rs.getString("subject"));
				article.setContent(rs.getString("content"));
				article.setWriter(rs.getString("writer"));
				article.setIp(rs.getString("ip"));
				article.setRegdate(rs.getString("regdate"));
				article.setPasswd(rs.getString("passwd"));
			}
			conn.commit();
		} catch (NamingException | SQLException e) {
			// 오류나면 rollback
			try { conn.rollback();} catch (SQLException e1) {}
			e.printStackTrace();
		} finally {
			try {conn.setAutoCommit(true);} catch (SQLException e) {}
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		
		
		return article;
	}

	public void updateArticle(BoardDTO article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update board_list set subject=?, content=?, writer=?, regdate=to_char(sysdate, 'yyyy/mm/dd(HH:mm:ss)'), passwd=?\r\n"
					   + "where bno=?";
			
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getSubject());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getWriter());
			pstmt.setString(4, article.getPasswd());
			pstmt.setInt(5, article.getBno());
			pstmt.executeUpdate();
			

			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		
	}

	public void deleteArticle(BoardDTO article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from board_list where bno=?";
			
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article.getBno());
			pstmt.executeUpdate();
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		
	}
	
}
