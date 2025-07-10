public class MaxLenOf1sByReplacingK0s {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1}; // Example array
        int k = 2; // Number of 0s we can replace
        int l = 0, r = 0, maxLength = 0, zeroCount = 0;
        while (r < arr.length) {
            if (arr[r] == 0) {
                zeroCount++;
            }
           if (zeroCount > k) {
                if (arr[l] == 0) {
                    zeroCount--;
                }
                l++;
           }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        System.out.println("Maximum length of 1s by replacing " + k + " 0s: " + maxLength);
    }
}
