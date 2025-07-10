public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b"; // Example input
        System.out.println("Does the string match the pattern? " + isMatch(s, p));
    }

    private static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty(); // If pattern is empty, string must also be empty
        }

        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // '*' can match zero or more of the preceding element
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            // Proceed to the next character in both string and pattern
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
