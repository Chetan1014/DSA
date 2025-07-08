import java.util.HashMap;

public class LongestSubSequence {
    public static void main(String[] args) {
        String s = "abcdeafgcdb";
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            len = Math.max(len, right-left+1);
            map.put(s.charAt(right), right);
            right++;
        }
        System.out.println(len);
        System.out.println(s.substring(left, right));

    }
}
