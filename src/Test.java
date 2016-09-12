import java.text.ParseException;

public class Test {

	public static void main(String[] args) {

		DateUtil du = new DateUtil();
		
		try {
			System.out.println(du.displayCalendar(2, 1990));
			System.out.println("\n"+du.toString(2,25,1990,"/"));
			
			
			
			System.out.println("Difference in week: "+du.diffDate(2, 25, 1990, 2, 25,2090));
			
			System.out.println("Day of week: "+ du.dayOfWeek(2, 25, 1990));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
