import java.util.*;

public class Input
{
    public LLQueueADT infix;
    public LLQueueADT operands;
    public Infix expression;
    
    public void setExpression(String e) {
        infix = new LLQueueADT();
        operands = new LLQueueADT();
        expression = new Infix();
        Scanner input = new Scanner(e);
                
        String token = "";
        
        do {  
            token = input.nextLine();
            if(expression.tokenIsAnOperand(token) && !operands.found(token))
                operands.enqueue(token);
            infix.enqueue(token);
        } while(!token.equals("#"));
    }
    
}
