package chapter03.annotations;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import chapter03.domain.Address;
import chapter03.domain.Course;
import chapter03.domain.Student;
import chapter03.domain.Tutor;


/**
 * @author Siva
 *
 */
public interface AnnotatedStudentMapper
{
	
	@Select("select * from addresses where addr_id=#{id}")
	@ResultMap("chapter03.xml.StudentMapper.AddressResult")
	Address selectAddressById(int id);
	
	@Select("select * from students")
	@Results({
			@Result(id=true, column="stud_id", property="id"),
			@Result(column="name", property="name"),
			@Result(column="email", property="email"),
			@Result(column="addr_id", property="address.id")			
	})
	List<Student> findAllStudents();

	@Select("select stud_id as id, name, email, addr_id as 'address.id', phone from students where stud_id=#{id}")
	Student findStudentById(Integer id);

	@Select("select stud_id, name, email, a.addr_id, street, city, state, zip, country"+
  		" FROM students s left outer join addresses a on s.addr_id=a.addr_id"+
		" where stud_id=#{studId} ")
	@ResultMap("chapter03.xml.StudentMapper.StudentWithAddressResult")
	Student selectStudentWithAddress(int id);
	
	@Insert("insert into students(name,email,addr_id, phone) values(#{name},#{email},#{address.id},#{phone})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	void insertStudent(Student student);
	
	@Insert("insert into students(name,email,addr_id, phone) values(#{name},#{email},#{address.id},#{phone})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	void insertStudentWithMap(Map<String, Object> map);

	@Update("update students set name=#{name}, email=#{email}, phone=#{phone} where stud_id=#{id}")
	void updateStudent(Student student);
	
	@Delete("delete from students where stud_id=#{id}")
	int deleteStudent(int id);
	
	@Select("select * from courses where tutor_id=#{tutorId}")
	@ResultMap("chapter03.xml.StudentMapper.CourseResult")
	List<Course> selectCoursesByTutorId(int tutorId);
	
	@Select("SELECT tutor_id, t.name as tutor_name, email, addr_id "+
		" FROM tutors t where t.tutor_id=#{tutorId}")
	@Results({
		@Result(id=true, column="tutor_id", property="id"),
		@Result(column="tutor_name", property="name"),
		@Result(column="email", property="email"),
		@Result(property="address", column="addr_id",
				one=@One(select="chapter03.annotations.AnnotatedStudentMapper.selectAddressById")),
		
		@Result(property="courses", column="tutor_id",
				many=@Many(select="chapter03.annotations.AnnotatedStudentMapper.selectCoursesByTutorId"))		
		
		
	})
	Tutor selectTutorById(int tutorId);

}
