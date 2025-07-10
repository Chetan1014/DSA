import java.util.LinkedList;
import java.util.Queue;
public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 0, 2},
            {1, 0, 1, 2},
            {0, 1, 2, 1}
        }; // Example grid
        System.out.println("Minimum time to rot all oranges: " + minTimeToRot(grid));
    }

    private static int minTimeToRot(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1; // Invalid grid
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        int time = 0;

        // Directions for adjacent cells (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();

        // Count fresh oranges and enqueue rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // If there are no fresh oranges, return 0
        if (freshCount == 0) {
            return 0;
        }

        // BFS to rot the oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Rot the orange
                        freshCount--;
                        queue.offer(new int[]{newX, newY});
                        rottedThisRound = true;
                    }
                }
            }

            if (rottedThisRound) {
                time++; // Increment time only if at least one orange was rotted
            }
        }

        return freshCount == 0 ? time : -1; // Return time if all oranges are rotted, otherwise -1

    }
}
