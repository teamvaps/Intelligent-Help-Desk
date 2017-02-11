package edu.cpp.cs580;

import org.junit.Assert;
import org.junit.Test;

import edu.cpp.cs580.data.Company;
import edu.cpp.cs580.data.Computer;

public class FormObjectServiceTest {
	@Test
	public void ShouldCreateFormandReturnName(){
		String name = "ralv" ;
				Company comname = new Computer(name);
				Assert.assertTrue(comname.getname().equals(name));
	}

}
