import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Muhammad Saad Shahid
 *This class implements the postfix to infix and evaluates it
 */
public class PostfixReader {
	
	/**mathError indicates if there is division by zero
	 * fin stores fin infix expression
	 */
	public static boolean mathError=false;
	public String fin="";
	
	/**
	 * @param args no argument taken. conversion is started
	 */
	public static void main(String[] args) {
		PostfixReader myAnswer = new PostfixReader();
		myAnswer.doConversion();
	}
	
	/**
	 * Starts conversion process. uses Readpostfix to read. converts to infix and checks for validity.
	 * Uses the evalinfix method to evaluate the expression 
	 */
	public void doConversion() {
		// TODO: read Postfix from input using readPostfix(), then convert it to infix and
		// print it out
		try {
			//ReadPostfix r= new ReadPostfix();
			String[] expression=readPostfix();
			Stack stack=new Stack();
			Stack number=new Stack();
	        for (int i = 0; i <expression.length ; i++) {
	            String c = expression[i];
	            if(c.contentEquals("*")||c.contentEquals("/")||c.contentEquals("^")||c.contentEquals("+")||c.contentEquals("-")){
	                String s1 = stack.pull();
	                String s2 = stack.pull();
	                //System.out.println(s1);
	                //System.out.println(s2);
	                if ((s1.contentEquals("err")) || (s2.contentEquals("err"))) {
	                	System.out.println("Invalid postfix");
						return;
	                }
	                String temp = "("+s2+c+s1+")";
	                stack.push(temp);
	                String s11 = number.pull();
	                String s12 = number.pull();
	                temp = "("+" "+s12+" "+c+" "+s11+" "+")";
	                number.push(temp);
	            }
	            else{
	                stack.push(c);
	                number.push(c);
	            }
	        }
	        //System.out.println(stack.current);
	        if (stack.current!=1) {
				System.out.println("Invalid postfix");
				return;
			}
	        fin=stack.pull();
	        String numString=number.pull();
	        //System.out.println(numString);
	        evalInfix(numString);
		}
		catch(Exception e) {
			System.out.println("Invalid postfix");
		}
		}


		
		
	
	/**
	 * @param infix is the infix expression string with each element seperated by spaces. 
	 * The method uses the calculation class to evaluate the expression and prints the result
	 */
	public void evalInfix(String infix) {
		// TODO: evaluate the infix representation of the input arithmetic expression, 
		// and then print the result of the evaluation of the expression on the next line.
		//4 5 6 / - 4 6 / 2 - *
		Calculation s = new Calculation();
		NumStack numStack= new NumStack();
		double result=0;
		boolean flag=false;
		String[] expression=infix.split(" ");
		for (int i=0; i<expression.length; i++) {
			String c = expression[i];
			String op=",";
			if (c.contentEquals(")")) {
				flag=false;
				for (int j=i; j>=0; j--) {
					/*for (int x=0; x<expression.length; x++)
						System.out.print(expression[x]);
					System.out.println();
					*/
					if (expression[j].contentEquals(",")) {
						continue;
					}
					
					//Assuming that each operation has parenthesis and only one operation per pair of parenthesis
					if ((s.isOperation(expression[j])==0) && !(expression[j].contentEquals(",")) && !(expression[j].contentEquals("(")) && !(expression[j].contentEquals(")"))) {
						numStack.push(Double.valueOf(expression[j]));
						flag=false;
					}
					if (s.isOperation(expression[j])>=1) {
						op=expression[j];
						flag=true;
					}
					//
					
					if (expression[j].contentEquals("(")) {
						expression[j]=",";
						break;
					}
					expression[j]=",";
				}
				double n1=0;
				double n2=0; 
				if (!flag) {
					n1 = numStack.pull();
					n2 = numStack.pull();
				}
				else {
					n2 = numStack.pull();
					n1 = numStack.pull();
				}
				if (mathError) {
					//System.out.println("Invalid postfix");
					return;
				}
				result=s.evaluate(n1,n2,op);
				//System.out.println(n1);
				//System.out.println(n2);
				//System.out.println(op);
				//System.out.println(result);
				numStack.push(result);
			}
		}
		
		if (mathError) {
			System.out.println("Invalid postfix");
			return;
		}
		System.out.println(fin);
		double ans=numStack.pull();
		if (ans%1==0) {
			System.out.println(Math.round(ans));
		}
		else{
			System.out.println(ans);
		}
	}

	/**
	 * @return returns input string array
	 */
	public String[] readPostfix() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputLine;
		try {
			System.out.print("Input Postfix: ");
			inputLine = input.readLine();
			return inputLine.split(" ");
		} catch (IOException e) {
			System.err.println("Input ERROR.");
		}

		// return empty array if error occurs
		return new String[] {};
	}

}


