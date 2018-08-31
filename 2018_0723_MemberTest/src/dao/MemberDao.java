package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.MemberVo;

public class MemberDao {

	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static MemberDao single = null;

	public static MemberDao getInstance() {
		if (single == null)
			single = new MemberDao();
		return single;
	}

	public MemberDao() {
		// TODO Auto-generated constructor stub
	
		
	
	}

	
	
	
	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
		Connection conn = null;
		PreparedStatement pstmt = null;
	
	   //String sql = "update member set name=?, id=?, pwd=?,zipcode=?,addr=?, ip=? where idx=?";
	
	   String sql = "update member set name=?, id=?,pwd=? where idx=?";
	 
		try {
			//1.Connection획득
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);

			//3.psmt parameter 설정
			//System.out.println(vo.getPwd());
			
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getId());
			pstmt.setString(3,vo.getPwd());
			
			//pstmt.setString(4,vo.getZipcode());
			//pstmt.setString(5,vo.getAddr());
			//pstmt.setString(6,vo.getIp());		
			pstmt.setInt(4,vo.getIdx());
			
			
			
			//4.DB insert
			res = pstmt.executeUpdate(); // insert update delete

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}
	
	
	
	// 전체 회원 목록 조회
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member";

		try {
			// 1.Connection획득
			conn = DBService.getInstance().getConnection();

			// 2.명령처리(PreparedStatement)객체 획득
			pstmt = conn.prepareStatement(sql);

			// 3.결과행처리(ResultSet)객체 획득
			rs = pstmt.executeQuery();

			// 전체행 처리
			while (rs.next()) {

				// rs의 현재 레코드의 값을 읽어오기
				// MemberVo에 포장
				MemberVo vo = new MemberVo();

				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddr(rs.getString("addr"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

				// ArrayList담는다
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				// 닫기:역순으로
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	// idx에 해당되는 회원정보를 획득

	public MemberVo selectOne(int idx) {
		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where idx=?";

		try {
			// 1.Connection획득
			conn = DBService.getInstance().getConnection();

			// 2.명령처리(PreparedStatement)객체 획득
			pstmt = conn.prepareStatement(sql);

			// 2-1. pstmt parameter변수 셋팅
			pstmt.setInt(1, idx);

			// 3.결과행처리(ResultSet)객체 획득
			rs = pstmt.executeQuery();

			// 전체행 처리
			if (rs.next()) {

				// SungVo에 포장
				vo = new MemberVo();

				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddr(rs.getString("addr"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				// 닫기:역순으로
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}

	// id에 해당되는 회원정보를 획득
	public MemberVo selectOne(String id) {
		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where id=?";
		try {
			// 1.Connection획득
			conn = DBService.getInstance().getConnection();

			// 2.명령처리(PreparedStatement)객체 획득
			pstmt = conn.prepareStatement(sql);

			// 2-1.pstmt parameter변수 셋팅
			pstmt.setString(1, id);

			// 3.결과행처리(ResultSet)객체 획득
			rs = pstmt.executeQuery();

			// 1건 데이터
			if (rs.next()) {

				// rs의 현재 레코드의 값을 읽어오기
				// Vo에 포장
				vo = new MemberVo();

				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddr(rs.getString("addr"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				// 닫기:역순으로
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	//회원 insert 
	
	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(seq_member_idx.nextVal,?,?,?,?,?,?,sysdate)";

		try {
			//1.Connection획득
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);

			//3.psmt parameter 설정
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getZipcode());
			pstmt.setString(5, vo.getAddr());
			pstmt.setString(6, vo.getIp());
			
			//4.DB insert
			res = pstmt.executeUpdate(); // insert update delete

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}
	
	
	

}
