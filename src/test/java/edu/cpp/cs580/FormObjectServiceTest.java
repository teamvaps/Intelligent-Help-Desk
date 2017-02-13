package edu.cpp.cs580;

import org.junit.Assert;
import org.junit.Test;

import edu.cpp.cs580.data.Company;
import edu.cpp.cs580.data.Computer;
import edu.cpp.cs580.data.User;

public class FormObjectServiceTest {
	@Test
	public void ShouldCreateFormandReturnName(){
		String name = "ralv" ;
				Company comname = new Computer(name);
				Assert.assertTrue(comname.getname().equals(name));
	}

	
	@Test
	public void testUserID(){
		User user1 = new User();
		user1.setId("011939291_SS");
		Assert.assertEquals("011939291_SS", user1.getId());
	}
	
	@Test
	public void testUserMajor(){
		User user1 = new User();
		user1.setMajor("Computer Science");
		Assert.assertEquals("Computer Science", user1.getMajor());
	}
	@Test
	public void testUserName(){
		User user1 = new User();
		user1.setName("Abraham Lincoln");
		Assert.assertEquals("Abraham Lincoln", user1.getName());
	}
	
	

}
