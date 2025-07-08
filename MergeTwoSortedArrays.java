import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static int[] mergeArrays(int[] arr1, int[] arr2, int n, int m) {
        int left = n-1;
        int right = 0;
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        arr1 = new int[]{arr1[n + m]};
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,6,7,8};
        int[] arr2 = {3,4,5,9};
        System.out.println(mergeArrays(arr1, arr2, arr1.length, arr2.length).toString());
    }
}
