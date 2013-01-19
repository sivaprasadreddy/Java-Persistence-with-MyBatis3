package chapter06;

import java.util.List;

import chapter06.domain.Student;


/**
 * @author Siva
 *
 */
public interface StudentMapper
{

	List<Student> findAllStudents();

	Student findStudentById(Integer id);

}
