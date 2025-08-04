import java.util.*;

class Worker {
    static float hourlyWage;
    private final int empno;
    private final int hours;
    private final double pay;

    Worker(int empno, int hours) {
        this.empno = empno;
        this.hours = hours;
        this.pay = calculatePay();
    }

    private double calculatePay() {
        if (hours <= 40) {
            return hours * hourlyWage;
        } else {
            int overtime = hours - 40;
            return 40 * hourlyWage + overtime * 1.5 * hourlyWage;
        }
    }

    void display() {
        System.out.printf("%d\t\t%.2f\t\t%d\n", empno, pay, hours);
    }

    static void setHourlyWage(Scanner sc) {
        while (true) {
            System.out.print("Enter hourly wage: ");
            float hw = sc.nextFloat();
            if (hw < 0) {
                System.out.println("Hourly wage cannot be negative!");
                continue;
            }
            hourlyWage = hw;
            break;
        }
    }
}

class Wage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Worker.setHourlyWage(sc);

        Worker[] workers = new Worker[100]; // Max 100 workers
        int count = 0;

        while (true) {
            System.out.print("\nEnter employee number: ");
            int empno = sc.nextInt();

            System.out.print("Enter number of hours worked this week: ");
            int hours = sc.nextInt();

            if (count < workers.length) {
                workers[count++] = new Worker(empno, hours);
            } else {
                System.out.println("Maximum number of employees reached.");
                break;
            }

            while (true) {
                System.out.print("Do you want to enter another employee? (yes/no): ");
                String choice = sc.next().trim().toLowerCase();

                if (choice.equals("yes") || choice.equals("y")) {
                    continue; // Continue to outer loop
                } else if (choice.equals("no") || choice.equals("n")) {
                    break; // Break inner loop
                } else {
                    System.out.println("Invalid input. Please type 'yes' or 'no'.");
                    continue; // Invalid → continue inner loop
                }
            }
            break; // User typed "no" → exit outer loop
        }

        // Display all worker data
        System.out.println("\nEMPLOYEE\tPAY\t\tHOURS");
        for (int i = 0; i < count; i++) {
            workers[i].display();
        }

        sc.close();
    }
}