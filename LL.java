//Code by Samarth Dave
public class LL<E> {
	Node<E> first, last;
	public LL() {
		first = null;
		last = null;
	}
	public LL(E data) {
		first = last = new Node<>(data);
	}
	public int size() {
		if(first == null) {
			return 0;
		} else if(first == last) {
			return 1;
		} else {
			int s = 1;
			Node<E> temp = first;
			do {
				s++;
				temp = temp.next;
			} while(temp != last);
			return s;
		}
	}
	public boolean empty() {
		return first == null;
	}
	public void addFirst(E data) {
		if(empty()) {
			first = last = new Node<>(data);
		} else if(first == last) {
			E temp = first.data;
			first = new Node<>(data);
			last = new Node<>(temp);
			first.next = last;
			last.prev = first;
			first.prev = last;
			last.next = first;
		} else {
			Node<E> temp = new Node<>(data);
			last.next = temp;
			temp.prev = last;
			first.prev = temp;
			temp.next = first;
			first = temp;
		}
	}
	public void addLast(E data) {
		if(empty()) {
			first = last = new Node<>(data);
		} else if(first == last) {
			E temp = first.data;
			first = new Node<>(temp);
			last = new Node<>(data);
			first.next = last;
			last.prev = first;
			first.prev = last;
			last.next = first;
		} else {
			Node<E> temp = new Node<>(data);
			last.next = temp;
			temp.prev = last;
			first.prev = temp;
			temp.next = first;
			last = temp;
		}
	}
	public void clear() {
		first = last = null;
	}
	public E get(int x) {
		if(x < 0 || x > size()-1) {
			return null;
		} else {
			if(first == null) {
				return null;
			} else if(first == last) {
				if(x != 0)
					return null;
				return first.data;
			} else {
				if(x == size()-1)
					return last.data;
				if(x == 0)
					return first.data;
				int s = 1;
				Node<E> temp = first;
				do {
					if(s-1 == x)
						return temp.data;
					s++;
					temp = temp.next;
				} while(temp != last);
			}
			System.out.println("here");
			return null;
		}
	}
	public E removeFirst() {
		if(empty()) {
			return null;
		} else if(size() == 1) {
			E temp = first.data;
			clear();
			return temp;
		} else if(size() == 2) {
			E temp = first.data;
			E tempLast = last.data;
			clear();
			first = last = new Node<>(tempLast);
			return temp;
		} else {
			E temp = first.data;
			last.next = first.next;
			first.next.prev = last;
			first = first.next;
			return temp;
		}
	}
	public E removeLast() {
		if(empty()) {
			return null;
		} else if(size() == 1) {
			E temp = first.data;
			clear();
			return temp;
		} else if(size() == 2) {
			E tempFirst = first.data;
			E tempLast = last.data;
			first = last = new Node<>(tempFirst);
			return tempLast;
		} else {
			E temp = last.data;
			first.prev = last.prev;
			last.prev.next = first;
			last = last.prev;
			return temp;
		}
	}
	public E removeX(int x) {
		if(x < 0 || x > size()-1) {
			return null;
		}
		if(x == 0) {
			return removeFirst();
		} else if(x == size()-1) {
			return removeLast();
		} else {
			int s = 1;
			Node<E> temp = first;
			do {
				if(s-1 == x) {
					E hold = temp.data;
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					return hold;
				}
				s++;
				temp = temp.next;
			} while(temp != last);
			return null;
		}
	}
	public E setX(int x, E r) {
		if(x < 0 || x > size()-1) {
			return null;
		}
		if(x == 0) {
			E temp = first.data;
			first.data = r;
			return temp;
		} else if(x == size()-1) {
			E temp = last.data;
			last.data = r;
			return temp;
		} else {
			int s = 1;
			Node<E> temp = first;
			do {
				if(s-1 == x) {
					E getMe = temp.data;
					temp.data = r;
					return getMe;
				}
				s++;
				temp = temp.next;
			} while(temp != last);
		}
		return null;
	}
	public void insert(int x, E data) {
		if(x < 0 || x > size()-1)
			return;
		if(x == 0) {
			addFirst(data);
		} else if(x == size()) {
			addLast(data);
		} else {
			Node<E> elem = new Node<>(data);
			Node<E> item = first;
			for(int i = 1; i <= size(); i++) {
				if(i == x) {
					Node<E> temp = item.next;
					item.next = elem;
					elem.prev = item;
					elem.next = temp;
					temp.prev = elem;
				}
				item = item.next;
			}
		}
	}
	public void printForward(int i) {
		if(empty()) {
			DoublyLinkedList.out("The list is empty.");
			return;
		}
		if(i < 0) {
			DoublyLinkedList.out("Enter a positive number.");
			return;
		} else if(i == 0) {
			DoublyLinkedList.out("The first 0 items going forward are: [].");
			return;
		}
		if(size() == 1) {
			DoublyLinkedList.out("The first " + i + " item going forward is:");
			System.out.print("[");
			for(int g = 0; g < i; g++) {
				System.out.print((g < i-1) ? first.data + ", " : first.data);
			}
			System.out.print("]");
			return;
		}
		DoublyLinkedList.out("The first " + i + " items going forwards are: ");
		System.out.print("[");
		int c = 0;
		Node<E> temp = first;
		do {
			System.out.print((c == i-1) ? temp : temp + ", ");
			temp = temp.next;
			c++;
		} while(c < i);
		System.out.print("].\n");
	}
	public void printBackward(int i) {
		if(empty()) {
			DoublyLinkedList.out("The list is empty.");
			return;
		}
		if(i < 0) {
			DoublyLinkedList.out("Enter a positive number.");
			return;
		} else if(i == 0) {
			DoublyLinkedList.out("The first 0 items going backward are: [].");
			return;
		}
		if(size() == 1) {
			DoublyLinkedList.out("The first " + i + " item going backwards is:");
			System.out.print("[");
			for(int g = 0; g < i; g++) {
				System.out.print((g < i-1) ? first.data + ", " : first.data);
			}
			System.out.print("]");
			return;
		}
		DoublyLinkedList.out("The first " + i + " items going backwards are: ");
		System.out.print("[");
		int c = 0;
		Node<E> temp = last;
		do {
			System.out.print((c == i-1) ? temp : temp + ", ");
			temp = temp.prev;
			c++;
		} while(c < i);
		System.out.print("].\n");
	}
	public String toString() {
		if(empty())
			return "[]";
		else if(size() == 1)
			return "[" + first.data + "]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int i = size();
		int c = 0;
		Node<E> temp = first;
		do {
			sb.append((c == i-1) ? temp : temp + ", ");
			temp = temp.next;
			c++;
		} while(c < i);
		sb.append("]");
		return sb.toString();
	}
	public Node<E> getFirstNode() {
		return first;
	}
	public E getFirst() {
		return (first == null) ? null : first.data;
	}
	public Node<E> getLastNode() {
		return last;
	}
	public E getLast() {
		return (last == null) ? null : last.data;
	}
}