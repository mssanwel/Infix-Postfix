
public class NumStack {
	// TODO: implement Stack in this class
		/**
		 * current points to available slot
		 * stack is a string implementation of a stack
		 */
		int current=0;//points to current empty element
		double[] stack= new double[100];
		
		/**
		 * @param element pushes the value in element in stack and saves it at index pointed by current
		 */
		public void push(double element) {
			stack[current]=element;
			current++;
		}
		
		/**
		 * @return the topmost element in the stack
		 */
		public double pull() {
			if (current > 0) {
				current--;
				return stack[current];	
			}
			else
				return 0;
			
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
