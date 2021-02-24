package native_jdbc_programing.ch01;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

 // 면접볼때 한사람과 안한사람의 차이는 크다.

public class MathExTest {
	int res;
	
	private static MathEx m;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		m = new MathEx(); 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		m = null;
	}

	@Before
	public void setUp() throws Exception {
		m.setA(5);
		m.setB(3);
	}

	
	@After
	public void tearDown() throws Exception {
		res = m.add();
		
		
	}

	@Test
	public void testAdd() {
		 res = m.add();
		Assert.assertEquals(8, res);
	}

	@Test
	public void testSub() {
		int res = m.sub();
		Assert.assertEquals(2, res);
	}

}
