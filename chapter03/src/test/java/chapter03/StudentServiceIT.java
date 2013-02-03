package chapter03;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import chapter03.StudentService;
import chapter03.domain.Course;
import chapter03.domain.PhoneNumber;
import chapter03.domain.Student;
import chapter03.domain.Tutor;



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
			System.out.println(student);
		}
		
	}
	
	//@Test
    public void testFindStudentById() 
	{
		Student student = studentService.findStudentById(1);
		System.err.println(student);
		System.err.println(student.getAddress());
		
	}
	
	//@Test
    public void testFindStudentWithAddressById() 
	{
		Student student = studentService.findStudentWithAddressById(1);
		System.out.println(student);
		System.err.println(student.getAddress());
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
		System.err.println("Id:"+student.getId());
		
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
		stud.setName("stud_"+ts);
		stud.setEmail("stud_"+ts+"@gmail.com");
		Student student = studentService.updateStudent(stud);
		System.err.println("Id:"+student.getId());
		
	}
	
	//@Test
	public void testDeleteStudent() {
		boolean deleteStudent = studentService.deleteStudent(11);
		System.err.println("deleteStudent:"+deleteStudent);
	}
	
	//@Test
	public void testFindTutorById() {
		Tutor tutor = studentService.findTutorById(1);
		System.err.println(tutor);
	}
	
	//@Test
	public void searchCourses() 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		//map.put("courseName", "%java%");
		map.put("startDate", new Date());
		List<Course> courses = studentService.searchCourses(map);
		for (Course course : courses) {
			System.out.println(course);
		}
	}
	
	@Test
	public void searchCoursesByTutors() 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> tutorIds = new ArrayList<Integer>();
		tutorIds.add(1);
		tutorIds.add(2);
		map.put("tutorIds", tutorIds);
		//map.put("courseName", "%java%");
		//map.put("startDate", new Date());
		List<Course> courses = studentService.searchCoursesByTutors(map);
		for (Course course : courses) {
			System.out.println(course);
		}
	}
}
