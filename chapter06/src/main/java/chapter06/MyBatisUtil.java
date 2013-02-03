package chapter06;

import java.io.IOException;
import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * @author Siva
 *
 */
public class MyBatisUtil
{
	private static final String DEFAULT_MYBATIS_CONFIG_FILE="mybatis-config.xml";
	private static SqlSessionFactory xmlSqlSessionFactory;
	private static SqlSessionFactory javaSqlSessionFactory;
	
	private static final boolean USE_JAVA_API = false;
	private static final String environment = "development";
	
	public static SqlSessionFactory getSqlSessionFactory()
	{
		return getSqlSessionFactory(environment);
	}
	public static SqlSessionFactory getSqlSessionFactory(String environment)
	{
		if(USE_JAVA_API){
			return getJavaSqlSessionFactory(environment);
		}else{
			return getXmlSqlSessionFactory(environment);
		}
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
	
	private static SqlSessionFactory getJavaSqlSessionFactory(String environment)
	{
		if(javaSqlSessionFactory==null)
		{
			//org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			
			DataSource dataSource = getDataSource();
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Environment env = new Environment(environment, transactionFactory, dataSource);
			Configuration configuration = new Configuration(env);
			//configuration.getTypeAliasRegistry().registerAlias("Student",Student.class);
			configuration.getTypeAliasRegistry().registerAliases("com.mybatisapp.chapter02");
			configuration.addMapper(StudentMapper.class);
			javaSqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
			
		}
		return javaSqlSessionFactory;
		
	}
	
	private static DataSource getDataSource()
	{
		PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/mybatisapp");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        return dataSource;
	}
}
