
public class LinkedList<T> {

	private Node head;

	public LinkedList() {
		head = null;
	}

	public Node getHead() {
		return head;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void insertContact(Contact contact) {
		Node<Contact> newNode = new Node<>(contact);
		if (head == null) {
			head = newNode;
		} else {
			Node<Contact> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}

	public boolean removeContact(Contact contact) {
		if (isEmpty()) {
			return false;
		} else if (head.getData().equals(contact)) {
			head = head.getNext();
			return true;
		} else {
			Node current = head;
			while (current.getNext() != null) {
				if (current.getNext().getData().equals(contact)) {
					current.setNext(current.getNext().getNext());
					return true;
				}
				current = current.getNext();
			}
		}
		return false;
	}

	public LinkedList<Contact> searchContactsByCriteria(String searchCriteria, String searchValue) {
		LinkedList<Contact> searchResults = new LinkedList<>();

		Node<Contact> current = head;

		while (current != null) {
			Contact contact = (Contact) current.getData();

			if (searchCriteria.equalsIgnoreCase("name") && contact.getName().equalsIgnoreCase(searchValue)) {
				searchResults.insertContact(contact);
			}
			if (searchCriteria.equalsIgnoreCase("phone") && contact.getPhoneNumber().equals(searchValue)) {
				searchResults.insertContact(contact);
			}
			if (searchCriteria.equalsIgnoreCase("email") && contact.getEmailAddress().equalsIgnoreCase(searchValue)) {
				searchResults.insertContact(contact);
			}
			if (searchCriteria.equalsIgnoreCase("address") && contact.getAddress().equalsIgnoreCase(searchValue)) {
				searchResults.insertContact(contact);
			}
			if (searchCriteria.equalsIgnoreCase("birthday") && contact.getBirthday().equals(searchValue)) {
				searchResults.insertContact(contact);
			}

			current = current.getNext();
		}

		return searchResults;
	}

	public Contact search(String value) {
		Node current = getHead();
		while (current != null) {
			if (((Contact) current.getData()).getName().equalsIgnoreCase(value)
					|| ((Contact) current.getData()).getPhoneNumber().equalsIgnoreCase(value)) {
				return (Contact) current.getData();
			}
			current = current.getNext();
		}
		return null;
	}

	public void printEventDetails(String value) {
		Node current = getHead();
		boolean title = ((Event) current.getData()).getTitle().equalsIgnoreCase(value);
		boolean name = ((Event) current.getData()).getEventUser().getName().equalsIgnoreCase(value);

		while (current != null) {

			if (title || name) {
				((Event) current.getData()).toString();
			}

			current = current.getNext();
		}
	}

	public void insertEvent(Event e) {
	    Node newNode = new Node(e);
	    
	    if (head == null || e.getTitle().compareToIgnoreCase(((Event)head.getData()).getTitle()) < 0) {
	        newNode.setNext(head);
	        head = newNode;
	    } else {
	        Node current = head;
	        while (current.getNext() != null && e.getTitle().compareToIgnoreCase(((Event)current.getNext().getData()).getTitle()) >= 0) {
	            current = current.getNext();
	        }
	        newNode.setNext(current.getNext());
	        current.setNext(newNode);
	    }
	}

	public void scheduleEvent(String title, String date, String time, String location, String contactName) {
		Contact eventUser = search(contactName);
		if (eventUser != null) {

			boolean hasConflict = false;
			Event newEvent = new Event(title, date, time, location, eventUser);

			Node current = head;
			while (current != null) {
				if (current.getData() instanceof Event) {
				Event existingEvent = (Event) current.getData();
				if (existingEvent.getEventUser().equals(eventUser) && existingEvent.getDate().equals(newEvent.getDate())
						&& existingEvent.getTime().equals(newEvent.getTime())) {

					hasConflict = true;
					break;
				}
				}
				current = current.getNext();

			}

			if (!hasConflict) {
				eventUser.addEvent(newEvent);
			} else {
				System.out.println("Event scheduling conflict. Cannot schedule the event.");
			}

		} else {
			System.out.println("Contact does not exist in the phonebook.");
		}
	}
	
	
	public void printAllEvents() {
	    Node current = head;
	    
	    while (current != null) {
	        if (current.getData() instanceof Event) {
	            Event event = (Event) current.getData();
	            System.out.println(event.toString());
	        }
	        current = current.getNext();
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}