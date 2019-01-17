package com.kona.maven.DateTimeConversion;



import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
/**
 *
 * @author kona
 */
public class DateConversion {

        
    //01_______________Date to LocalDate_________//    
        public static LocalDate dateToLocalDate(Date dateToConvert) {
           return dateToConvert.toInstant()
           .atZone(ZoneId.systemDefault())
           .toLocalDate();
        }
        
    //02_______________LocalDate to Date_________//
        public static Date localDateToDate(LocalDate dateToConvert) {
         return java.util.Date.from(dateToConvert.atStartOfDay()
         .atZone(ZoneId.systemDefault())
         .toInstant());
        }
        
    //03______________Date to ZonedDate_________//
        
        public static ZonedDateTime dateToZonedDate(Date dateToConvert){

          ZonedDateTime d1 = ZonedDateTime.ofInstant(dateToConvert.toInstant(),
                                          ZoneId.systemDefault());
                return d1;
        }
        
       
    //04______________ZonedDate to Date_________//
        
        public static Date zonedDateToDate(ZonedDateTime dateToConvert){
        
        Date date = Date.from(dateToConvert.toInstant());
        return date;
        }
        
    //05_______________ZonedDate to Calender______//
        
        
        public static Calendar zonedDateToCalender(ZonedDateTime dateToConvert){
        
        ZonedDateTime zdt = ZonedDateTime.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault());
        Calendar cal1 = GregorianCalendar.from(zdt);
        return cal1;
        }
        

    //06________________Calender to ZonedDateTime_______//
        
        public static ZonedDateTime calenderToZonedTime(Calendar cal) {

            String zone = cal.getTimeZone().getID();

            ZoneId zoneId = ZoneId.of(zone);

            ZonedDateTime zonedDateTime = ZonedDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND), zoneId);

            return zonedDateTime;
        }
        
     
     //07_______________LocalTime To Date______//
        public static Date localTimeToDate(LocalTime localTime) {
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
 
            calendar.set(0, 0, 0, localTime.getHour(), localTime.getMinute(), localTime.getSecond());
            return calendar.getTime();
        }
        
      //08_______________Date To LocalTime______//   
        public static LocalTime DateTolocalTime(Date dateToConverted) {
         return LocalDateTime.ofInstant(dateToConverted.toInstant(), ZoneId.systemDefault()).toLocalTime();
        }
        
      //09_______________Calender To ZonedOffset______//
        
        public static ZoneOffset timeToZonedOffset(Calendar cal) {


            String zone = cal.getTimeZone().getID();

            ZoneId zoneId = ZoneId.of(zone);
            
            ZoneOffset zonedOffset = ZoneOffset.ofHoursMinutesSeconds(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));

            return zonedOffset;
        }
        

        
        
       //10____________Calender To OffsetDateTime________________//
        
        public static OffsetDateTime calenderToOffsetDateTime(Calendar cal) {


            String zone = cal.getTimeZone().getID();

            ZoneId zoneId = ZoneId.of(zone);
            
            ZonedDateTime zonedDateTime = ZonedDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND), zoneId);
            
            ZoneOffset offset = zonedDateTime.getOffset();
             
            OffsetDateTime offsetDateTime= OffsetDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND), offset);

            return offsetDateTime;
               
        }
        
        //11________Date to Instance_________________//
        public static  Instant dateToInstant( Date date ){
        	
        	return date.toInstant();
        }
        
        //12________Instance to Date_________________//
        public static  Date instantToDate(Instant  inst ){
        	
            return	Date.from(inst);
        }
        
        //13_________GregorianCalendar to ZonedDateTime___//
        
       public static  ZonedDateTime  gregorianCalendarToZonedDateTime(GregorianCalendar cal){
        	
      
            return cal.toZonedDateTime();
           

        }
       
       
     //14_________ZonedDateTime To GregorianCalendar___//
       public static  GregorianCalendar  zonedDateTimeTogregorianCalendar(ZonedDateTime zdt){
       	
    	      
           return GregorianCalendar.from(zdt);
          

       }
       
       
        
        
        //11________________UTC to GMT_______________//
    	public static  Date utcToGmt( Date date ){
	    TimeZone tz = TimeZone.getDefault();
	    Date ret = new Date( date.getTime() - tz.getRawOffset() );
	    if ( tz.inDaylightTime( ret )){
	        Date dstDate = new Date( ret.getTime() - tz.getDSTSavings() );
	        if ( tz.inDaylightTime( dstDate )){
	            ret = dstDate;
	        }
	     }
	     return ret;
	}   
        
    //12________________GMT to UTC_______________//    
        public static  Date gmtToUtc( Date date ){
	    TimeZone tz = TimeZone.getDefault();
	    Date ret = new Date( date.getTime() + tz.getRawOffset() );
	    if ( tz.inDaylightTime( ret )){
	        Date dstDate = new Date( ret.getTime() + tz.getDSTSavings() );
	        if ( tz.inDaylightTime( dstDate )){
	            ret = dstDate;
	        }
	     }
	     return ret;
	}
        
        
        
        
        
}

