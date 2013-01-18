package domain;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class SampleTest 
{
	private static String name;
	
	@BeforeClass
	public static void setup()
	{
		name = "Siva";
	}
	@AfterClass
	public static void teardown()
	{
		name = null;
	}
	
	@Test
    public void horribleTest() 
	{
		Assert.assertNotNull(name);
	}
		

}
