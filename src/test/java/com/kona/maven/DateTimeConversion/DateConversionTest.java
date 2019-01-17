package com.kona.maven.DateTimeConversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

public class DateConversionTest extends TestCase {
/*
	public void testUtcToGmt() {
		fail("Not yet implemented");
	}

	public void testGmtToUtc() {
		fail("Not yet implemented");
	}*/

	public void testDateToLocalDate() {
		LocalDate firstDay_2019 = LocalDate.of(2019,01, 01);
		
		Date sDate = new Date(2019-1900, 01-1, 01);
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		assertEquals(firstDay_2019, DateConversion.dateToLocalDate(sDate));		
	}

	public void testLocalDateToDate() {
		
//		   Calendar c1 = GregorianCalendar.getInstance();
//         c1.set(2019, Calendar.JANUARY, 2);
//         Date sDate = c1.getTime();
		
		
		Date sDate = new Date(2019-1900, 01, 02);
		
         
         DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        // String strDate = dateFormat.format(sDate);  

         assertEquals(dateFormat.format(sDate), dateFormat.format(DateConversion.localDateToDate(LocalDate.of(2019, Month.JANUARY, 2))));
	}

	public void testDateToZonedDate() {
		
		 DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		 DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
		 Date sDate = new Date(2016-1900, 01-1, 04);
		 ZonedDateTime marketOpens = ZonedDateTime.of ( LocalDate.of ( 2016 , 1 , 4 ) , LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );
		 
		 assertEquals(format.format(marketOpens),format.format(DateConversion.dateToZonedDate(sDate)) );
		 
		 
	}
/*
	public void testZonedDateToDate() {
		fail("Not yet implemented");
	}

	public void testZonedDateToCalender() {
		fail("Not yet implemented");
	}

	public void testCalenderToZonedDate() {
		fail("Not yet implemented");
	}*/

}
