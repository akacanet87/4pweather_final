package com.sds.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sds.domain.Board;

@Repository
public class BoardDAOJdbc implements BoardDAO {
	String TAG = this.getClass().getName();

	private PoolManager pool = PoolManager.getInstance();

	public void setPool(PoolManager pool) {
		System.out.println("pool is " + pool);
		this.pool = pool;
	}

	public List selectAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();

		con = pool.getConnection();
		String sql = "select * from board order by board_id desc";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board dto = new Board();

				dto.setBoard_id(rs.getInt("board_id"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setHit(rs.getInt("hit"));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}

	public Board select(int board_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board dto = null;

		con = pool.getConnection();
		String sql = "select * from board where board_id=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new Board();

				dto.setBoard_id(rs.getInt("board_id"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return dto;
	}

	public int insert(Board board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		con = pool.getConnection();

		String sql = "insert into board(writer,title,content)";
		sql = sql + " values(?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());

			result = pstmt.executeUpdate();
			System.out.print(TAG + " 의  insert 호출 결과" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return result;
	}

	public int update(Board board) {

		Connection con = null;
		PreparedStatement pstmt = null;

		int result = 0;

		con = pool.getConnection();

		String sql = "update board set writer=?, title=?, content=? where board_id=?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  board.getWriter());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getBoard_id());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			pool.freeConnection(con, pstmt);

		}

		return result;
	}

	public int delete(int board_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		int result = 0;

		con = pool.getConnection();

		String sql = "delete from board where board_id=?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			pool.freeConnection(con, pstmt);

		}

		return result;
	}
}
