public class LargestSubArrayWithSumK {
    public static int getMaxLength(int[] arr, int k) { // only for +ve and 0
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int sum = arr[0];
        while (j < arr.length) {
            while(i<=j && sum > k) {
                sum-=arr[i];
                i++;
            }
            if (sum == k) {
                maxLength = Math.max(maxLength, (j-i) + 1);
            }
            j++;
            if (j<arr.length) sum+=arr[j];
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,0,0,5};
        int k = 5;
        int length = getMaxLength(arr, k);
        System.out.println(length);
    }
}
