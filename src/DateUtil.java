import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateUtil {
	String mName;
	int lastdate;

	public String displayCalendar(int month, int year) throws ParseException {

		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date MyDate = newDateFormat.parse(01 + "/" + month + "/" + year);
		Calendar c = Calendar.getInstance();
		c.setTime(MyDate);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		lastdate = getLastDayOfMonth(month, year);

		StringBuilder calendar = new StringBuilder();
		calendar.append("               " + mName + "  " + year);
		calendar.append("\nSun 	Mon 	Tue 	Wed 	Thu 	Fri 	Sat\n");
		for (int i = 1; i < dayOfWeek; i++)
			calendar.append("     	");
		for (int i = 1; i <= lastdate; i++) {
			calendar.append(i + " 	");
			if (dayOfWeek % 7 == 0)
				calendar.append("\n");
			dayOfWeek++;
		}
		return calendar.toString();
	}

	public int getLastDayOfMonth(int month, int year) {
		switch (month) {
		case 1:
			mName = "January";
			return 31;
		case 3:
			mName = "March";
			return 31;
		case 5:
			mName = "May";
			return 31;
		case 7:
			mName = "July";
			return 31;
		case 8:
			mName = "August";
			return 31;
		case 10:
			mName = "October";
			return 31;
		case 12:
			mName = "December";
			return 31;
		case 2:
			mName = "Feburary";
			if (isLeapYear(year))
				return 29;
			else
				return 28;
		case 4:
			mName = "April";
			return 30;
		case 6:
			mName = "June";
			return 30;
		case 9:
			mName = "September";
			return 30;
		case 11:
			mName = "November";
			return 30;
		}
		return -1;
	}

	public int diffDate(int month1, int day1, int year1, int month2, int day2, int year2) throws ParseException {
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date olderDate = newDateFormat.parse(day1 + "/" + month1 + "/" + year1);
		Date newerDate = newDateFormat.parse(day2 + "/" + month2 + "/" + year2);

		return (int) ((newerDate.getTime() - olderDate.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	public int diffDate(String date1, String date2) throws ParseException {
		Scanner sc = new Scanner(date1).useDelimiter("/");
		int day1 = sc.nextInt();
		int month1 = sc.nextInt();
		int year1 = sc.nextInt();
		Scanner s = new Scanner(date2).useDelimiter("/");
		int day2 = sc.nextInt();
		int month2 = sc.nextInt();
		int year2 = sc.nextInt();
		
		
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date olderDate = newDateFormat.parse(day1 + "/" + month1 + "/" + year1);
		Date newerDate = newDateFormat.parse(day2 + "/" + month2 + "/" + year2);

		return (int) ((newerDate.getTime() - olderDate.getTime()) / (1000 * 60 * 60 * 24));
	}

	public int diffDate(int month, int day, int year) throws ParseException {
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date olderDate = newDateFormat.parse(day + "/" + month + "/" + year);
		Date newerDate = newDateFormat.parse(newDateFormat.format(Calendar.getInstance().getTime()));

		return (int) ((newerDate.getTime() - olderDate.getTime()) / (1000 * 60 * 60 * 24));
	}

	public int dayOfWeek(int month, int day, int year) throws ParseException {
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date MyDate = newDateFormat.parse(day + "/" + month + "/" + year);
		Calendar c = Calendar.getInstance();
		c.setTime(MyDate);
		return c.get(Calendar.DAY_OF_WEEK);
	}

	public int dayOfWeek(String date) throws ParseException {
		Scanner sc = new Scanner(date).useDelimiter("/");
		int day = sc.nextInt();
		int month = sc.nextInt();
		int year = sc.nextInt();
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date MyDate = newDateFormat.parse(day + "/" + month + "/" + year);
		Calendar c = Calendar.getInstance();
		c.setTime(MyDate);
		sc.close();
		return c.get(Calendar.DAY_OF_WEEK);
	}

	public boolean isLeapYear(int year) {
		if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))
			return false;
		return true;
	}

	public Date now() {
		Date date = Calendar.getInstance().getTime();
		return date;
	}

	public String now(String format) {
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public String toString(int month, int day, int year, String delimiter) {

		return (String.format("%02d", month) + delimiter + String.format("%02d", day) + delimiter + year);
	}
}
