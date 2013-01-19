package chapter06;

import java.util.List;


/**
 * @author Siva
 *
 */
public interface StudentMapper
{

	List<Student> findAllStudents();

	Student findStudentById(Integer id);

}
