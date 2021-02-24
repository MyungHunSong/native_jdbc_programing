package native_jdbc_programing.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import native_jdbc_programing.dao.impl.TitleDaoImpl;
import native_jdbc_programing.dto.Title;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest {
	
	private static TitleDao dao = TitleDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testSelectTitleByAll04() {
		System.out.printf("%s()%n", "testSelectTitleByAll()");
		List<Title> titleList = dao.selectTitleByAll();
		Assert.assertNotNull(titleList);
		
//		titleList.stream().forEach(System.out::println); 이건 swing 에있는것이다.
		for(Title t : titleList) { // 왼쪽에 선한한것을 오른쪽의 titleList 길이만큼 반복해 준다.
			System.out.println(t);
		}
	}
	


	@Test
	public void testSelectTitleByNo05() {
		System.out.printf("%s()%n" , "testSelectTitleByNo()");
		Title title = new Title(5);
		Title searchTitle = dao.selectTitleByNo(title);
		Assert.assertNotNull(searchTitle);
		System.out.println(searchTitle);
	}

	@Test
	public void testInsertTitle01() {
		System.out.printf("%s()%n", "testInsertTitle()");
		Title newTitle = new Title(6, "인턴");
		int res = dao.insertTitle(newTitle);
		Assert.assertEquals(1, res); //자바용 단위 테스트 작성을 위한 프레임워크
		
		System.out.println(dao.selectTitleByNo(newTitle));
		
	}

	@Test
	public void testUpdateTitle02() {
		System.out.printf("%s()%n", "testUpdateTitle");
		Title newTitle = new Title(6, "계약직");
		int res = dao.updateTitle(newTitle);
		Assert.assertEquals(1, res);
		
		
		
		System.out.println(dao.selectTitleByNo(newTitle));
		
	}

	@Test
	public void testDeleteTitle03() {
		System.out.printf("%s()%n", "testDeleteTitle");
		int res = dao.deleteTitle(6);
		Assert.assertEquals(1, res);
		dao.selectTitleByAll().stream().forEach(System.out::println);
	}

}
