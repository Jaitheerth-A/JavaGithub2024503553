//import java.util.*;

class purchase {
    purchase() {
        int[][] quantity = {
            {11, 35, 12},
            {14, 45, 18}
        };

        int[] totalCost = new int[2];
        int[] price = {2000, 100, 1000};

        String[] teams = {"Women", "Men"};
        String[] items = {"Bat", "Ball", "Sports Uniform"};

        for (int team = 0; team < 2; team++) {
            System.out.println("\n" + teams[team] + " Team Equipment Costs:");

            for (int item = 0; item < 3; item++) {
                int itemCost = quantity[team][item] * price[item];
                System.out.println(items[item] + ": " 
                    + quantity[team][item] + "x" + price[item] 
                    + " = " + itemCost);

                totalCost[team] += itemCost;
            }

            System.out.println("Total Cost for " + teams[team] + " Team: " + totalCost[team]);
        }
    }
     public static void main(String[] args) {
        new purchase();
    }
}