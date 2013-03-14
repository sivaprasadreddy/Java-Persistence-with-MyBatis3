package com.mybatis3.services;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis3.domain.Student;
import com.mybatis3.util.MyBatisUtil;

public class StudentServiceTest 
{
	private static StudentService studentService;
	
	@BeforeClass
	public static void setup()
	{
		SqlSessionFactory sqlSessionFactory =  null;
		//Use this if you want XML based configuration
		sqlSessionFactory = MyBatisUtil.getSqlSessionFactoryUsingXML();
		//Use this if you want to use Java API configuration
		//sqlSessionFactory = MyBatisUtil.getSqlSessionFactoryUsingJavaAPI();
		studentService = new StudentService(sqlSessionFactory);
	}
	
	@AfterClass
	public static void teardown()
	{
		studentService = null;
	}
	
	@Test
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
	
	@Test
	public void testCreateUStudent() 
	{
		Student student = new Student();
		long id = System.currentTimeMillis();
		student.setName("student_"+id);
		student.setEmail("student_"+id+"gmail.com");
		student.setDob(new Date());
		studentService.createStudent(student);
		Student newStudent = studentService.findStudentById(student.getId());
		Assert.assertNotNull(newStudent);
	}
	
	@Test
	public void testUpdateStudent() 
	{
		int id = 1;
		Student student =studentService.findStudentById(id);
		student.setId(id);
		student.setName("student_"+id);
		student.setEmail("student_"+id+"gmail.com");
		Date now = new Date();
		student.setDob(now);
		studentService.updateStudent(student);
		Student updatedStudent = studentService.findStudentById(id);
		Assert.assertNotNull(updatedStudent);
	}
}
