package chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chapter01.domain.Student;

/**
 * @author Siva
 *
 */
public class JdbcStudentService
{
	public static void main(String[] args)
	{
		JdbcStudentService service = new JdbcStudentService();
		Student student = service.findStudentById(1);
		System.out.println(student);
		//student.setId(2);
		//service.createStudent(student);
		student.setId(2);
		student.setEmail("student2@gmail.com");
		service.updateStudent(student);
	}
	
	public Student findStudentById(int studId)
	{
		Student student = null;
		Connection conn = null;
		try
		{
			conn = getDatabaseConnection();
			String sql = "select * from students where stud_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				student = new Student();
				student.setId(rs.getInt("stud_id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setDob(rs.getDate("dob"));
			}
			
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if(conn!= null){
				try {
					conn.close();
				} catch (SQLException e){ }
			}
		}
		return student;
	}
	
	public void createStudent(Student student)
	{
		Connection conn = null;
		try
		{
			conn = getDatabaseConnection();
			String sql = "INSERT INTO STUDENTS(STUD_ID,NAME,EMAIL,DOB) VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getEmail());
			pstmt.setDate(4, new java.sql.Date(student.getDob().getTime()));
			pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if(conn!= null){
				try {
					conn.close();
				} catch (SQLException e){ }
			}
		}
	}
	
	public void updateStudent(Student student)
	{
		Connection conn = null;
		try
		{
			conn = getDatabaseConnection();
			conn = getDatabaseConnection();
			String sql = "UPDATE STUDENTS SET NAME=?,EMAIL=?,DOB=? WHERE STUD_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getEmail());
			pstmt.setDate(3, new java.sql.Date(student.getDob().getTime()));
			pstmt.setInt(4, student.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			throw new RuntimeException(e.getCause());
		}
		finally
		{
			if(conn!= null){
				try {
					conn.close();
				} catch (SQLException e){ }
			}
		}
	}
	
	protected Connection getDatabaseConnection() throws SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatisdemo", 
							"root", "admin");
		} catch (SQLException e)
		{
			throw e;
		} catch (Exception e)
		{
			throw new RuntimeException(e.getCause());
		} 
	}

}
