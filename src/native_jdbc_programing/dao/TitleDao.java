package native_jdbc_programing.dao;

import java.util.List;

import native_jdbc_programing.dto.Title;

/*	
    R(Select, select where, )
	Create(insert)
	U(update)
	D(delete)
*/
public interface TitleDao {
	List<Title> selectTitleByAll();
	Title selectTitleByNo(Title title); // 하나의 결과 값만 나오기에 (객체지향언어 이기에 안에다 객체로 주고받는다.)
	
	int insertTitle(Title title);
	int updateTitle(Title title);
	int deleteTitle(int titleNo);	
}
