package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBservice;
import vo.PhotoVo;

public class PhotoDao {

	//single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static PhotoDao single = null;

	public static PhotoDao getInstance() {
		if (single == null)
			single = new PhotoDao();
		return single;
	}

	public PhotoDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	//사진목록 조회
	public List<PhotoVo> selectList() {

		List<PhotoVo> list = new ArrayList<PhotoVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from photo order by idx desc";

		try {
			//1.Connection획득
			conn = DBservice.getInstance().getConnection();

			//2.명령처리(PreparedStatement)객체 획득
			pstmt = conn.prepareStatement(sql);

			//3.결과행처리(ResultSet)객체 획득
			rs = pstmt.executeQuery();

			//전체행 처리
			while (rs.next()) {

				//rs의 현재 레코드의 값을 읽어오기
				//PhotoVo에 포장
				PhotoVo vo = new PhotoVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setTitle(rs.getString("title"));
				vo.setFilename(rs.getString("filename"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

				//ArrayList담는다
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//닫기:역순으로
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

	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
		Connection conn = null;
		PreparedStatement pstmt = null;
		//                                                           1 2 3 4
		String sql = "insert into photo values(seq_photo_idx.nextVal,?,?,?,?,sysdate)";

		try {
			//1.Connection획득
			conn = DBservice.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 설정
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getFilename());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());

			//4.DB insert
			res = pstmt.executeUpdate(); // insert update delete

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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

	public PhotoVo selectOne(int idx) {
		PhotoVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from photo where idx=?";

		try {
			//1.Connection획득
			conn = DBservice.getInstance().getConnection();

			//2.명령처리(PreparedStatement)객체 획득
			pstmt = conn.prepareStatement(sql);

			//2-1.pstmt parameter변수 셋팅
            pstmt.setInt(1, idx); 
			//3.결과행처리(ResultSet)객체 획득
			rs = pstmt.executeQuery();

			//1건 데이터
			if (rs.next()) {

				//rs의 현재 레코드의 값을 읽어오기
				//PhotoVo에 포장
				vo = new PhotoVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setTitle(rs.getString("title"));
				vo.setFilename(rs.getString("filename"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//닫기:역순으로
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
	
	
	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from photo where idx=?";

		try {
			//1.Connection획득
			conn = DBservice.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 설정
            pstmt.setInt(1, idx);
			//4.DB insert
			res = pstmt.executeUpdate(); // insert update delete

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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











