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
}  