package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.Stack;
import edu.isu.cs.cs3308.structures.impl.LinkedStack;
import edu.isu.cs.cs3308.structures.impl.DoublyLinkedList;
import static java.lang.Integer.parseInt;
/**
 * Postfix expression evaluator.
 *
 * @author Isaac Griffith
 */
public class PostFix {
    /**
     * Evaluates the provided postfix expression and returns the answer. If the
     * provided string is null, empty, or only contains whitespace then return
     * 0;
     *
     * @param postfix A string representing an postfix notation expression where
     *                each item is separated by a space.
     * @return value of the postfix express or 0 if the postfix expression is null,
     * empty, or contains only whitespace.
     */
    public static int evalPostFix(String infix) {
        final String plus = "+";
        final String minus = "-";
        final String multiply = "*";
        final String divide = "/";
        // New empty stack
        LinkedStack<Integer> postStack = new LinkedStack<>();
        if (infix == null || infix.trim().isEmpty()) {
            return 0;
        } else {
            String[] array = infix.split(" ");
            // Go through array
            for (int i = 0; i < array.length; i++) {
                if ( array[i].equals("+") && array[i].equals("-") && array[i].equals("/") && array[i].equals("*")) {
                    throw new IllegalArgumentException();
                }
                int value1 = postStack.pop();
                int value2 = postStack.pop();
                // Cases for each operant
                switch (array[i]) {
                    case plus: {
                        postStack.push(value2 + value1);
                        break;
                    }
                    case minus: {
                        postStack.push(value2 - value1);
                        break;
                    }
                    case divide: {
                        postStack.push(value2 / value1);
                        break;
                    }
                    case multiply: {
                        postStack.push(value2 * value1);
                        break;
                    }
                }
            }
            return postStack.pop();
        }
    }
}