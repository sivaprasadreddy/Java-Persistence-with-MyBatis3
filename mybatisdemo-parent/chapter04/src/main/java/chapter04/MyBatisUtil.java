package chapter04;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author Siva
 *
 */
public class MyBatisUtil
{
	private static final String DEFAULT_MYBATIS_CONFIG_FILE="mybatis-config.xml";
	private static final SqlSessionFactory sqlSessionFactory;
	
	static
	{
		InputStream inputStream;
		try
		{
			inputStream = Resources.getResourceAsStream(DEFAULT_MYBATIS_CONFIG_FILE);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e)
		{
			throw new RuntimeException(e.getCause());
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory()
	{
		if(sqlSessionFactory==null){
			throw new RuntimeException("Unable to build SqlSessionFactory.");
		}
		return sqlSessionFactory;
	}
}
