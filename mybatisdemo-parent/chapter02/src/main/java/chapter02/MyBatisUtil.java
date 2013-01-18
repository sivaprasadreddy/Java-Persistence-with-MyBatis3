package chapter02;

import java.io.IOException;
import java.io.InputStream;

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
	private static SqlSessionFactory xmlSqlSessionFactory;
	private static SqlSessionFactory javaSqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactoryUsingXML()
	{
		if(xmlSqlSessionFactory==null) 
		{
			InputStream inputStream;
			try
			{
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				xmlSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}catch (IOException e)
			{
				throw new RuntimeException(e);
			}
		}
		return xmlSqlSessionFactory;
	}
	
	public static SqlSessionFactory getSqlSessionFactoryUsingJavaAPI()
	{
		if(javaSqlSessionFactory==null) 
		{
			try
			{
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/mybatisdemo";
				String username = "root";
				String password = "admin";
				PooledDataSource dataSource = new PooledDataSource(driver, url, username, password);
				TransactionFactory transactionFactory = new JdbcTransactionFactory();
				Environment environment = new Environment("development", transactionFactory, dataSource);
				Configuration configuration = new Configuration(environment);
				configuration.getTypeAliasRegistry().registerAliases("chapter02");
				configuration.addMapper(StudentMapper.class);
				javaSqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
				
			}catch (Exception e)
			{
				throw new RuntimeException(e);
			}
		}
		return javaSqlSessionFactory;
	}
}
