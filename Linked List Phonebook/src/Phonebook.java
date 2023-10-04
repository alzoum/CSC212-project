import java.util.Scanner;

public class Phonebook {
	private LinkedList<Contact> contacts;
	private LinkedList<Event> events;

	public Phonebook() {
		contacts = new LinkedList<>();
		events = new LinkedList<>();
	}

	public void deleteContact(String value) {

		Contact contact = contacts.search(value);

		if (contact == null) {
			System.out.println("\nNo contacts found.\n");
			return;
		}

		if (contacts.remove(contact)) {
			Event event = events.search(value);
			while (event != null) {
				events.remove(event);
				event = events.search(value);
			}
			System.out.println("\nContact removed successfully!\n");

		} else {
			System.out.println("Failed to remove contact.\n");
		}

	}

	public void addContact(Contact c) {

		if (contacts.isEmpty()) {
			contacts.insert(c);
			System.out.println("Contact added successfully!");
			return;
		}

		Node<Contact> current = contacts.getHead();
		while (current != null) {
			if (c.getName().equalsIgnoreCase(current.getData().getName())
					|| c.getPhoneNumber().equalsIgnoreCase(current.getData().getPhoneNumber())) {
				System.out.println("Contact already added!");
				return;
			}
			current = current.getNext();
		}
		contacts.insert(c);
		System.out.println("Contact added successfully!");
	}

	public void searchContacts() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\nEnter search criteria:");
		System.out.println("1.Name");
		System.out.println("2.Phone Number");
		System.out.println("3.Email Address");
		System.out.println("4.Address");
		System.out.println("5.Birthday");

		System.out.print("\nEnter your choice:");
		int choice = scanner.nextInt();

		scanner.nextLine(); // Consume the newline character

		String searchValue;
		switch (choice) {
		case 1:
			System.out.print("\nEnter the contact's name:");
			searchValue = scanner.nextLine();
			printSearchContacts(contacts.searchContactsByCriteria("name", searchValue));
			break;
		case 2:
			System.out.print("Enter the contact's phone number:");
			searchValue = scanner.nextLine();
			printSearchContacts(contacts.searchContactsByCriteria("phone", searchValue));
			break;
		case 3:
			System.out.print("Enter the contact's email address:");
			searchValue = scanner.nextLine();
			printSearchContacts(contacts.searchContactsByCriteria("email", searchValue));
			break;
		case 4:
			System.out.print("Enter the contact's address:");
			searchValue = scanner.nextLine();
			printSearchContacts(contacts.searchContactsByCriteria("address", searchValue));
			break;
		case 5:
			System.out.print("Enter the contact's birthday:");
			searchValue = scanner.nextLine();
			printSearchContacts(contacts.searchContactsByCriteria("birthday", searchValue));
			break;
		default:
			System.out.println("Invalid choice.");
			break;
		}
	}

	private void printSearchContacts(LinkedList<Contact> searchResults) {
		Node<Contact> current = searchResults.getHead();

		if (current == null) {
			System.out.println("\nNo contacts found.\n");
			return;
		}

		if (current.getNext() == null) {
			System.out.println("Contact found!");
		} else {
			System.out.println("Contacts found!");
		}
		while (current != null) {
			Contact contact = current.getData();
			System.out.println("-----------------------");
			System.out.println("Name: " + contact.getName());
			System.out.println("Phone Number: " + contact.getPhoneNumber());
			System.out.println("Email Address: " + contact.getEmailAddress());
			System.out.println("Address: " + contact.getAddress());
			System.out.println("Birthday: " + contact.getBirthday());
			System.out.println("Notes: " + contact.getNotes());
			System.out.println("-----------------------");
			current = current.getNext();
		}

	}

	public void printContactsByFirstName(String firstName) {
		Node<Contact> current = contacts.getHead();
		LinkedList<Contact> list = new LinkedList<>();

		while (current != null) {
			if (firstName.equalsIgnoreCase(current.getData().getFirstName())) {
				list.insert(current.getData());
			}
			current = current.getNext();
		}
		printSearchContacts(list);
	}

	public void scheduleEvent() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nEnter event title:");

		String title = scanner.nextLine();

		System.out.print("Enter contact name:");
		String contactName = scanner.nextLine();

		System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
		String x = scanner.nextLine();
		String[] dateParts = x.split(" ");
		String date = dateParts[0];
		String time = dateParts[1];

		System.out.print("Enter event location:");
		String location = scanner.nextLine();

		Contact eventUser = contacts.search(contactName);
		events.scheduleEvent(title, date, time, location, eventUser);
	}

	public void printAllEvents() {
		events.printAllEvents();
		;
	}

	public void printEventDetail() {
		Scanner scanner = new Scanner(System.in);
		String value;
		System.out.println("\nEnter search criteria:");
		System.out.println("1.Contact name");
		System.out.println("2.Event title");

		System.out.print("\nEnter your choice:");
		int choice = scanner.nextInt();

		scanner.nextLine(); // Consume the newline character

		switch (choice) {
		case 1:
			System.out.print("\nEnter the contact name:");

			value = scanner.nextLine();
			events.printEventDetails(value);
			break;
		case 2:
			System.out.print("\nEnter the event title:");

			value = scanner.nextLine();
			events.printEventDetails(value);
			break;
		default:
			System.out.println("\nInvalid choice.\n");

		}

	}

	public static void main(String[] args) {
		Phonebook phonebook = new Phonebook();
		Scanner scanner = new Scanner(System.in);
		int input;
		String name, phonenumber, email, address, birthday, note;
		System.out.println("Welcome to the Linked Tree Phonebook!");
		do {
			System.out.println("Please choose an option:");
			System.out.println("1.Add a contact");
			System.out.println("2.Search for a contact");
			System.out.println("3.Delete a contact");
			System.out.println("4.Schedule an event");
			System.out.println("5.Print event details");
			System.out.println("6.Print contact by first name");
			System.out.println("7.Pring all events alphabetically");
			System.out.println("8.Exit \n");

			System.out.print("Enter your choice:");
			input = scanner.nextInt();
			switch (input) {
			case 1:
				System.out.print("\nEnter the contact's name:");
				scanner.nextLine(); // Consume newline character
				name = scanner.nextLine();
				System.out.print("Enter the contact's phone number:");
				phonenumber = scanner.nextLine();
				System.out.print("Enter the contact's email address:");
				email = scanner.nextLine();
				System.out.print("Enter the contact's address:");
				address = scanner.nextLine();
				System.out.print("Enter the contact's birthday:");
				birthday = scanner.nextLine();
				System.out.print("Enter any notes for the contact:");
				note = scanner.nextLine();
				Contact C = new Contact(name, phonenumber, email, address, birthday, note);
				System.out.println();
				phonebook.addContact(C);
				System.out.println();
				break;
			case 2:
				phonebook.searchContacts();
				break;
			case 3:
				System.out.print("\nEnter contact's Name or Phonenumber:");
				scanner.nextLine();
				String value = scanner.nextLine();
				phonebook.deleteContact(value);
				break;
			case 4:
				phonebook.scheduleEvent();
				break;
			case 5:
				phonebook.printEventDetail();
				break;
			case 6:
				System.out.print("\nEnter the first name:");
				scanner.nextLine();
				name = scanner.nextLine();
				phonebook.printContactsByFirstName(name);
				break;
			case 7:
				phonebook.printAllEvents();
				break;
			case 8:
				System.out.println("\nGoodbye!");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("\n Invalid choice");
			}
		} while (true);

	}

}
