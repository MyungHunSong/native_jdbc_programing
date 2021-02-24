package native_jdbc_programing.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import native_jdbc_programing.dto.Department;
import native_jdbc_programing.dto.Title;
import native_jdbc_programing.util.JdbcUtil;

class TransactionService {// 2/23
	// ------------ ADD -----------//
	public String transAddTitleAndDepartment(Title title, Department dept) {// 요걸로 2개추가 // 추가
		String titleSql = "insert into title values(?, ?)";
		String deptSql = "insert into department values (?, ?, ?)";
		
		Connection con = null;
		PreparedStatement tPstmt = null; // 하나는 타이틀용 하나는 dep용
		PreparedStatement dPstmt = null;
		String res;
		try {
			con = JdbcUtil.getconnection(); // 반드시 요거하나로 하나를 생성해서 던지고 하나를 만들어서 던지고 해야한다
			con.setAutoCommit(false);
			
			tPstmt = con.prepareStatement(titleSql);
			tPstmt.setInt(1, title.gettNo());
			tPstmt.setString(2, title.gettName());
			tPstmt.executeUpdate();
			
			dPstmt = con.prepareStatement(deptSql);
			dPstmt.setInt(1, dept.getDeptNo());
			dPstmt.setString(2, dept.getDeptName());
			dPstmt.setInt(3, dept.getFloor());
			dPstmt.executeUpdate();
			
			con.commit(); // 정상 적으로 수행 됐을때 이걸 호출해야함.
			res = "commit";
		

			
		}catch (SQLException e) {
			res = "rollback";
			rollbackUtil(con);
		}finally {
			closeUtil(con, tPstmt, dPstmt);
		}
		return res;
	}

	
	
	// ------------ REMOVE----------//
	public int transRemoveTtileAndDepartment(Title title, Department dept) {
		String titleSql = "delete from title where tno = ?";
		String deptSql = "delete from department where deptNo = ?";
		
		
		Connection con = null;
		PreparedStatement tPstmt = null;
		PreparedStatement dPstmt = null;
		
		int res = 0;
		
		try {
			con = JdbcUtil.getconnection(); // sql 드라이버를 쓰기위해 커넥션 객체 생성후 연결  
			con.setAutoCommit(false);
			
			System.out.println("res > " + res);
			tPstmt = con.prepareStatement(titleSql); // con = 연결해준  JdbcUtil.getconnection();prepareStatment = 미리준비해논 sql 구문을 쓰기위해 쓰는것
			tPstmt.setInt(1, title.gettNo());
			res += tPstmt.executeUpdate(); // delete 는 지린다 
			System.out.println("res > " + res);
			
			dPstmt = con.prepareStatement(deptSql);
			dPstmt.setInt(1, dept.getDeptNo());
			res += dPstmt.executeUpdate(); // 수정 실행한다.
			System.out.println("res > " + res);
			
			if(res == 2) {
				con.commit();
				System.out.println("commit()");
			}else {
				throw new SQLException();
			}
			con.commit(); 
			System.out.println("commit");
			
		}catch (SQLException e) {
			rollbackUtil(con);
			
		}finally {
			closeUtil(con, tPstmt, dPstmt);
		}
		return res;

	}



	private void closeUtil(Connection con, PreparedStatement tPstmt, PreparedStatement dPstmt) {
		try {
			con.setAutoCommit(true);
			if(tPstmt != null)tPstmt.close();
			if(dPstmt != null)dPstmt.close();
			if(con != null)con.close();
		} catch (SQLException e) {	
			e.printStackTrace();
			
		}
	}



	private void rollbackUtil(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
}
