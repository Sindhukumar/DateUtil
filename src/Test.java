import java.text.ParseException;

public class Test {

	public static void main(String[] args) {

		DateUtil du = new DateUtil();
		
		try {
			System.out.println(du.displayCalendar(2, 1990));
			System.out.println("\n"+du.toString(2,25,1990,"/"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
