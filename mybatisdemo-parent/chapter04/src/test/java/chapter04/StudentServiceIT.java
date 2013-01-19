package chapter04;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import chapter04.Address;
import chapter04.Student;
import chapter04.StudentService;


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
	
	@Test
    public void testCreateStudent() 
	{
		Address address = new Address();
		address.setStreet("kukatpally");
		address.setCity("Hyd");
		address.setState("AP");
		address.setZip("500012");
		address.setCountry("India");
		
		Student student = new Student();
		student.setAddress(address);
		student.setEmail("test@gmail.com");
		student.setName("neha1");

		Student createdStudent = studentService.createStudent(student);
		Assert.assertNotNull(createdStudent);
		System.err.println(createdStudent.getId()+":"+createdStudent.getAddress().getId());
	}
	
	//@Test
    public void testFindAllStudents() 
	{
		List<Student> blogs = studentService.findAllStudents();
		Assert.assertNotNull(blogs);
		for (Student blog : blogs)
		{
			System.out.println(blog);
		}
		
		for (int i = 0; i < 5; i++)
		{
			blogs = studentService.findAllStudents();
		}
	}
	
	//@Test
    public void testFindStudentById() 
	{
		for (int i = 0; i < 5; i++)
		{
			Student blog = studentService.findStudentById(1);
			System.out.println(blog);
		}
	}
}
