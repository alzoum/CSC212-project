
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

//	public void insertContact(Contact contact) {
//		Node<Contact> newNode = new Node<>(contact);
//		if (head == null) {
//			head = newNode;
//		} else {
//			Node<Contact> current = head;
//			while (current.getNext() != null) {
//				current = current.getNext();
//			}
//			current.setNext(newNode);
//		}
//	}
	
	public void insert(T e) {
		if (e instanceof Event) {
			Node<Event> newNode = new Node<>((Event) e);

			if (head == null || ((Event) e).getTitle().compareToIgnoreCase(((Event) head.getData()).getTitle()) < 0) {
				newNode.setNext(head);
				head = newNode;
			} else {
				Node<Event> current = head;
				while (current.getNext() != null && ((Event) e).getTitle()
						.compareToIgnoreCase(((Event) current.getNext().getData()).getTitle()) >= 0) {
					current = current.getNext();
				}
				newNode.setNext(current.getNext());
				current.setNext(newNode);
			}
		} else if (e instanceof Contact) {
			Node<Contact> newNode = new Node<>((Contact) e);

			if (head == null || ((Contact) e).getName().compareToIgnoreCase(((Contact) head.getData()).getName()) < 0) {
				newNode.setNext(head);
				head = newNode;
			} else {
				Node<Event> current = head;
				while (current.getNext() != null && ((Contact) e).getName()
						.compareToIgnoreCase(((Contact) current.getNext().getData()).getName()) >= 0) {
					current = current.getNext();
				}
				newNode.setNext(current.getNext());
				current.setNext(newNode);
			}
		}
	}

//	public boolean remove(T e) {
//		if (isEmpty()) {
//			return false;
//		} else if (head.getData().equals(e)) {
//			head = head.getNext();
//			return true;
//		} else {
//			Node<Contact> current = head;
//			
//			while (current.getNext() != null) {
//				if (current.getNext().getData().equals(e)) {
//					current.setNext(current.getNext().getNext());
//					return true;
//				}
//				current = current.getNext();
//			}
//		}
//		return false;
//	}
	
	public boolean remove(T e) {
		if (isEmpty()) {
			return false;
		} else if (head.getData().equals(e)) {
			head = head.getNext();
			return true;
		} else {
			if (e instanceof Contact) {
				Node<Contact> current = head;
				while (current != null) {
					if (current.getNext().getData().equals((Contact) e)) {
						current.setNext(current.getNext().getNext());
						return true;
					}
					current = current.getNext();
				}
			} else if (e instanceof Event) {
				Node<Event> current = head;
				while (current != null) {
					if (current.getNext().getData().equals((Event) e)) {
						current.setNext(current.getNext().getNext());
						return true;
					}
					current = current.getNext();
				}
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
				searchResults.insert(contact);
			}
			if (searchCriteria.equalsIgnoreCase("phone") && contact.getPhoneNumber().equals(searchValue)) {
				searchResults.insert(contact);
			}
			if (searchCriteria.equalsIgnoreCase("email") && contact.getEmailAddress().equalsIgnoreCase(searchValue)) {
				searchResults.insert(contact);
			}
			if (searchCriteria.equalsIgnoreCase("address") && contact.getAddress().equalsIgnoreCase(searchValue)) {
				searchResults.insert(contact);
			}
			if (searchCriteria.equalsIgnoreCase("birthday") && contact.getBirthday().equals(searchValue)) {
				searchResults.insert(contact);
			}

			current = current.getNext();
		}

		return searchResults;
	}

//	public Contact search(String value) {
//		Node<Contact> current = getHead();
//		while (current != null) {
//			if (((Contact) current.getData()).getName().equalsIgnoreCase(value)
//					|| ((Contact) current.getData()).getPhoneNumber().equalsIgnoreCase(value)) {
//				return (Contact) current.getData();
//			}
//			current = current.getNext();
//		}
//		return null;
//	}
	
	public T search(String value) {
		Node<T> current = head;

		while (current != null) {
			if (current.getData() instanceof Contact) {
				Contact contact = (Contact) current.getData();
				if (value.equals(contact.getName()) || value.equals(contact.getPhoneNumber())) {
					return current.getData();
				}
			} else if (current.getData() instanceof Event) {
				Event event = (Event) current.getData();
				if (value.equals(event.getTitle()) || value.equals(event.getEventUser().getName())) {
					return current.getData();
				}
			}
			current = current.getNext();
		}

		return null;
	}

	public void printEventDetails(String value) {
		Node<Event> current = head;

		while (current != null) {
			boolean title = ((Event) current.getData()).getTitle().equalsIgnoreCase(value);
			boolean name = ((Event) current.getData()).getEventUser().getName().equalsIgnoreCase(value);
			if (title || name) {
				System.out.println(((Event) current.getData()).toString());
			}

			current = current.getNext();
		}
	}

//	public void insertEvent(Event e) {
//		Node<Event> newNode = new Node<>(e);
//
//		if (head == null || e.getTitle().compareToIgnoreCase(((Event) head.getData()).getTitle()) < 0) {
//			newNode.setNext(head);
//			head = newNode;
//		} else {
//			Node<Event> current = head;
//			while (current.getNext() != null
//					&& e.getTitle().compareToIgnoreCase(((Event) current.getNext().getData()).getTitle()) >= 0) {
//				current = current.getNext();
//			}
//			newNode.setNext(current.getNext());
//			current.setNext(newNode);
//		}
//	}
	
	public void scheduleEvent(String title, String date, String time, String location, Contact eventUser) {

		if (eventUser != null) {
			boolean hasConflict = false;
			Event newEvent = new Event(title, date, time, location, eventUser);
			

			Node current = head;
			while (current != null) {
				if (current.getData() instanceof Event) {
					Event existingEvent = (Event) current.getData();
					if (existingEvent.getEventUser().equals(eventUser)
							&& existingEvent.getDate().equals(newEvent.getDate())
							&& existingEvent.getTime().equals(newEvent.getTime())) {

						hasConflict = true;
						break;
					}
				}
				current = current.getNext();

			}

			if (!hasConflict) {
				insert((T) newEvent);
				eventUser.addEvent(newEvent);
			} else {
				System.out.println("Event scheduling conflict. Cannot schedule the event.");
			}

		} else {
			System.out.println("Contact does not exist in the phonebook.");
		}
	}
	
	public void printAllEvents() {
		Node<Event> current = head;

		if (current == null) {
			System.out.println("No events found.");
			return;
		}

		while (current != null) {
			System.out.println(current.getData().toString());
			current = current.getNext();
		}
	}

}