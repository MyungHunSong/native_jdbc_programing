package native_jdbc_programing.ch01;

import java.sql.Connection;// 위에것들 다 임포트 java.sql
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import native_jdbc_programing.dto.Department;

public class JdbcConEx2 {// 왜저따가 lib를 저따 만들엇냐. 누구는 다따르게 받을텐데 저렇게 해주면 다 통일되게 쓸수있다.

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<Department> list = null;
		
		try {
			// 1. jdbc 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 데이터베이스 커넥션 생성
			String url = "jdbc:mysql://localhost:3306/mysql_study?useSSL=false"; // 요db에 접근하겟습니다.
			String user = "user_mysql_study";
			String password = "rootroot";
			 con = DriverManager.getConnection(url, user, password);
			System.out.println("con " + con);
			
			// 3. statement 생성
			String sql = "insert into department values(?, ?, ?)"; 
			pstmt = con.prepareStatement(sql); // 요거 일단 이렇게 한다는건 알아둬야해 근데 이거 쓰면 ㅈ댈수도 있따 sql ingection 공격에 줫털릴수도 있따.
			System.out.println("pstmt > " + pstmt);
			
			Department newDept = new Department(8,"회계", 11);
			
			pstmt.setInt(1, newDept.getDeptNo());
			pstmt.setNString(2, newDept.getDeptName());
			pstmt.setInt(3, newDept.getFloor());

			// 4. pstmt 실행
			int res = pstmt.executeUpdate();
			if(res == 1) {
				System.out.println("추가 성공");
			}else {
				System.out.println("추가 실패");
			}
			
			

			// 5. 쿼리 실행결과 출력.
			 list = new ArrayList<>(); // 동적으로 하기위해서 벡터를 쓴다 늘여낫다 줄여낫다를 하기위해서라면.
			 
		
		
				// 컬럼 레이블은 deptno, deptname, floor 를 말한다
				// int deptno = rs.getInt("deptno");
				// String deptName = rs.getNString("deptname");
				// int floor = rs.getInt("floor");

				/*
				 * Department dept = getDepartment(rs); System.out.println(dept);
				 */
			
			System.out.println(list);

		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver Not Found");
		} catch (SQLException e) {// 이거 왜안됌?
			e.printStackTrace();
		} finally {// 6. 커넥션 종료
			try {pstmt.close(); } catch (SQLException e) {}
			try {con.close(); } catch (SQLException e) {}		
		}
		System.out.println("Department Query 결과는");
		for(Department d : list) {
			System.out.println(d);
		}
	}

	private static Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt("deptno");
		String deptName = rs.getNString("deptname");
		int floor = rs.getInt("floor");
		return new Department(deptNo, deptName, floor);
	}

}
