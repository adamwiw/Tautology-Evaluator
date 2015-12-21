import java.util.*;
import java.text.ParseException; 

public class Project2 {
    public static void main(String args[]) {
	Infix expression = new Infix();
	LLQueueADT infix = new LLQueueADT();
	LLQueueADT operands = new LLQueueADT();
	Scanner input = new Scanner(System.in);
	String token;
	String result;
	boolean tautology = true;

	System.out.println("Input your boolean expression, token at a time please!");
	token = input.nextLine();
	while(!token.equals("#")) {
	    infix.enqueue(token);
	    if(expression.tokenIsAnOperand(token))
		operands.enqueue(token);
	    token = input.nextLine();
	}
	int permutations = (int) Math.pow(2, operands.size());
	String keys[] = new String[operands.size()];
	boolean values[] = new boolean[operands.size()];
	boolean results[] = new boolean[permutations];
	expression.setInfix(infix);
	for(int n = 0; !operands.empty(); n++)
	    keys[n] = operands.dequeue();
	for(int n = 0; n < permutations; n++) {
	    String binary = Integer.toString(n, 2);
	    for(int m = 0; m < operands.size(); m++)
		if(m < binary.length())
		    values[m] = "1".equals(String.valueOf(binary.charAt(m)));
		else
		    values[m] = false;
	    try {
		tautology &= expression.evaluate(keys, values);
	    } catch(ParseException e) {
		System.out.println(e.getMessage());
	    }
	}
	result = tautology?" is":" isn't";
	System.out.println("The expression " + expression + result + " a tautology.");
    }
}