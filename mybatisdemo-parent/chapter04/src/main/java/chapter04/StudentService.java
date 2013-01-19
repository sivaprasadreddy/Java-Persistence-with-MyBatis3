package chapter04;

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
	
	public Student createStudent(Student student)
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertAddress(student.getAddress());
			if(student.getName().equalsIgnoreCase("")){
				throw new RuntimeException("Student name should not be empty.");
			}
			studentMapper.insertStudent(student);
			sqlSession.commit();
		} 
		catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		finally {
			sqlSession.close();
		}
		return student;
	}
}
