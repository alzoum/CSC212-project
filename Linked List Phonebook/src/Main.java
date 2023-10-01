import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Contact c1 = new Contact("Fahad Alohali", "0502", "Fhd@gmail.com", "Alnafl", "10/1/2004", "Friend");
		Contact c2 = new Contact("Abdullah Alz", "0", "v@gmail.com", "ss", "10/1/2003", "zz");
		Contact c3 = new Contact("Abdullah Alg", "123", "v@gmail.com", "dd", "10/1/2002", "kkk");
		Contact c4 = new Contact("Fahad Als", "02", "z@gmail.com", "yy", "10/1/2001", "vv");
		Phonebook book = new Phonebook();
		book.addContact(c1);
		book.addContact(c2);
		book.addContact(c3);
		book.addContact(c4);
		
	
		String title="Launch with abdullah";
		String name="Fahad Alohali";
		String date="2/2/2";
		String time="12:30";
		String location="Riyadh";
		String title1="Astro with Fahad";
		String name1="Abdullah Alz";
		String date1="2/2/2";
		String time1="12:30";
		String location1="Riyadh";
		String title2="La with Fahad";
		String name2="Abdullah Alz";
		String date2="3/3/3";
		String time2="12:30";
		String location2="Riyadh";
		book.scheduleEvent(title, date, time,location, name);
		book.scheduleEvent(title1, date1, time1,location1, name1);
		book.scheduleEvent(title2, date2, time2,location2, name2);
		//book.printAllEvents();
		
		
		book.deleteContact(name);
		book.printAllEvents();
		//book.printEventDetail("Launch with abdullah");
		
	}

}
