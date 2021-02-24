package native_jdbc_programing.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import native_jdbc_programing.dao.EmployeeDao;
import native_jdbc_programing.dao.impl.EmployeeDaoImpl;
import native_jdbc_programing.dto.Department;
import native_jdbc_programing.dto.Employee;
import native_jdbc_programing.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	
	
	private static  EmployeeDao dao = EmployeeDaoImpl.getInstance();

	



	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test05SelectEmployeeByAll() {
		System.out.printf("%s()%n", "testSelectEmployeeByAll()");
		
		List<Employee> employeeList = dao.selectEmployeeByAll();
		Assert.assertNotNull(employeeList);
		
		for(Employee e : employeeList) {
			System.out.println(e);
		}
		
	}
	
	
	

	@Test
	public void test04SelectEmployeeByNo() {
		System.out.printf("%s()%n", "testSelectEmployeeByNo()");
		
		Employee selEmp = new Employee(2106);
		Employee searchEmployee = dao.selectEmployeeByNo(selEmp);
		
		Assert.assertNotNull(searchEmployee);
		System.out.println(searchEmployee);
	}

	
	
	
	
	
	
	
	
	@Test
	public void test01InsertEmployee() {
		System.out.printf("%s()%n", "testInsertEmployee()");
		Employee newEmp = new Employee(1004, "천사",  new Title(5) ,new Employee(4377), 2000000, new Department(1));
		int res = dao.insertEmployee(newEmp);
		
		Assert.assertEquals(1, res);
		
		
		
		System.out.println(dao.selectEmployeeByNo(newEmp));
	}

	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void test02UpdateEmployee() {
		System.out.printf("%s()%n", "testUpdateEmployee()");
		Employee newEmployee = new Employee(1004, "니하오",  new Title(4) ,new Employee(1003), 3000000, new Department(2));
		int res = dao.updateEmployee(newEmployee);
		// Assert.assertEquals(1, res); 
		
		
		
		
		System.out.println(newEmployee);
	}

	
	
	
	
	
	
	
	
	
	@Test
	public void test03DeleteEmployee() {
		System.out.printf("%s()%n", "testDeleteEmployee()");
		int res = dao.deleteEmployee(1004);
		Assert.assertEquals(1, res);
		
		dao.selectEmployeeByAll().stream().forEach(System.out::println);
		
		

	}

}
