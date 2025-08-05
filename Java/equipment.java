import java.util.*;

class Purchase {
    Purchase() {
        // Quantity of items for Women (0) and Men (1)
        int[][] quantity = {
            {11, 35, 12},  // Women
            {14, 45, 18}   // Men
        };

        // Prices of Bat, Ball, and Sports Uniform respectively
        int[] price = {2000, 100, 1000};

        // Total cost for each team
        int[] totalCost = new int[2]; // 0 for Women, 1 for Men

        // Team names for display
        String[] teams = {"Women", "Men"};
        String[] items = {"Bat", "Ball", "Sports Uniform"};

        // Calculating total cost for each team
        for (int team = 0; team < 2; team++) {
            System.out.println("\n" + teams[team] + " Team Equipment Costs:");
            for (int item = 0; item < 3; item++) {
                int itemCost = quantity[team][item] * price[item];
                System.out.println(items[item] + ": " + quantity[team][item] + " × ₹" + price[item] + " = ₹" + itemCost);
                totalCost[team] += itemCost;
            }
            System.out.println("Total Cost for " + teams[team] + " Team: ₹" + totalCost[team]);
        }
    }
}

public class Equipment {
    public static void main(String[] args) {
        new Purchase();
    }
}