package native_jdbc_programing.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import native_jdbc_programing.dao.impl.DepartmentDaoImpl;
import native_jdbc_programing.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {

	private static DepartmentDao dao = DepartmentDaoImpl.getInstance();

	

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void testSelectByAll04() { 
		System.out.printf("%s() %n " , "testSelectByAll()" );
		
		List<Department> departmentList = dao.selectByAll();
		Assert.assertNotNull(departmentList);
		
		for(Department d : departmentList) {
			System.out.println(d);
		}
		
	}
	
	@Test
	public void testSelectDepartmentByNo05() {
		System.out.printf("%s() %n " , "testSelectDepartmentByNo()");
		
		Department department = new Department(5);
		Department searchDepartment = dao.selectDepartmentByNo(department);
		Assert.assertNull(searchDepartment);
	}
	
	@Test
	public void testInsertDepartment01() {
		System.out.printf("%s() %n " , " testInsertDepartment()");
		Department newDepartment = new Department(6, "학살", 3);
		int res = dao.insertDepartment(newDepartment);
		Assert.assertEquals(1, res);
		
		System.out.println(dao.selectDepartmentByNo(newDepartment));
	}
	
	@Test
	public void testUpdateDepartment02() {
		System.out.printf("%s() %n " , "testUpdateDepartment()");
		Department newDepartment = new Department(6, "학살", 5);
		int res = dao.updateDepartment(newDepartment);
		Assert.assertEquals(1, res);
		
		System.out.println(dao.selectDepartmentByNo(newDepartment));
	}
	
	@Test
	public void testDeleteDepartment03() {
		System.out.printf("%s()%n", "testDeleteDepartment");
		int res = dao.deleteDepartment(6);
		Assert.assertEquals(1, res);
		System.out.println(res);
		
		
		
		Assert.assertEquals(1, res);
		
		dao.selectByAll().stream().forEach(System.out::println);
	}

}
