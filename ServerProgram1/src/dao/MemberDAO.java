package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.util.DBConnector;
import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance=new MemberDAO();
	private  MemberDAO () {
		con=DBConnector.getInstance().getConnection();
	}
	public static MemberDAO  getInstance() {
		if(instance==null) {
			instance=new MemberDAO();
		}
		return instance;
	}
	
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	
	/* 전체 회원 */
	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			sql = "SELECT NO,ID,NAME,GRADE,POINT FROM MEMBER_TABLE";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNo(rs.getLong(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setGrade(rs.getString(4));
				dto.setPoint(rs.getLong(5));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return list;
	}
	
	
	
	/* 로그인*/
	public MemberDTO login(MemberDTO dto) {
		MemberDTO loginDTO=null;
		try {
			sql="SELECT NO,ID,NAME,GRADE,POINT FROM MEMBER_TABLE WHERE ID=? AND NAME=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			rs=ps.executeQuery();
			if(rs.next()) {
				loginDTO=new MemberDTO();
				loginDTO.setNo(rs.getLong(1));
				loginDTO.setId(rs.getString(2));
				loginDTO.setName(rs.getString(3));
				loginDTO.setGrade(rs.getString(4));
				loginDTO.setPoint(rs.getLong(5));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return loginDTO;
	}
	
	
	
	
	/* 정보수정*/
	public int updateMember(MemberDTO dto) {
		int result = 0;
		try {
			sql = "UPDATE MEMBER_TABLE SET ID = ?, NAME = ? WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setLong(3, dto.getNo());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return result;
	}
	
	
	
	
}
