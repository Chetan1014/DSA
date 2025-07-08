public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,0,2};
        int l = 0;
        int h = arr.length-1;
        int min = Integer.MAX_VALUE;
        while (l<=h) {
            int m = (l+h)/2;
            if (arr[m] < min) {
                min = arr[m];
            }
            else if (arr[m] < arr[m+1]) {
                min = Math.min(min, arr[m+1]);
                h = m -1;
            }
            else {
                min = Math.min(min, arr[l]);
                l = m+1;
            }
        }
        System.out.println(min);
    }
}
