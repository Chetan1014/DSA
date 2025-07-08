public class SearchInRotateArray {
    public static int searchArray(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n;
        while (low<=high) {                     //{7,8,9,1,2,3,4,5,6}
            int mid = (low+high)/2;
            if (arr[mid] == k) {
                return mid;
            }
            if (arr[mid] < arr [low]) {
                if (arr[mid] <= k && k <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (arr[low] <= k && k <= arr[mid]) {
                    high = mid -1;
                } else {
                    low = mid +1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int k = 1;
        System.out.println(searchArray(arr,k));
    }
}
