package native_jdbc_programing.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class JdbcUtil {
		Connection con = JdbcUtil.getconnection();
		 // con > com.mysql.jdbc.JDBC4Connection@2cdf8d8a 연결 성공 표시
	

	public static Connection getconnection() {

		String propertiesPath = "db.properties"; // 이게 이름이 동일해야한다
		Connection con = null;
		try (InputStream in = ClassLoader.getSystemResourceAsStream(propertiesPath)) { // 리소스에 있는 파일을 불러 올려면 이방법 을 써야한다
																						// 이걸 stream 의 형태로 가져온다
			Properties prop = new Properties(); // 요기다가 담고 키 = 벨류(값) 타입으로 돌려준다
			prop.load(in);
			con = DriverManager.getConnection(prop.getProperty("url"), prop);

			/*
			 * System.out.println("prop > " + prop); // 위에 2친구는 외워야 한다. for(Entry<Object,
			 * Object> e: prop.entrySet()) { // 둘다 불러오라는말이다 key = value 각각 <object = object>
			 * 라는 말이다 System.out.printf("%s -> %s%n", e.getKey(), e.getValue()); }
			 * for(Object key : prop.keySet()) { System.out.println(key + " -> ");
			 * System.out.println(prop.get(key)); // 해쉬함수의 특징이다 hash(key) 를 써주면 해당 value 를
			 * 바로 가져온다. }
			 */

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}// properties 의 특징이라 
