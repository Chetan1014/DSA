import java.util.Arrays;

public class MinCapacityToShipGoodsInDdays {
    public static int findMinCapacity(int[] arr, int days) { // arr is always sorted
        int minCap = arr[arr.length-1];
        int maxCap = Arrays.stream(arr).sum();
        while (minCap <= maxCap) {
            int capacity = (minCap+maxCap)/2;
            int noOfDays = findNoOfDays(arr, capacity);
            if (noOfDays <= days) {
                maxCap = capacity-1;
            } else {
                minCap = capacity+1;
            }
        }
        return minCap;
    }

    private static int findNoOfDays(int[] arr, int capacity) {
        int days = 1;
        int load = 0;
        for (int i = 0; i < arr.length; i++) {
            if (load + arr[i] > capacity) {
                days++;
                load = arr[i];
            } else {
                load+=arr[i];
            }
        }
        return days;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int cap = findMinCapacity(arr, days);
        System.out.println(cap);
    }
}
