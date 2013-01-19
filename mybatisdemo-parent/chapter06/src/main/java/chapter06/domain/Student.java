package chapter06.domain;

import java.io.Serializable;


/**
 * @author Siva
 *
 */
public class Student implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String email;
	
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
	
	
}
