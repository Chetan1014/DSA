import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You have n tasks and m workers. Each task has a strength requirement stored in a 0-indexed integer array tasks,
 * with the ith task requiring tasks[i] strength to complete. The strength of each worker is stored in a 0-indexed integer array workers,
 * with the jth worker having workers[j] strength.
 * Each worker can only be assigned to a single task and must have a strength greater than or equal to the task's strength requirement (i.e., workers[j] >= tasks[i]).
 *
 * Additionally, you have pills magical pills that will increase a worker's strength by strength.
 * You can decide which workers receive the magical pills, however, you may only give each worker at most one magical pill.
 *
 * Given the 0-indexed integer arrays tasks and workers and the integers pills and strength, return the maximum number of tasks that can be completed.
 */
public class MaxNoOfTasks {
    /**
     * tasks = [10,15,30], people = [0,10,10,10,10], pills = 3, strength = 10
     * @param tasks
     * @param people
     * @param pills
     * @param strength
     * @return
     */
    public static int getMaxTasks(int[] tasks, int[] people, int pills, int strength) {
        int n = tasks.length;
        int m = people.length;
        int high = Math.min(n,m);
        int low = 0;
        int taskCompletd = 0;
        while (low<=high) {
            int mid = low + (high - low)/2;
            if (getTaskcompletionStatus(mid, people, tasks, pills,strength)) {
                taskCompletd = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return taskCompletd;
    }

    private static boolean getTaskcompletionStatus(int mid, int[] people, int[] tasks, int pills, int strength) {
        int n = people.length;
        int j = n-1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = mid-1; i <=0; i++) {
            while (j>n-mid && people[j] + strength >= tasks[i]) {
                deque.addFirst(people[j]);
                j--;
            }
            if (deque.isEmpty()) {
                return false;
            }
            if (deque.peekLast()>=tasks[i]) {
                deque.pollLast();
            } else {
                if (pills == 0) {
                    return false;
                }
            }
            pills--;
            deque.pollFirst();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] people = {0,2,1};
        int s = (int) 4.0;
    }
}
