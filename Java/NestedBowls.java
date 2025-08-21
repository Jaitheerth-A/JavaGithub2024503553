import java.util.*;

class NestedBowls {
    public static void main(String[] args) {
        // Example input: array of bowls {length, height}
        int[][] bowls = {
            {2, 5}, {4, 3}, {3, 7}, {5, 8}, {9, 6}, {11, 11}
        };

        // Print the maximum number of nested bowls
        System.out.println("Maximum nested bowls: " + maxNestedBowls(bowls));
    }

    public static int maxNestedBowls(int[][] bowls) {
        // Sort bowls by length in ascending order
        // If lengths are the same, sort by height in descending order
        Arrays.sort(bowls, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // List to store the Longest Increasing Subsequence (LIS) of heights
        ArrayList<Integer> dp = new ArrayList<>();

        for (int[] bowl : bowls) {
            int height = bowl[1];

            // Find the position to insert this height using binary search
            int idx = Collections.binarySearch(dp, height);

            // If not found, get insertion position
            if (idx < 0) idx = -(idx + 1);

            // If the position is at the end, append the height
            if (idx == dp.size()) {
                dp.add(height);
            } else {
                // Otherwise, replace the existing height at that position
                dp.set(idx, height);
            }
        }

        // The size of dp is the maximum number of nested bowls
        return dp.size();
    }
}