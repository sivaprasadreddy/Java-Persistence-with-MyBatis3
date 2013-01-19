package chapter05;

import java.util.List;


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
