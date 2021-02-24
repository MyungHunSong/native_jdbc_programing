package native_jdbc_programing.ch01; // 여기께 정말 중요한 것이다 근데 미친 기억이 안난다

import java.sql.Connection;// 위에것들 다 임포트 java.sql
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import native_jdbc_programing.dto.Department;

public class JdbcConEx {// 왜저따가 lib를 저따 만들엇냐. 누구는 다따르게 받을텐데 저렇게 해주면 다 통일되게 쓸수있다.

	public static void main(String[] args) {
		ArrayList<Department> list = null;
		
		String url = "jdbc:mysql://localhost:3306/mysql_study?useSSL=false"; // 요db에 접근하겟습니다.
		String user = "user_mysql_study";
		String password = "rootroot";
		
		String sql = "select deptno, deptname, floor from department";
		
		try (Connection con = DriverManager.getConnection(url, user, password);){
			Statement stmt = con.createStatement(); // 요거 일단 이렇게 한다는건 알아둬야해 근데 이거 쓰면 ㅈ댈수도 있따 sql ingection 공격에 줫털릴수도 있따.
			 ResultSet rs = stmt.executeQuery(sql); 
			// 1. jdbc 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			list = new ArrayList<>(); // 동적으로 하기위해서 벡터를 쓴다 늘여낫다 줄여낫다를 하기위해서라면.
			System.out.println("con " + con);

			System.out.println("stat > " + stmt);

		
			
			 
			while (rs.next()) {
				list.add(getDepartment(rs));
		
				// 컬럼 레이블은 deptno, deptname, floor 를 말한다
				// int deptno = rs.getInt("deptno");
				// String deptName = rs.getNString("deptname");
				// int floor = rs.getInt("floor");

				/*
				 * Department dept = getDepartment(rs); System.out.println(dept);
				 */
			}
			System.out.println(list);

		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver Not Found");
		} catch (SQLException e) {// 이거 왜안됌?
			e.printStackTrace();
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
