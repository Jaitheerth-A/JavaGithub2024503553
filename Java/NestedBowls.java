import java.util.*;

class NestedBowls {
    public static void main(String[] args) {
      
        int[][] bowls = {
            {2, 5}, {4, 3}, {3, 7}, {5, 8}, {9, 6}, {11, 11}
        };

        System.out.println("Maximum nested bowls: " + maxNestedBowls(bowls));
    }

    public static int maxNestedBowls(int[][] bowls) {
        Arrays.sort(bowls, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        ArrayList<Integer> dp = new ArrayList<>();
        for (int[] bowl : bowls) {
            int height = bowl[1];
            int idx = Collections.binarySearch(dp, height);
            if (idx < 0) idx = -(idx + 1);
            if (idx == dp.size()) {
                dp.add(height);
            } else {
                dp.set(idx, height);
            }
        }
        return dp.size();
    }
}
