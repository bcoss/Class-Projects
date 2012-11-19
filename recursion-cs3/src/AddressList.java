public class AddressList {

	/**
	 * This nested, private class represents a node of a singly linked list.
	 */
	private class ListNode {
		private String name;
		private String tel; // Telephone number
		private String email;
		private String addr; // Address
		private String dob; // Date of birth
		private ListNode next; // Pointer to the next node

		private ListNode(String name, String tel, String email, String addr,
				String dob) {
			this.name = name;
			this.tel = tel;
			this.email = email;
			this.addr = addr;
			this.dob = dob;
		} // end of the constructor

		public String getName() {
			return name;
		}

		public String getTel() {
			return tel;
		}

		public String getEmail() {
			return email;
		}

		public String getAddr() {
			return addr;
		}

		public String getDob() {
			return dob;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode link) {
			next = link;
		}
	}

	// end of class ListNode

	private ListNode head;
	private int numNodes;

	public AddressList() {
		head = null;
		numNodes = 0;

	}

	public boolean isEmpty() {
		return numNodes == 0;
	}

	public void addToFront(String name, String tel, String email,
			String address, String dob) {

		ListNode node = new ListNode(name, tel, email, address, dob);
		node.setNext(head);
		head = node;
		numNodes++;

	}

	public void addToBack(String name, String tel, String email,
			String address, String dob) {

		ListNode cur = new ListNode(name, tel, email, address, dob);
		ListNode temp = head;

		if (head == null) {
			head = cur;
			return;
		}

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		temp.setNext(cur);
		numNodes++;

	}

	public String toString() {
		ListNode tmp = head;
		String s = "";

		if (isEmpty()) {
			return "No names found.";
		}

		while (tmp.getNext() != null) {
			s += tmp.getName() + " " + tmp.getTel() + " " + tmp.getEmail()
					+ " " + tmp.getAddr() + " " + tmp.getDob() + "\n";
		}

		return s;
	}

	public String reverseToString() {
		return null;
	}

	public AddressList reverse() {
		return null;
	}

	public int sizeOf() {
		return numNodes;
	}

	public String phoneNumberByName(String name) {
		return null;
	}

	public String emailByName(String name) {
		return null;
	}

	public String nameByPhoneNumber(String tel) {
		return null;
	}

	public String dobByName(String name) {
		return null;
	}

} // end of class AddressList