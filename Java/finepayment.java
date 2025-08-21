import java.util.*;

public class finepayment {
    enum Type { UG, UNDERGRADUATE, PG, POSTGRADUATE, SCHOLARS, STAFF }

    // Removes all whitespaces (including between words)
public static String trimAllSpaces(String input) {
    return input.replaceAll("\\s+", "");
}

    static void getInfo(library[] std) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < std.length; i++) {
            int days;
            String post;
            Type type = null;
            
                    System.out.println("Enter details for student " + (i + 1) + ':');
                    System.out.print("Enter number of borrowed days: ");
                    days = sc.nextInt();
                    sc.nextLine(); // consume newline
                    while (true) {
                try {
                    System.out.print("Enter position (UG, PG, SCHOLARS, STAFF): ");
                    post = sc.nextLine().trim().toUpperCase();
                    post = trimAllSpaces(post); // Remove all whitespaces
                    type = Type.valueOf(post);
                    sc.close();
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid position! Please enter UG, PG, SCHOLARS, or STAFF.");
                }
            }
            switch (type) {
                case UG:
                case UNDERGRADUATE:
                    std[i] = new UG(days);
                    break;
                case PG:
                case POSTGRADUATE:
                case SCHOLARS:
                    std[i] = new PG(days);
                    break;
                case STAFF:
                    std[i] = new Staff(days);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        library[] std = new library[n];
        getInfo(std);
        System.out.println("\nFine details of students:");
        for (int i = 0; i < std.length; i++) {
            System.out.println("Student " + (i + 1) + ':');
            std[i].display();
        }
        sc.close();
    }
}

abstract class library {
    int day;
    int fine;
    int finedays;

    library(int day) {
        this.day = day;
    }

    void display() {
        System.out.println("Number of days late: " + day + "\nTotal Fine: Rs." + calc());
    }

    abstract int calc();
}

class UG extends library {
    UG(int day) {
        super(day);
    }

    void display() {
        System.out.println("UG student:");
        super.display();
    }

    int calc() {
        finedays = Math.max(0, day - 15);
        fine = finedays >= 10 ? (((finedays - 10) * 10 ) + 10 * 5) : finedays * 5;
        return fine;
    }
}

class PG extends library {
    PG(int day) {
        super(day);
    }

    void display() {
        System.out.println("PG student:");
        super.display();
    }

    int calc() {
        finedays = Math.max(0, day - 30);
        fine = finedays >= 10 ? (((finedays - 10) * 10 ) + 10 * 5) : finedays * 5;
        return fine;
    }
}

class Staff extends library {
    Staff(int day) {
        super(day);
    }

    void display() {
        System.out.println("STAFF:");
        super.display();
    }

    int calc() {
        finedays = Math.max(0, day - 90);
        fine = finedays * 10;
        return fine;
    }
}
