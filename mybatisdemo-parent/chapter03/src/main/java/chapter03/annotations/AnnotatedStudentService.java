package chapter03.annotations;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chapter03.domain.Student;
import chapter03.domain.Tutor;


public class AnnotatedStudentService 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<Student> findAllStudents()
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnnotatedStudentMapper AnnotatedStudentMapper = sqlSession.getMapper(AnnotatedStudentMapper.class);
			logger.debug("AnnotatedStudentMapper-DEBUG :"+AnnotatedStudentMapper);
			return AnnotatedStudentMapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
	
	public Student findStudentById(Integer id)
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnnotatedStudentMapper blogMapper = sqlSession.getMapper(AnnotatedStudentMapper.class);
			logger.debug("AnnotatedStudentMapper-DEBUG :"+blogMapper);
			return blogMapper.findStudentById(id);
		} finally {
			sqlSession.close();
		}
	}

	public Student findStudentWithAddressById(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnnotatedStudentMapper blogMapper = sqlSession.getMapper(AnnotatedStudentMapper.class);
			return blogMapper.selectStudentWithAddress(id);
		} finally {
			sqlSession.close();
		}
	}
	
	public Student createStudent(Student student) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnnotatedStudentMapper mapper = sqlSession.getMapper(AnnotatedStudentMapper.class);
			mapper.insertStudent(student);
			sqlSession.commit();
			return student;
		} 
		catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
		finally {
			sqlSession.close();
		}
	}
	
	public void createStudentWithMap(Map<String, Object> studentDataMap) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnnotatedStudentMapper mapper = sqlSession.getMapper(AnnotatedStudentMapper.class);
			System.err.println("with map");
			mapper.insertStudentWithMap(studentDataMap);
			sqlSession.commit();
		} 
		catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
		finally {
			sqlSession.close();
		}
	}

	public Student updateStudent(Student student) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnnotatedStudentMapper mapper = sqlSession.getMapper(AnnotatedStudentMapper.class);
			mapper.updateStudent(student);
			sqlSession.commit();
			return student;
		} 
		catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
		finally {
			sqlSession.close();
		}
	}
	
	public boolean deleteStudent(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnnotatedStudentMapper mapper = sqlSession.getMapper(AnnotatedStudentMapper.class);
			int count = mapper.deleteStudent(id);
			sqlSession.commit();
			return count > 0;
		} 
		catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
		finally {
			sqlSession.close();
		}
	}
	
	public Tutor findTutorById(int tutorId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AnnotatedStudentMapper mapper = sqlSession.getMapper(AnnotatedStudentMapper.class);
			return mapper.selectTutorById(tutorId);
		} 
		
		finally {
			sqlSession.close();
		}
	}
}
