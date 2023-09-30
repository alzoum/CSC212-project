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
		
		
		String title;
		String name;
		String date;
		String time;
		String location;
		System.out.println("Enter event title: ");
		title = scanner.nextLine();
		System.out.println("Enter contact name: ");
		name = scanner.nextLine();
		System.out.println("Enter event date and time (MM/DD/YYYY HH:MM): ");
		String dateTime = scanner.nextLine();
		String[] dateTimeParts = dateTime.split(" ");
		date = dateTimeParts[0];
		time = dateTimeParts[1];
		System.out.println("Enter event location: ");
		location = scanner.nextLine();
		book.scheduleEvent(title, date, time,location, name);
		
	}

}
