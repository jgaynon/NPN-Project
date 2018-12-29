
import java.util.*;

class polishParser {
    public static void main(String[] args) {
        //Scanner takes input from stdin
        Scanner in = new Scanner(System.in);
        //split converts the space delineated input string into an array of strings
        System.out.println(evalNPN(in.nextLine().split(" ")));
    }

    private static Boolean isOperand(String str) {
        // If argument is all digits it is an operand
        boolean isNumeric = true;
        try {
            Integer num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            isNumeric = false;
        }
        return isNumeric;
    }

    private static int evalNPN(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        //evaluate the expression starting from the right
        for (int p = args.length - 1; p >= 0; p--) {
            //if operand encountered, push it onto the stack
            if (isOperand(args[p])) {
                stack.push(Integer.parseInt(args[p]));
            } else {
                //if operand not encountered, must be an operator
                //pop the last two operands off the stack
                int operand1 = stack.peek();
                stack.pop();
                int operand2 = stack.peek();
                stack.pop();
                //use switch to perform the correct operation on the two operands
                switch (args[p]) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "x":
                        stack.push(operand1 * operand2);
                        break;

                }
            }
        }
        //when expression has been fully evaluated, answer is left on the stack
        //return answer
        return stack.peek();
    }
}
