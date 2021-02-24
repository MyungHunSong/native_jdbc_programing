package native_jdbc_programing.dao;

import java.util.List;

import native_jdbc_programing.dto.Department;

public interface DepartmentDao {
	List<Department> selectByAll();
	Department selectDepartmentByNo(Department department);
	
	int insertDepartment(Department department);
	int updateDepartment(Department department);
	int deleteDepartment(int departmentNo);
	
	
}
