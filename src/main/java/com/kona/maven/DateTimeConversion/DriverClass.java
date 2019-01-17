package com.kona.maven.DateTimeConversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author kona
 */
public class DriverClass {
    
    public static void main(String[] args) {
       // Date oldDate = new Date();
   //LocalDateTime newDateTime = new LocalDateTime();
  //LocalDateTime.from(Instant.ofEpochMilli(oldDate.getTime()));

   Date fromDate = Calendar.getInstance().getTime();
	    System.out.println("UTC Time - "+fromDate);
	    System.out.println("GMT Time - "+DateConversion.utcToGmt(fromDate));
            
            System.out.println("UTC "+ DateConversion.gmtToUtc(DateConversion.utcToGmt(fromDate)));
            
   LocalDate today = LocalDate.now();
   LocalDate firstDay_2019 = LocalDate.of(2019, Month.JANUARY, 1);
   
            System.out.println("localdate:" + firstDay_2019 );  
            System.out.println("localdate to date:" + DateConversion.localDateToDate(firstDay_2019));
            
             
            
   Calendar c1 = GregorianCalendar.getInstance();
   c1.set(2019, Calendar.JANUARY, 1);
   Date sDate = c1.getTime();
            System.out.println("date:" + sDate );  
            System.out.println("date to localdate:" + DateConversion.dateToLocalDate(sDate));
            System.out.println("Zoned Date : " + DateConversion.dateToZonedDate(sDate) );
            System.out.println("Date from Zoned Date: " + DateConversion.zonedDateToDate(DateConversion.dateToZonedDate(sDate)));
            
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
   		    DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
   		    Date sDate1 = new Date(2016-1900, 01-1, 04);
   		    ZonedDateTime marketOpens = ZonedDateTime.of ( LocalDate.of ( 2016 , 1 , 4 ) , LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );
   		 
   		    LocalTime specificTime = LocalTime.of(12,20,25,40);
   		    
   		    System.out.println( format.format(marketOpens) +"   "+format.format(DateConversion.dateToZonedDate(sDate1)) );
   		    System.out.println("localTimeToDate: "+DateConversion.localTimeToDate(specificTime)+"local time :"+specificTime);
    }
    
}
