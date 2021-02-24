package native_jdbc_programing.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import native_jdbc_programing.dao.DepartmentDao;
import native_jdbc_programing.dto.Department;
import native_jdbc_programing.util.JdbcUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	private static final  DepartmentDaoImpl instance = new DepartmentDaoImpl();
	
	
	

	public static DepartmentDaoImpl getInstance() {
		
		return instance;
	}
	
	

	public DepartmentDaoImpl() {
		
	}
	
	
	



	@Override
	public List<Department> selectByAll() {
		String sql = "select deptNo, deptName, floor from department";
		 try(Connection con = JdbcUtil.getconnection();){
			PreparedStatement pstmt = con.prepareStatement(sql); // 이거 머하는놈임?
			ResultSet rs = pstmt.executeQuery();{
				if(rs.next()) {
					List<Department> list = new ArrayList<>();
					
					do { 
						list.add(getDepartment(rs)); // getDepartment 에서 작업한 내용을 여기에다가 추가
						
					}while(rs.next()); 
					
					return list; // 리스트를 리턴해돌라
				}
			}
			 
		 }catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt("deptNo");
		String deptName = rs.getString("deptName");
		int floor = rs.getInt("floor");
		return new Department(deptNo, deptName,floor);
	}
	
	
	
	
	



	@Override
	public Department selectDepartmentByNo(Department department) {
		String sql = "select  deptNo, deptName, floor from department where deptNo = ?";
		try(Connection con = JdbcUtil.getconnection();
			PreparedStatement ptsmt = con.prepareStatement(sql)){
			ptsmt.setString(1, department.getDeptName());
			System.out.println(ptsmt);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		
		return null;
	}
	
	
	
	
	
	
	
	

	@Override
	public int insertDepartment(Department department) {
		String sql = "insert into department values (?, ?, ?)";
		try(Connection con = JdbcUtil.getconnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			
		pstmt.setInt(1, department.getDeptNo());
		pstmt.setString(2, department.getDeptName());
		pstmt.setInt(3, department.getFloor());
		
		return pstmt.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return 0;
}
	
	
	
	
	
	
	
	
	
	@Override
	public int updateDepartment(Department department) {
		
		String sql = "update department set deptNo = ? where deptName = ?";
		try(Connection con = JdbcUtil.getconnection();
				
				PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setInt(1, department.getDeptNo());
			pstmt.setString(2, department.getDeptName());
			
			
			
			return pstmt.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	

	@Override
	public int deleteDepartment(int departmentNo) {
		
		String sql = "delete from department where deptNo = ?";
		try(Connection con = JdbcUtil.getconnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setInt(1, departmentNo);		
			
			return pstmt.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return 0;
	}



	
	
	
}
