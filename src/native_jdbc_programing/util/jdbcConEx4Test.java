package native_jdbc_programing.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class jdbcConEx4Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("%s() %n , setUpBeforeClass()");
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("%s() %n , tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("%s() %n , setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("%s() %n , tearDown");
	}

	@Test
	public void testMain() {
		System.out.println("%s() %n , testMain");
		Connection con = JdbcUtil.getconnection();
		System.out.println("con");
		System.out.println(con);
		
		
	}

}
