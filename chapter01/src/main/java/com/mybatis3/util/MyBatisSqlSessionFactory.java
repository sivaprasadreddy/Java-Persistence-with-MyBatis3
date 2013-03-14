package com.mybatis3.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author Siva
 *
 */
public class MyBatisSqlSessionFactory
{
	private static SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();
	
	private static SqlSessionFactory initSqlSessionFactory() {
		InputStream inputStream;
			try
			{
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}catch (IOException e)
			{
				throw new RuntimeException(e.getCause());
			}
		return sqlSessionFactory;
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	}
}
