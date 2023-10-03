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
		Event event = events.search(value);
		if (contact == null) {
			System.out.println("No contacts found.");
			return;
		}

		if (contacts.remove(contact)) {
			if(events.remove(event))
			System.out.println("Contact removed successfully!");
			
		} else {
			System.out.println("Failed to remove contact.");
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

	    System.out.println("Enter search criteria:");
	    System.out.println("1. Name");
	    System.out.println("2. Phone Number");
	    System.out.println("3. Email Address");
	    System.out.println("4. Address");
	    System.out.println("5. Birthday");

	    System.out.print("Enter your choice: ");
	    int choice = scanner.nextInt();

	    scanner.nextLine(); // Consume the newline character

	    String searchValue;
	    switch (choice) {
	        case 1:
	            System.out.print("Enter the contact's name: ");
	            searchValue = scanner.nextLine();
	            printSearchContacts(contacts.searchContactsByCriteria("name", searchValue));
	            break;
	        case 2:
	            System.out.print("Enter the contact's phone number: ");
	            searchValue = scanner.nextLine();
	            printSearchContacts(contacts.searchContactsByCriteria("phone", searchValue));
	            break;
	        case 3:
	            System.out.print("Enter the contact's email address: ");
	            searchValue = scanner.nextLine();
	            printSearchContacts(contacts.searchContactsByCriteria("email", searchValue));
	            break;
	        case 4:
	            System.out.print("Enter the contact's address: ");
	            searchValue = scanner.nextLine();
	            printSearchContacts(contacts.searchContactsByCriteria("address", searchValue));
	            break;
	        case 5:
	            System.out.print("Enter the contact's birthday: ");
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
			System.out.println("No contacts found.");
			return;
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

	public void scheduleEvent(String title, String date, String time, String location, String contactName) {
		Contact eventUser = contacts.search(contactName);
		events.scheduleEvent(title, date, time, location, eventUser);
	}

	public void printAllEvents() {
		events.printAllEvents();;
	}
	
	public void printEventDetail(String value) {
		events.printEventDetails(value);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}