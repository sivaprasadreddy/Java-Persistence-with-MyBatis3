package chapter03;

import java.util.List;
import java.util.Map;

import chapter03.domain.Student;
import chapter03.domain.Tutor;


/**
 * @author Siva
 *
 */
public interface StudentMapper
{

	List<Student> findAllStudents();

	Student findStudentById(Integer id);

	Student selectStudentWithAddress(int id);
	
	void insertStudent(Student student);
	void insertStudentWithMap(Map<String, Object> map);

	void updateStudent(Student student);
	
	int deleteStudent(int id);
	
	Tutor selectTutorById(int tutorId);

}
