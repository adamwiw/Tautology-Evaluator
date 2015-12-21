import java.text.ParseException; 

public class Infix {
    private LLQueueADT infix;

    public Infix() {
    }
    
    public void setInfix(LLQueueADT infix) {
        this.infix = infix;
    }

    private int priority(String token, boolean infix) {
        String t[] = new String[8];
        int priority[] = new int[8];
        int p = 0;
        t[0] = "<-->";
        t[1] = "-->";
        t[2] = "&";
        t[3] = "v";
        t[4] = "~";
        t[5] = "(";
        t[6] = ")";
        t[7] = "#";
        priority[0] = 1;
        priority[1] = 2;
        priority[2] = 4;
        priority[3] = 3;
        priority[4] = 5;
        priority[5] = 6;
        if(infix)
            priority[6] = 0;
        priority[7] = 0;
        for(int n = 0; n < t.length; n++) {
            if(t[n].equals(token)) {
                p = priority[n];
                break;
            }
        }
        return(p);
    }

    public boolean tokenIsAnOperand(String token) {
        return(!token.equals(")") && !token.equals("(") && !token.equals("#") && 
            !token.equals("~") && !token.equals("&") && !token.equals("v") && 
            !token.equals("-->") && !token.equals("<-->"));
    }

    private LLQueueADT postfixf() {
        LLQueueADT postfix = new LLQueueADT();
        LLStackADT operatorStack = new LLStackADT();
        String token;
        operatorStack.push("#");
        do {
            token = this.infix.dequeue();
            if(tokenIsAnOperand(token))
                postfix.enqueue(token);
            else if(token.equals("#"))
                while(!operatorStack.empty())
                    postfix.enqueue(operatorStack.pop());
            else {
                if(token.equals(")")) {
                    while(!operatorStack.ontop().equals("("))
                        postfix.enqueue(operatorStack.pop());
                    operatorStack.pop();
                    }
                else {
                    if(!operatorStack.ontop().equals("(") && priority(operatorStack.ontop(), false) >= priority(token, true)) // unsure of the first condition token or operatorstack on top?
                        postfix.enqueue(operatorStack.pop());
                    operatorStack.push(token);
                }
            }
        } while(!token.equals("#"));

        return(postfix);
    }
    
    private boolean implication(boolean p, boolean q) {
        return(!p || q);
    }
    
    private boolean apply(boolean q, boolean p, String operator) throws ParseException {
        if(operator.equals("-->"))
            return(implication(p, q));
        else if(operator.equals("<-->"))
            return(implication(p, q) && implication(q, p));
        else if(operator.equals("&"))
            return(p && q);
        else if(operator.equals("v"))
            return(p || q);
        else if(operator.equals("~"))
            return(!q);
        else
            throw new ParseException("Incompatible operator: " + operator, 83);
    }
    
    public boolean evaluate(String names[], boolean values[]) throws ParseException {
        LLStackBooleanADT val = new LLStackBooleanADT();
        LLQueueADT postfix = postfixf();
        boolean value = false;
        while(!postfix.front().equals("#")) {
            if(tokenIsAnOperand(postfix.front())) {
                for(int n = 0; n < names.length; n++) {
                    if(postfix.front().equals(names[n])) {
                        value = values[n];
                        postfix.dequeue();
                        break;
                    }
                }
                val.push(value);
            }
            else {
                try {
                    if(postfix.front().equals("~"))
                        val.push(apply(val.pop(), false, postfix.dequeue()));
                    else
                        val.push(apply(val.pop(), val.pop(), postfix.dequeue()));
                } catch(ParseException e) {
                    throw e;
                }
            }
        }
        return(val.pop());
    }
    
    public String toString() {
        String expression = "";
        while(!infix.empty())
            expression += infix.dequeue();
        return(expression);
    }
}
