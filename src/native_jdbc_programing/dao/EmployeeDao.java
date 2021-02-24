package native_jdbc_programing.dao;

import java.util.List;

import native_jdbc_programing.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
	Employee selectEmployeeByNo(Employee emp);

	
	int insertEmployee(Employee emp);
	int updateEmployee(Employee emp);
	int deleteEmployee(int employeeNo);
	
	List<Employee> selectEmployeeByAllSimple();

	

}
