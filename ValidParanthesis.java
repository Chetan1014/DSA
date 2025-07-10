import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String s = "{([])}{(})"; // Example input
        System.out.println("Is the string valid? " + isValid(s));
    }

    private static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true; // An empty string is considered valid
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing bracket
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false; // Mismatched brackets
                }
            }
        }
        return stack.isEmpty(); // If stack is empty, all brackets were matched
    }
    private static boolean isMatchingPair(char top, char c) {
        return (top == '{' && c == '}') ||
               (top == '(' && c == ')') ||
               (top == '[' && c == ']');
    }
}
