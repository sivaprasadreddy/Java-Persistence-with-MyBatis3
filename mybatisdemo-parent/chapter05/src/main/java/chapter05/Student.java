package chapter05;


/**
 * @author Siva
 *
 */
public class Student
{
	private Integer id;
	private String name;
	private String email;
	private Address address;
	
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
	public Address getAddress()
	{
		if(address == null){
			address = new Address();
		}
		return address;
	}
	public void setAddress(Address address)
	{
		this.address = address;
	}

	
}
