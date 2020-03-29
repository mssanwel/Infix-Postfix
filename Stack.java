/**
 * @author Muhammad Saad Shahid
 * this is a stack implementation
 */
public class Stack {
	
	// TODO: implement Stack in this class
	/**
	 * current points to available slot
	 * stack is a string implementation of a stack
	 */
	int current=0;//points to current empty element
	String[] stack= new String[100];
	
	/**
	 * @param element pushes the value in element in stack and saves it at index pointed by current
	 */
	public void push(String element) {
		stack[current]=element;
		current++;
	}
	
	/**
	 * @return the topmost element in the stack
	 */
	public String pull() {
		if (current >= 0) {
			current--;
			return stack[current];	
		}
		else
			System.out.println("err");
			return "err";
	}
	
	/**
	 * @return if stack is empty or not
	 */
	public boolean empty() {
		if (current<=0)
			return true;
		else
			return false;
	}
}