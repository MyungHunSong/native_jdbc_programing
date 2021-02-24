package native_jdbc_programing.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import native_jdbc_programing.dto.Department;
import native_jdbc_programing.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionServiceTest {
	private static TransactionService service;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new TransactionService();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		//TransactionServiceTest를 실행한 후에 수정
		service = null;
	}
	
	@After
	public void tearDown() throws Exception {
		// 메서드 끝날때 마다 호출
		System.out.println();
	}
	
	@Test
	public void test01TransAddTitleAndDepartment_FailTitle() {
		System.out.printf("%s()%n", "testTransAddTitleAndDepartment_FailTitle()");
		Title title = new Title(1, "인턴");
		Department dept = new Department(5, "비상계획부", 10);
		
		String res = service.transAddTitleAndDepartment(title, dept);
		Assert.assertEquals("rollback", res);
	}
	
	@Test
	public void test02TransAddTitleAndDepartment_FailDEpt() {
		
		System.out.printf("%s()%n", "testTransAddTitleAndDepartment_FailDEpt()");
		
		Title title = new Title(6, "인턴");
		Department dept = new Department(1, "비상계획부", 10);
		
		String res = service.transAddTitleAndDepartment(title, dept);
		Assert.assertEquals("rollback", res);
	}



	@Test
	public void test03TransAddTitle_FailTitle_FailBoth() {
		
		System.out.printf("%s()%n", "testTransAddTitle_FailTitle_FailBoth()");
		Title title = new Title(1, "인턴");
		Department dept = new Department(1, "비상계획부", 10);
		
		String res = service.transAddTitleAndDepartment(title, dept);
		Assert.assertEquals("rollback", res);
		
	}
	
	@Test
	public void test04TransAddTitleAndDepartment_Success() {
		
		System.out.printf("%s()%n", "testTransAddTitleAndDepartment_Success()");
		Title title = new Title(6, "인턴");
		Department dept = new Department(5, "비상계획부", 10);
		
		String res = service.transAddTitleAndDepartment(title, dept);
		Assert.assertEquals("commit", res);
	}
	
// 1 Remove
	@Test
	public void test05TransAddTitleAndDepartmentFailTitle() {
		System.out.printf("%s()%n", "Remove - test05TransAddTitleAndDepartmentFailTitle()");
		Title title = new Title(0);
		Department dept = new Department(5);
		
		int res = service.transRemoveTtileAndDepartment(title, dept);
		Assert.assertEquals(1, res); // 기대값 0 이 
		
	}
	
	
// 2 Remove
	@Test
	public void test06TransRemoveTtileAndDepartmentFailDEpt() {
		System.out.printf("%s()%n", "Remove - test06TransRemoveTtileAndDepartmentFailDEpt()");
		Title title = new Title(6);
		Department dept = new Department(0);
		
		int res = service.transRemoveTtileAndDepartment(title, dept);
		Assert.assertEquals(1, res); // 기대값 0 이 
		
		
// 3 Remove
	}
	@Test
	public void test07TransAddTitleAndDepartment_FailBoth() {
		System.out.printf("%s()%n", "Remove - test07TransAddTitleAndDepartment_FailBoth()");
		Title title = new Title(0);
		Department dept = new Department(0);
		
		int res = service.transRemoveTtileAndDepartment(title, dept);
		Assert.assertEquals(0, res); 
		
		
	}
//	4 Remove	
	@Test
	public void test08TransAddTitleAndDepartmentSuccess() {
	
		Title title = new Title(6);
		Department dept = new Department(5);
		
		int res = service.transRemoveTtileAndDepartment(title, dept);
		Assert.assertEquals(2, res); // 기대값 0 이 
		
	}

	
}
