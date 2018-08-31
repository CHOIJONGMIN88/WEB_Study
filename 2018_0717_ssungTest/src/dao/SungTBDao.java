package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBservice;
import vo.SungVo;

public class SungTBDao {
	
	//single-ton pattern: 1∞≥¿« ∞¥√º∏∏ ª˝º∫«ÿº≠ º≠∫ÒΩ∫«œ¿⁄
	static SungTBDao single = null;

	public static SungTBDao getInstance() {
		if (single == null)
			single = new SungTBDao();
		return single;
	}

	public SungTBDao() {
		// TODO Auto-generated constructor stub
	}
	
	//º∫¿˚µ•¿Ã≈Õ ¡∂»∏
	public List<SungVo> selectList()
	{
		List<SungVo> list = new ArrayList<SungVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sungtb_view";
		
		try{
			//1.Connection»πµÊ
			conn = DBservice.getInstance().getConnection();
			
			//2.∏Ì∑…√≥∏Æ(PreparedStatement)∞¥√º »πµÊ
			pstmt = conn.prepareStatement(sql);
			
			//3.∞·∞˙«‡√≥∏Æ(ResultSet)∞¥√º »πµÊ
			rs = pstmt.executeQuery();
			
			//¿¸√º«‡ √≥∏Æ
			while(rs.next()) {
				
				//rs¿« «ˆ¿Á ∑πƒ⁄µÂ¿« ∞™¿ª ¿–æÓø¿±‚
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				String avg = rs.getString("avg");
				int rank = rs.getInt("rank");
				
				//SungVoø° ∆˜¿Â
				SungVo vo = new SungVo();
				vo.setIdx(idx);
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMat(mat);
				vo.setTot(tot);
				vo.setAvg(avg);
				vo.setRank(rank);
				
				//ArrayList¥„¥¬¥Ÿ
				list.add(vo);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			try {
				//¥›±‚:ø™º¯¿∏∑Œ
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	
	//º∫¿˚ 1∞« ¡∂»∏«œ±‚ 
	
	public SungVo selectOne(int idx)
	{
		SungVo  vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sungtb_view where idx=?";
		
		try{
			//1.Connection»πµÊ
			conn = DBservice.getInstance().getConnection();
			
			//2.∏Ì∑…√≥∏Æ(PreparedStatement)∞¥√º »πµÊ
			pstmt = conn.prepareStatement(sql);
			
			//2-1. pstmt parameter∫Øºˆ º¬∆√
			pstmt.setInt(1,idx);
			
			
			//3.∞·∞˙«‡√≥∏Æ(ResultSet)∞¥√º »πµÊ
			rs = pstmt.executeQuery();
			
			//¿¸√º«‡ √≥∏Æ
			if(rs.next()) {
				
				//SungVoø° ∆˜¿Â
				vo = new SungVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				vo.setAvg(rs.getString("avg"));
				vo.setRank(rs.getInt("rank"));
		
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			try {
				//¥›±‚:ø™º¯¿∏∑Œ
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}

	
	
	
	public int insert(SungVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//√≥∏Æµ» «‡ºˆ
		Connection conn = null;
		PreparedStatement pstmt = null; 
		//                          parameter index =>                 1 2 3 4                      
		String sql = "insert into sungtb values(seq_sungtb_idx.nextVal,?,?,?,?)";
		
		try {
			//1.Connection»πµÊ
			conn = DBservice.getInstance().getConnection();
			//2.∏Ì∑…√≥∏Æ∞¥√º »πµÊ
			pstmt = conn.prepareStatement(sql);
			
			//3.psmt parameter º≥¡§
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			
			//4.DB insert
			res = pstmt.executeUpdate(); // insert update delete
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	//ºˆ¡§«œ±‚
	public int update(SungVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//√≥∏Æµ» «‡ºˆ
		Connection conn = null;
		PreparedStatement pstmt = null; 
		//                                   1     2     3     4           5
		String sql = "update sungtb set name=?,kor=?,eng=?,mat=? where idx=?";
		try {
			//1.Connection»πµÊ
			conn = DBservice.getInstance().getConnection();
			//2.∏Ì∑…√≥∏Æ∞¥√º »πµÊ
			pstmt = conn.prepareStatement(sql);
			
			//3.psmt parameter º≥¡§
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getIdx());
			
			//4.DB insert
			res = pstmt.executeUpdate(); // insert update delete
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;//√≥∏Æµ» «‡ºˆ
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from sungtb where idx=?";

		try {
			//1.Connection»πµÊ
			conn = DBservice.getInstance().getConnection();
			//2.∏Ì∑…√≥∏Æ∞¥√º »πµÊ
			pstmt = conn.prepareStatement(sql);

			//3.psmt parameter º≥¡§
			pstmt.setInt(1, idx);

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



