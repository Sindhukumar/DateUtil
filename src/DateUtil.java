import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	String mName;
	int lastdate;
	
	
	public String displayCalendar(int month, int year) throws ParseException{
		
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date MyDate = newDateFormat.parse(01+"/"+month+"/"+year);
		Calendar c = Calendar.getInstance();
		c.setTime(MyDate);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		lastdate = getLastDayOfMonth(month, year);
		
		StringBuilder calendar = new StringBuilder();
		calendar.append("               "+mName+"  "+year);
		calendar.append("\nSun 	Mon 	Tue 	Wed 	Thu 	Fri 	Sat\n");
		for(int i=1;i<dayOfWeek;i++)
			calendar.append("     	");
		for(int i=1;i<=lastdate;i++){
			calendar.append(i+" 	");
			if(dayOfWeek%7==0)
				calendar.append("\n");
			dayOfWeek++;
		}
		return calendar.toString();
	}

	public int getLastDayOfMonth(int month, int year) {
		switch(month){
		case 1:mName="January";return 31;
		case 3:mName="March";return 31;
		case 5:mName="May";return 31;
		case 7:mName="July";return 31;
		case 8:mName="August";return 31;
		case 10:mName="October";return 31;
		case 12:mName="December";return 31;
		case 2:mName="Feburary";
			if(isLeapYear(year))
				return 29;
			else
				return 28;
		case 4:mName="April";return 30;
		case 6:mName="June";return 30;
		case 9:mName="September";return 30;
		case 11:mName="November";return 30;
		}
		return -1;
	}

	public String toString(int month, int day, int year, String delimiter) {
		
		return(String.format("%02d", month) +delimiter+String.format("%02d", day)+delimiter+year);
	} // prints the date as mm/dd/yyyy

	public boolean isLeapYear(int year) {
		if(year%4!=0 || (year%100==0&&year%400!=0))
			return false;
		return true;
	}
}
