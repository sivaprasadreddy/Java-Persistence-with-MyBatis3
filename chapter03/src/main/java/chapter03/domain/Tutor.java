package chapter03.domain;

import java.util.List;

/**
 * @author Siva
 *
 */
public class Tutor
{
	private Integer id;
	private String name;
	private String email;
	private Address address;
	private List<Course> courses;
	
	@Override
	public String toString() {
		return "Tutor [id=" + id + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", courses=" + courses + "]";
	}
	public Tutor()
	{
	}
	public Tutor(Integer id)
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
	public Address getAddress()
	{
		return address;
	}
	public void setAddress(Address address)
	{
		this.address = address;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
