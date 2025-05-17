package Solutions;

import java.util.List;
import java.util.Stack;

public class ValidParentheses20 {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (char i : s.toCharArray()){
            if(i == '('||i == '{'||i == '[')
                characterStack.push(i);
            else if (characterStack.isEmpty()) {
                return false;
            } else if (i == ')' && !characterStack.peek().equals('(')) {
                return false;
            }else if (i == '}' && !characterStack.peek().equals('{')) {
                return false;
            }else if (i == ']' && !characterStack.peek().equals('[')) {
                return false;
            }
            else {
                characterStack.pop();
            }
        }

        return characterStack.isEmpty();
    }
}

