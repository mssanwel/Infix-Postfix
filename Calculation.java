
/**
 * @author Muhammad Saad Shahid
 *provides methods for program calculation
 */
public class Calculation {
	
	public static double sum=0;
	/**
	 * @param operand1 first operand to evaluate
	 * @param operand2 second operand to evaluate
	 * @param op operator which decides the operation to be performed on other parameters
	 * @return the value of the operation on operands 
	 */
	public double evaluate(double operand1, double operand2, String op) {
		//System.out.println(operand1);
		if (op.contentEquals("+")){
			//System.out.println("Adding");
			return operand1+operand2;
			//System.out.println(PostfixReader.sum);
		}
		if (op.contentEquals("-")){
			//System.out.println("Subtracting");
			return operand1-operand2;
			//System.out.println(PostfixReader.sum);
		}
		if (op.contentEquals("*")){
			//System.out.println("Multiplication");
			return operand1*operand2;
			
			//System.out.println(PostfixReader.sum);
		}
		if (op.contentEquals("/")){
			//System.out.println("Dividing");
			if (operand2==0) {
				//System.out.println("Invalid postfix");
				PostfixReader.mathError=true;
				return 0;
			}
			return operand1/operand2;
			//System.out.println(PostfixReader.sum);
		}
		if (op.contentEquals("^")){
			//System.out.println("Exponent");
			double total=1;
			for (int i=0; i<operand2; i++)
				total=total*operand1;
			return total;
			
			//System.out.println(PostfixReader.sum);
		}
		return 0;
	}
	
	/**
	 * @param element is the character input. checks to see if the character is a valid operation or number
	 * @return number according to precedence. 0 for numbers
	 */
	public int isOperation(String element){
		
		if (element.contentEquals("^"))
			return 3;
		else if (element.contentEquals("*"))
			return 2; 
		else if (element.contentEquals("/"))
			return 2;
		else if (element.contentEquals("+"))
			return 1;
		else if (element.contentEquals("-"))
			return 1;
		else
			return 0;	
	}
}

