package chapter03.domain;


/**
 * @author Siva
 *
 */
public class Student
{
	private Integer id;
	private String name;
	private String email;
	private PhoneNumber phone;
	private Address address;
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email
				+ ", phone=" + (phone==null?null:phone.getAsString()) + ", address=" + address + "]";
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public PhoneNumber getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	
}
