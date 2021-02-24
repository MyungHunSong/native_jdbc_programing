package native_jdbc_programing.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import native_jdbc_programing.dao.TitleDao;
// import native_jdbc_programing.dao.TitleDaoTest;
import native_jdbc_programing.dto.Title;
import native_jdbc_programing.util.JdbcUtil;

public class TitleDaoImpl implements TitleDao {
	
	private static final  TitleDaoImpl instance = new TitleDaoImpl();
	// 객체 생성 한개만 해서 instance 객체 하나만 사용하게
	
	
	

	public static TitleDaoImpl getInstance() {
		return instance;
	}

	private TitleDaoImpl() {
		
	}
	

	@Override
	public List<Title> selectTitleByAll() {
		String sql = "select tno,tname from title";
		try(Connection con = JdbcUtil.getconnection();){
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs  = pstmt.executeQuery();{
					if(rs.next()) {
						List<Title> list = new ArrayList<>();
						do {
							list.add(getTitle(rs));
						}while(rs.next());
						// System.out.println(list.size());
						return list;
					}
						
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int tNo = rs.getInt("tno");
		String tName = rs.getNString("tname");
		return new Title(tNo, tName);
	}
	
	

	@Override
	public Title selectTitleByNo(Title title) {
		String sql = "select tno, tname from title where tno = ?";
		try(Connection con = JdbcUtil.getconnection(); //연결 방식
			PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, title.gettNo()); // 파라미션 마크(?)는 1개 뿐인데 2~3... 은 됄수 없잔아
				System.out.println(pstmt);
			
				try(ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) { //만약 이요소가 존재하면 그다음 칸으로 이동해서
						return getTitle(rs); // 인트 tNo와 tName 을 title로 만들어줘서 가져가라
					}
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		
		}

		return null;
	}
	
	
	

	@Override
	public int insertTitle(Title title) {
		String sql = "insert into title values(?, ?)";
		try(Connection con = JdbcUtil.getconnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, title.gettNo());
			pstmt.setString(2, title.gettName());
			return pstmt.executeUpdate(); // select 외에는 다 executeUpdate다
			
		}catch(SQLException e) {
				e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateTitle(Title title) {
		
		String sql = "update title set tname = ? where tno = ?";
		try(Connection con = JdbcUtil.getconnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, title.gettName()); // tname = ? 여기들어감
			pstmt.setInt(2, title.gettNo()); // where tno = ? 여기들어감
			return pstmt.executeUpdate(); // select 외에는 다 executeUpdate다
			
		}catch(SQLException e) {
				e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteTitle(int titleNo) {
		String sql = "delete from title where tno = ?";
		try(Connection con = JdbcUtil.getconnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setInt(1, titleNo);
			
			return pstmt.executeUpdate(); // select 외에는 다 executeUpdate다
			
		}catch(SQLException e) {
				e.printStackTrace();
		}
		return 0;
		
	}

}
