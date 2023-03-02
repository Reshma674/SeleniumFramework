package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert 
{
	@Test
	/*public void creatContact()
	{
		System.out.println("step1");
		System.out.println("step2");
		//HardAssert
		Assert.assertEquals("R", "R");
		System.out.println("step3");
		System.out.println("step4");
		System.out.println("step5");
	}
	public void modifyCreate()
	{
		System.out.println("step6");
		System.out.println("step7");
		System.out.println("step8");
	}*/
	public void name()
	{
		String expName="Reshma";
		String actName="Reshma";
		Assert.assertEquals(expName, actName);
	}

}
