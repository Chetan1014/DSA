public class MaxConsecutiveOnes {
    public static int getMaxConsOnes(int[] arr, int k) {
        int l = 0, r = 0, maxLen = 0, zeros = 0;
        while (r < arr.length) {
            if (arr[r] == 0) {
                zeros++;
            }
            if (zeros > k) {
                zeros--;
                l++;
            }
            if (zeros <= k) {
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,0};
        int k = 3;
        System.out.println(getMaxConsOnes(arr, k));
    }
}
