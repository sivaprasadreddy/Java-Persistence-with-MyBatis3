package chapter04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import chapter04.domain.PhoneNumber;
import chapter04.domain.Student;
import chapter04.domain.Tutor;



public class StudentServiceIT 
{
	private static StudentService studentService;
	
	@BeforeClass
	public static void setup()
	{
		studentService = new StudentService();
	}
	@AfterClass
	public static void teardown()
	{
		studentService = null;
	}
	
	//@Test
    public void testFindAllStudents() 
	{
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		for (Student student : students)
		{
			System.err.println(student);
		}
		
	}
	
	//@Test
    public void testFindStudentById() 
	{
		Student student = studentService.findStudentById(1);
		System.err.println(student);
		//System.err.println(student.getAddress().getId()+":"+student.getAddress().getCity());
		
	}
	
	//@Test
    public void testFindStudentWithAddressById() 
	{
		Student student = studentService.findStudentWithAddressById(2);
		System.err.println(student);
		System.err.println(student.getAddress().getId()+":"+student.getAddress().getCity());
	}
	
	//@Test
	public void testCreateStudent() 
	{
		Student stud = new Student();
		long ts = System.currentTimeMillis();
		stud.setName("stud_"+ts);
		stud.setEmail("stud_"+ts+"@gmail.com");
		stud.setPhone(new PhoneNumber("123-456-7890"));
		Student student = studentService.createStudent(stud);
		System.err.println("CreatedStudent: "+student);
		
	}
	
	//@Test
	public void testCreateStudentWithMap() 
	{
		Map<String, Object> studMap = new HashMap<String, Object>();
		long ts = System.currentTimeMillis();
		studMap.put("name","stud_"+ts);
		studMap.put("email","stud_"+ts+"@gmail.com");
		studMap.put("phone",null);
		studentService.createStudentWithMap(studMap);
		
	}
	//@Test
	public void testUpdateStudent() 
	{
		Student stud = new Student();
		long ts = System.currentTimeMillis();
		stud.setId(2);
		stud.setName("studddd_"+ts);
		stud.setEmail("studddd_"+ts+"@gmail.com");
		Student student = studentService.updateStudent(stud);
		System.err.println("UpdatedStudent: "+student);
		
	}
	
	//@Test
	public void testDeleteStudent() {
		boolean deleteStudent = studentService.deleteStudent(12);
		System.err.println("deleteStudent:"+deleteStudent);
	}
	
	@Test
	public void testFindTutorById() {
		Tutor tutor = studentService.findTutorById(1);
		System.err.println(tutor);
	}
	
}
