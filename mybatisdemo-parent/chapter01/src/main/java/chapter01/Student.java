package chapter01;

import java.util.Date;


/**
 * @author Siva
 *
 */
public class Student
{
	private Integer id;
	private String name;
	private String email;
	private Date dob;
	
	
	@Override
	public String toString()
	{
		return "Student [id=" + id + ", name=" + name + ", email=" + email
				+ ", dob=" + dob + "]";
	}
	public Student()
	{
	}
	public Student(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public Date getDob()
	{
		return dob;
	}
	public void setDob(Date dob)
	{
		this.dob = dob;
	}
	
	
}
