package chapter05;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chapter05.domain.Student;

@Service
@Transactional
public class StudentService 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private StudentMapper studentMapper;
	
	public List<Student> findAllStudents()
	{
		return studentMapper.findAllStudents();
	}
	
	public Student findStudentById(Integer id)
	{
		logger.debug("findStudentById :"+id);
		return studentMapper.findStudentById(id);
	}
	
	public Student createStudent(Student student)
	{
		studentMapper.insertAddress(student.getAddress());
		if(student.getName().equalsIgnoreCase("")){
			throw new RuntimeException("Student name should not be empty.");
		}
		studentMapper.insertStudent(student);
		
		return student;
	}
}
