package chapter06;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import chapter06.Student;
import chapter06.StudentService;


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
    public void testFindAllStudents() 
	{
		List<Student> blogs = null;//studentService.findAllStudents();
		/*for (Student blog : blogs)
		{
			System.out.println(blog);
		}*/
		
		for (int i = 0; i < 50; i++)
		{
			System.err.println("Iteration ["+i+"]"+new Date());
			blogs = studentService.findAllStudents();
			Assert.assertNotNull(blogs);

			try {
				Thread.sleep(1000*15);
			} catch (InterruptedException e) {
				
			}
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
