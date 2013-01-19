package chapter05;

import java.util.List;

import chapter05.domain.Address;
import chapter05.domain.Student;


/**
 * @author Siva
 *
 */
public interface StudentMapper
{

	List<Student> findAllStudents();

	Student findStudentById(Integer id);

	void insertAddress(Address address);

	void insertStudent(Student student);
}
