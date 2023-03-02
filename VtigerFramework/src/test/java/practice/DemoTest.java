package practice;

import org.testng.annotations.Test;

public class DemoTest 
{
	//method-1
	@Test
	public void createContact()
	{
		System.out.println("created");
		int[] arr= {1,2,3};
		System.out.println(arr[5]);
	}
	//method-2
	@Test(invocationCount = 2 )
	public void modifyContact()
	{
		System.out.println("modified");
	}
	//method-3
	@Test(dependsOnMethods = "createContact")
	public void deletedContact()
	{
		System.out.println("deleted");
	}

}
