package chapter02;

import java.util.List;

import chapter02.domain.Student;

/**
 * @author Siva
 *
 */
public interface StudentMapper
{

	List<Student> findAllStudents();

	Student findStudentById(Integer id);

	void insertStudent(Student student);

	void updateStudent(Student student);

}
