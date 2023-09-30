import java.util.Scanner;

public class Phonebook {
	private LinkedList<Contact> contacts;

	public Phonebook() {
		contacts = new LinkedList<>();
	}

	public void deleteContact(String value) {
		Node current = contacts.getHead();
		if (!contacts.removeContact((Contact) current.getData())) {
			System.out.println("No contacts found ");
			return;
		} else {
			if (contacts.search(value) != null)
				if (contacts.removeContact((Contact) current.getData())) {
					System.out.println("Contact removed successfully!");
					return;
				}
		}
	}

	public void addContact(Contact c) {

		if (contacts.isEmpty()) {
			contacts.insertContact(c);
			System.out.println("Contact added successfully!");
			return;
		}

		Node current = contacts.getHead();
		while (current.getNext() != null) {
			if (c.getName().equalsIgnoreCase(((Contact) current.getData()).getName())
					|| c.getPhoneNumber().equalsIgnoreCase(((Contact) current.getData()).getPhoneNumber())) {
				System.out.println("Contact already added!");
				return;
			}
			current = current.getNext();
		}
		contacts.insertContact(c);
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

		String searchValue;
		switch (choice) {
		case 1:
			System.out.print("Enter the contact's name: ");
            searchValue = scanner.nextLine(); // Use nextLine() instead of next()
            LinkedList<Contact> nameSearchResults = contacts.searchContactsByCriteria("name", searchValue);
            printSearchContacts(nameSearchResults);
            break;
		case 2:
			System.out.print("Enter the contact's phoneNumber: ");
			searchValue = scanner.next();
			LinkedList<Contact> phoneSearchResults = contacts.searchContactsByCriteria("phone", searchValue);
			printSearchContacts(phoneSearchResults);
			break;
		case 3:
			System.out.print("Enter the contact's email: ");
			searchValue = scanner.next();
			LinkedList<Contact> emailSearchResults = contacts.searchContactsByCriteria("email", searchValue);
			printSearchContacts(emailSearchResults);
			break;
		case 4:
			System.out.print("Enter the contact's address: ");
			searchValue = scanner.next();
			LinkedList<Contact> addressSearchResults = contacts.searchContactsByCriteria("address", searchValue);
			printSearchContacts(addressSearchResults);
			break;
		case 5:
			System.out.print("Enter the contact's birthday: ");
			searchValue = scanner.next();
			LinkedList<Contact> birthdaySearchResults = contacts.searchContactsByCriteria("birthday", searchValue);
			printSearchContacts(birthdaySearchResults);
			break;
		default:
			System.out.println("Invalid choice. Please try again.");
			break;
		}
	}

	public void printSearchContacts(LinkedList searchResults) {
		Node current = searchResults.getHead();

		if (current == null) {
			System.out.println("No contacts found.");
			return;
		}

		while (current != null) {
			Contact contact = (Contact) current.getData();
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
		Node current = contacts.getHead();
		LinkedList list = new LinkedList();
		while (current != null) {
			if (firstName.equalsIgnoreCase(((Contact) current.getData()).getFirstName()))
				list.insertContact((Contact) current.getData());
			current = current.getNext();
		}
		printSearchContacts(list);
	}
	
	
	public void scheduleEvent(String title, String date, String time, String location, String contactName) {
		contacts.scheduleEvent(title, date, time, location, contactName);
	}
	
	
	
	
	
	
	
	
	
	

}