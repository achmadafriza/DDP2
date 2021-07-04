package ddp2.tp4;

import java.util.Deque;
import java.util.LinkedList;

public class InFixtoPostFix {
    private static int precedence(Character c) throws ArithmeticException {
        switch(c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }

        throw new ArithmeticException("Only simple operators (+, -, *, /, ^) are allowed");
    }

    private static String spaced(String c) {
        return c + " ";
    }

    private static String spaced(Character c) {
        return c + " ";
    }

    public static String convert(String input) throws ArithmeticException {
        /*
         * while there are more symbols to be read
             * read the next symbol
             * case:
                 * operand --> output it.
                 * ’(’ --> push it on the stack.
                 * ’)’ --> pop operators from the stack to the output
                 * until a ’(’ is popped; do not output either
                 * of the parentheses.
                 * operator --> pop higher- or equal-precedence operators
                 * from the stack to the output; stop before
                 * popping a lower-precedence operator or
                 * a ’(’. Push the operator on the stack.
             * end case
         * end while
         * pop the remaining operators from the stack to the output
         */
        String s = input.trim();
        StringBuilder result = new StringBuilder();
        Deque<Character> queue = new LinkedList<>();
        StringBuilder operand = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
//            System.out.print(c + " | ");
//            System.out.print(queue + " | ");
//            System.out.print(operand + " | ");
//            System.out.println(result);

//            Space between integers is not allowed i.e. 11 12 + 3
//            Whitespace is parsed manually as users are stupid and may give "    122 31 + 2*5  "
            if(Character.isWhitespace(c)) {
                if(operand.length() != 0 && Character.isDigit(s.charAt(i+1))) {
                    throw new ArithmeticException(String.format("Missing operator near %s", operand.toString()));
                }
                else {
                    continue;
                }
            }

//            As per Requirement, the expression only contains integers
            if(Character.isLetter(c)) {
                throw new ArithmeticException(String.format("Expression cannot have letters in it (%c in index %d)", c, i));
            }

            if(Character.isDigit(c)) {
                operand.append(c);
            }
            else {
                if(operand.length() != 0) {
                    result.append(spaced(operand.toString()));
                    operand.setLength(0);
                }

                if(c == '(') {
                    queue.add(c);
                }
                else {
                    if(c == ')') {
                        try {
                            while(queue.peekLast() != '(') {
                                result.append(spaced(queue.pollLast()));
                            }

                            queue.pollLast();
                        }
                        catch(NullPointerException e) {
                            throw new ArithmeticException("'(' is not found until the end");
                        }
                    }
                    else {
                        while(!queue.isEmpty() && queue.peekLast() != '(' && precedence(queue.peekLast()) >= precedence(c)) {
                            result.append(spaced(queue.pollLast()));
                        }

                        queue.add(c);
                    }
                }
            }
        }

//        Printing remaining operand and operators
        if(operand.length() != 0) {
            result.append(spaced(operand.toString()));
        }

        while(!queue.isEmpty()) {
            if(queue.peekLast() == '(')
                throw new ArithmeticException("There's excess '('");

            result.append(spaced(queue.pollLast()));
        }

        return result.toString();
    }

    public static String getCalculation(String input) throws ArithmeticException, NullPointerException {
        return Integer.toString(calculate(convert(input)));
    }

    private static int calculate(String postfix) throws NullPointerException {
        /**
         * calculate is private to allow controlled calculations
         * it'll be hardcoded to only accept postfix results from this class
         * NullPointerException means the expression is something like 1 + + 2 which is not valid
         */
        String[] a = postfix.split("\\s");
        Deque<Integer> queue = new LinkedList<>();

//        for(int i = 0; i < a.length; i++)
//            System.out.print(a[i] + ",");

        for(int i = 0; i < a.length; i++) {
            try {
                queue.add(Integer.parseInt(a[i]));
            }
            catch(NumberFormatException e) {
                Integer operand2 = queue.pollLast();
                Integer operand1 = queue.pollLast();

                switch(a[i]) {
                    case "+":
                        queue.add(operand1 + operand2);
                        break;
                    case "-":
                        queue.add(operand1 - operand2);
                        break;
                    case "*":
                        queue.add(operand1 * operand2);
                        break;
                    case "/":
                        queue.add(operand1 / operand2);
                        break;
                    case "^":
                        queue.add((int) Math.pow(operand1, operand2));
                        break;
                }
            }
        }

        return queue.peek();
    }

//    public static void main(String[] args) {
//        String s = "(1-2)-((((4^5)*3)*6)/(7^(2^2)))";
//        String result = convert(s);
//
//        System.out.println(result);
//        System.out.println(calculate(result));
//    }
}