//Code by Samarth Dave
public class Node<E> {
	E data;
	Node<E> prev, next;
	public Node(E data) {
		this.data = data;
		next = null;
		prev = null;
	}
	public Node(E d, Node<E> n, Node<E> p) {
		data = d;
		next = n;
		prev = p;
    }
	public String toString() {
		return data + "";
	}
	public E       getData() { return data; }
	public void    setData(E data) { this.data = data; }
	public Node<E> getNext() { return next; }
	public void    setNext(Node<E> next) { this.next = next; }
	public Node<E> getPrev() { return next; }
	public void    setPrev(Node<E> prev) { this.prev = prev; }
}