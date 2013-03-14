package com.mybatis3.services;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.mybatis3.domain.Student;



/**
 * @author Siva
 *
 */
public class StudentServiceTest 
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
			System.out.println(student);
		}
		
	}
	
	@Test
    public void testFindStudentById() 
	{
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
		System.out.println(student);
	}
	
	//@Test
    public void testFindStudentByEmail() 
	{
		Student student = studentService.findStudentByEmail("student_1gmail.com");
		Assert.assertNotNull(student);
		System.out.println(student);
	}
	
	@Test
	@Ignore
	public void testCreateUStudent() 
	{
		Student student = new Student();
		int id = 4;
		student.setStudId(id);
		student.setName("student_"+id);
		student.setEmail("student_"+id+"gmail.com");
		student.setDob(new Date());
		studentService.createStudent(student);
		Student newStudent = studentService.findStudentById(id);
		Assert.assertNotNull(newStudent);
	}
	
	@Test
	@Ignore
	public void testUpdateStudent() 
	{
		int id = 3;
		Student student =studentService.findStudentById(id);
		student.setStudId(id);
		student.setName("student_"+id);
		student.setEmail("student_"+id+"gmail.com");
		Date now = new Date();
		student.setDob(now);
		studentService.updateStudent(student);
		Student updatedStudent = studentService.findStudentById(id);
		Assert.assertNotNull(updatedStudent);
	}
}
