import java.util.Scanner;
public class Phonebook<T> {
	 private LinkedList contacts;

	    public Phonebook() {
	        contacts = new LinkedList();
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
                searchValue = scanner.next();
                LinkedList <T> nameSearchResults = contacts.searchContactsByCriteria("name", searchValue);
                printContacts(nameSearchResults);
                break;
            case 2:
            	System.out.print("Enter the contact");
            	searchValue = scanner.next();
            	LinkedList<T> phoneSearchResults = contacts.searchContactsByCriteria("phone", searchValue);
            	printContacts(phoneSearchResults);
                // Implement search by phone number
                break;
            case 3:
                // Implement search by email address
                break;
            case 4:
                // Implement search by address
                break;
            case 5:
                // Implement search by birthday
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
	
	public void printContacts(LinkedList<T> searchResults) {
	    Node current = searchResults.getHead();

	    if (current == null) {
	        System.out.println("No contacts found.");
	        return;
	    }

	    while (current != null) {
	        Contact contact = current.getContact();
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
    // Rest of the Phonebook class code...
}
