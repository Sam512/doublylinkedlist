//Code by Samarth Dave
import java.util.Scanner;
public class DoublyLinkedList {
	static Scanner s;
	public static void main(String[] args) {
		System.out.println("Linked List Tester by Samarth Dave");
		int i = -1;
		s = new Scanner(System.in);
		LL<String> list = new LL<>();
		do {
			i = -1;
			System.out.printf("\n%20s\n1.  %-15s  2.  %-15s\n3.  %-15s  4.  %-15s", "-Menu-", "Print X Forward", "Print X Backward", "Print First", "Print Last");
			System.out.printf("\n5.  %-15s  6.  %-15s\n7.  %-15s  8.  %-15s", "Get Location", "Remove First", "Remove Last", "Remove X");
			System.out.printf("\n9.  %-15s  10. %-15s\n11. %-15s  12. %-15s", "Add First", "Add Last", "Insert", "Set X");
			System.out.printf("\n13. %-15s  14. %-15s\n15. %-15s  0. %-15s\n", "Size", "Is Empty", "Clear", "Exit");
			i = validInt("Enter selection: ");
			switch(i) {
				case 1:
					//print x forwards
					int forwardTimes = validInt("Enter the number of items you want to see: ");
					list.printForward(forwardTimes);
					break;
				case 2:
					//print x backwards
					int backTimes = validInt("Enter the number of items you want to see: ");
					list.printBackward(backTimes);
					break;
				case 3:
					//print first
					out((list.empty()) ? "The list is empty." : "The first item in the list is " + list.first.data + ".");
					break;
				case 4:
					//print last
					out((list.empty()) ? "The list is empty." : "The last item in the list is " + list.last.data + ".");
					break;
				case 5:
					//get x
					int r = validInt("Enter the position you want to get: ");
					out((list.get(r) == null) ? "Invalid input." : "The value at position " + r + " is " + list.get(r) + ".");
					break;
				case 6:
					//remove first
					String item = list.removeFirst();
					out((item == null) ? "The list is empty." : item + " was removed from first.");
					break;
				case 7:
					//remove last
					String remLast = list.removeLast();
					out((remLast == null) ? "The list is empty." : remLast + " was removed from last.");
					break;
				case 8:
					//remove x
					int removeX = validInt("Enter an index: ");
					if(removeX < 0 || removeX > list.size()-1) {
						out("Invalid input.");
					} else {
						out(list.removeX(removeX) + " was removed.");
					}
					break;
				case 9:
					//add first
					System.out.print("Enter the text you want to add: ");
					String g = s.nextLine();
					list.addFirst(g);
					out(g + " was added.");
					break;
				case 10:
					//add last
					System.out.print("Enter the text you want to add: ");
					String f = s.nextLine();
					list.addLast(f);
					out(f + " was added.");
					break;
				case 11:
					//insert
					System.out.print("Enter the text you want to insert: ");
					String insertString = s.nextLine();
					int insertIndex = validInt("Enter an index: ");
					if(insertIndex < 0 || insertIndex > list.size()-1) {
						out("Invalid input.");
					} else {
						list.insert(insertIndex, insertString);
						out(insertString + " was added.");
					}
					break;
				case 12:
					//set x
					System.out.print("Enter a replacement text: ");
					String setNew = s.nextLine();
					int setIndex = validInt("Enter an index: ");
					if(setIndex < 0 || setIndex > list.size()-1) {
						out("Invalid input.");
						break;
					}
					out(list.setX(setIndex, setNew) + " was replaced with " + setNew + ".");
					break;
				case 13:
					//size
					out("The size of the list is " + list.size() + ".");
					break;
				case 14:
					out((list.empty()) ? "The list is empty." : "The list is not empty.");
					break;
				case 15:
					list.clear();
					out("The list has been cleared.");
			}
		} while(i != 0);
		s.close();
		out("User exited.");
	}
	public static int validInt(String out) {
		int c = -1;
		System.out.print(out);
		while(!s.hasNextInt()) {
			System.out.print("Error, try again: ");
			s.next();
		}
		c = s.nextInt();
		s.nextLine();
		return c;
	}
	public static void out(String s) {
		System.out.println("\n" + s);
	}
}