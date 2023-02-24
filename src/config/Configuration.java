package config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Configuration {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			// sql session factory 개체를 준비한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//InputStream stream = Resources.getResourceAsStream("config/sqlMapConfig.xml");
			//sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream,"hr");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//or mapper
	public static <T> T getMapper(Class<T> arg) {
		return sqlSessionFactory.openSession(true).getMapper(arg);
	} //openSession 을 통해 oracle로 넘어간다. + commit
}
