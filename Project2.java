import java.util.*;
import java.text.ParseException; 

public class Project2 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String result;
        boolean tautology = true;
        String expression = "";
        String token = "";
        Input in = new Input();

        System.out.println("Input your boolean expression, token at a time please!");
        do
        {     
            token = input.nextLine();
            expression += token + "\n";
        } while(!token.equals("#"));
        in.setExpression(expression);
        int permutations = (int) Math.pow(2, in.operands.size());
        String keys[] = new String[in.operands.size()];
        boolean values[] = new boolean[in.operands.size()];
        for(int n = 0; !in.operands.empty(); n++)
            keys[n] = in.operands.dequeue();
        for(int n = 0; tautology && n < permutations; n++) {
            String binary = Integer.toString(n, 2);
            for(int m = 0; m < in.operands.size(); m++)
                if(m < binary.length())
                    values[m] = "1".equals(String.valueOf(binary.charAt(m)));
                else
                    values[m] = false;
            try {
                in.expression.setInfix(in.infix);
                tautology &= in.expression.evaluate(keys, values);
                System.out.println(tautology);
            } catch(ParseException e) {
                System.out.println(e.getMessage());
            }
            in.setExpression(expression);
        }
        result = tautology?" is":" isn't";
        System.out.println("The expression " + expression.replace("\n", "") + result + " a tautology.");
    }
}
