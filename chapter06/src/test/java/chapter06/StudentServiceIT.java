package chapter06;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import chapter06.domain.Student;


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
		List<Student> students = null;//studentService.findAllStudents();
		/*for (Student student : students)
		{
			System.out.println(student);
		}*/
		
		for (int i = 0; i < 50; i++)
		{
			System.err.println("Iteration ["+i+"]"+new Date());
			students = studentService.findAllStudents();
			Assert.assertNotNull(students);

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
			Student student = studentService.findStudentById(1);
			System.out.println(student);
		}
	}
}
