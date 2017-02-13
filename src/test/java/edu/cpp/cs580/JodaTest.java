package edu.cpp.cs580;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

public class JodaTest {
	
	@Test
	public void jodaTest(){
		DateTimeZone localTimeZone = DateTimeZone.forID("Europe/Kiev");	
		DateTime utcTime = new DateTime(2012, 11, 29, 11, 40,DateTimeZone.UTC);
		DateTime localTime = utcTime.withZone(localTimeZone);
		String test = localTime.toString();
		Assert.assertEquals("2012-11-29T13:40:00.000+02:00", test);
	}


}
