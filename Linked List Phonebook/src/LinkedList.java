
public class LinkedList<T> {

	private Node<T> head;

	public LinkedList() {
		head = null;
	}
	
	public Node<T> getHead() {
		return head;
	}
	
	public void addContact(Contact<T> contact) {
		Node<T> newNode = new Node<T>(contact);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}

	public boolean deleteContact(Contact<T> contact) {
		if (head == null) {
			return false;
		} else if (head.getContact().equals(contact)) {
			head = head.getNext();
			return true;
		} else {
			Node<T> current = head;
			while (current.getNext() != null) {
				if (current.getNext().getContact().equals(contact)) {
					current.setNext(current.getNext().getNext());
					return true;
				}
				current = current.getNext();
			}
		}
		return false;
	}

	public LinkedList searchContactsByCriteria(String searchCriteria, String searchValue) {
		LinkedList searchResults = new LinkedList();

		Node<T> current = head;

		while (current != null) {
			Contact contact = current.getContact();

			if (searchCriteria.equalsIgnoreCase("name") && contact.getName().equalsIgnoreCase(searchValue)) {
				searchResults.addContact(contact);
			}
			if (searchCriteria.equalsIgnoreCase("phone") && contact.getPhoneNumber().equals(searchValue)) {
				searchResults.addContact(contact);
			}
			if (searchCriteria.equalsIgnoreCase("email") && contact.getEmailAddress().equalsIgnoreCase(searchValue)) {
				searchResults.addContact(contact);
			}
			if (searchCriteria.equalsIgnoreCase("address") && contact.getAddress().equalsIgnoreCase(searchValue)) {
				searchResults.addContact(contact);
			}
			if (searchCriteria.equalsIgnoreCase("birthday") && contact.getBirthday().equals(searchValue)) {
				searchResults.addContact(contact);
			}

			current = current.getNext();
		}

		return searchResults;
	}

}
