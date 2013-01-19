package chapter02;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chapter02.domain.Student;

public class StudentService 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SqlSession openSqlSession()
	{
		//return MyBatisUtil.getSqlSessionFactoryUsingXML().openSession();
		return MyBatisUtil.getSqlSessionFactoryUsingJavaAPI().openSession();
	}
	public List<Student> findAllStudents()
	{
		SqlSession sqlSession = openSqlSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
	
	public Student findStudentById(Integer studId)
	{
		logger.debug("Select Student By ID :{}", studId);
		SqlSession sqlSession = openSqlSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(studId);
			//return sqlSession.selectOne("chapter01.StudentMapper.findStudentById", studId);
		} finally {
			sqlSession.close();
		}
	}
	
	public void createStudent(Student student)
	{
		SqlSession sqlSession = openSqlSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void updateStudent(Student student)
	{
		SqlSession sqlSession = openSqlSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.updateStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
