package chapter06;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StudentService 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<Student> findAllStudents()
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			logger.debug("StudentMapper-DEBUG :"+studentMapper);
			return studentMapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
	
	public Student findStudentById(Integer blogId)
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			StudentMapper blogMapper = sqlSession.getMapper(StudentMapper.class);
			logger.debug("StudentMapper-DEBUG :"+blogMapper);
			return blogMapper.findStudentById(blogId);
		} finally {
			sqlSession.close();
		}
	}
}
