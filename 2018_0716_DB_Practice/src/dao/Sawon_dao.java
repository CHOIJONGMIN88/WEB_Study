package dao;
import vo.Sawon_vo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.DBservice;

public class Sawon_dao {


	static Sawon_dao single = null;

	public static Sawon_dao getInstance() {
		if (single == null)
			single = new Sawon_dao();
		return single;
	}

	public Sawon_dao() {
		// TODO Auto-generated constructor stub
	}
	
	
public List<Sawon_vo> selectList() {

	

	
	List<Sawon_vo> list = new ArrayList<Sawon_vo>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select*from sawon";

	try {
		//1.Connectionȹ��
		conn = DBservice.getInstance().getConnection();

		//2.���ó��(PreparedStatement)��ü ȹ��
		pstmt = conn.prepareStatement(sql);

		//3.�����ó��(ResultSet)��ü ȹ��
		rs = pstmt.executeQuery();

		//��ü�� ó��
		while (rs.next()) {

			//rs�� ���� ���ڵ��� ���� �о����
			//Sawon_dao�� ����
			Sawon_vo vo = new Sawon_vo();
			vo.setSasex(rs.getString("sasex"));
			vo.setDeptno(rs.getInt("deptno"));
			vo.setSabun(rs.getInt("sabun"));
			vo.setSaname(rs.getString("saname"));
			vo.setSajob(rs.getString("sajob"));
			vo.setSahire(rs.getString("sahire"));
			vo.setSamgr(rs.getInt("samgr"));
			vo.setSapay(rs.getInt("sapay"));
			
			
			
			//ArrayList��´�
			list.add(vo);
		}

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {

		try {
			//�ݱ�:��������
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




}
