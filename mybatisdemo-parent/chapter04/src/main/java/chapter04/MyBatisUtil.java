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
	private static SqlSessionFactory xmlSqlSessionFactory;
	
	private static final String environment = "development";
	
	public static SqlSessionFactory getSqlSessionFactory()
	{
		return getSqlSessionFactory(environment);
	}
	public static SqlSessionFactory getSqlSessionFactory(String environment)
	{
		return getXmlSqlSessionFactory(environment);
	}
	private static SqlSessionFactory getXmlSqlSessionFactory(String environment)
	{
		if(xmlSqlSessionFactory==null){
			//org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			
			try
			{
				InputStream inputStream = Resources.getResourceAsStream(DEFAULT_MYBATIS_CONFIG_FILE);
				xmlSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, environment);
			} catch (IOException e)
			{
				throw new RuntimeException(e.getCause());
			}
		}
		return xmlSqlSessionFactory;
	}
	
	
}
