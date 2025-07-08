public class SubArrayScore {
    public static int countSubArrays(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j =0;
        int sum = 0;
        int couunt = 0;
        while (j<n) {
            sum+=arr[j];
            while (i<=j && sum * (j-i+1) >= k) {
                sum-=arr[i];
                i++;
            }
            if (sum * (j-i+1) < k) {
                couunt+=j-i+1;
            }
            j++;
        }
        return couunt;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,3,5};
        int k = 10;
        System.out.println(countSubArrays(arr, k));
    }
}
