package chapter05.domain;

/**
 * @author Siva
 *
 */
public class Address
{
	private Integer id;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	public Address()
	{
	}
	public Address(Integer id)
	{
		this.id = id;
	}
	public Address(Integer id, String street, String city, String state,
			String zip, String country)
	{
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getStreet()
	{
		return street;
	}
	public void setStreet(String street)
	{
		this.street = street;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getZip()
	{
		return zip;
	}
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	
}
