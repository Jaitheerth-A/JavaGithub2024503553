import java.util.*;

public class finepayment {

    // Enum for member types
    enum Type {
        UG, UNDERGRADUATE, POSTGRADUATE, PG, SCHOLARS, STAFF
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of borrowed days: ");
        int a = sc.nextInt();
        sc.nextLine();  // Consume newline

        System.out.print("Enter position: ");
        String post = sc.nextLine();
        post = post.replaceAll(" ", "");  // Remove spaces

        Type p;
        try {
            p = Type.valueOf(post.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Error!! Invalid choice");
            sc.close();
            return;
        }

        Library std = null;

        switch (p) {
            case UG:
            case UNDERGRADUATE:
                std = new UG(a);
                break;
            case PG:
            case POSTGRADUATE:
            case SCHOLARS:
                std = new PG(a);
                break;
            case STAFF:
                std = new Staff(a);
                break;
            default:
                System.out.println("Error!! Invalid choice");
                sc.close();
                return;
        }

        std.display();
        sc.close();
    }
}

class Library {
    int day;
    int fine;
    int finedays;

    Library() {}

    Library(int day) {
        this.day = day;
    }

    void display() {
        System.out.println("Number of days late: " + day);
        System.out.println("Total Fine: " + fine);
    }

    int calc() {
        System.out.println("Predefined calc() method not overridden");
        return 0;
    }
}

class UG extends Library {
    UG(int day) {
        super(day);
    }

    @Override
    void display() {
        calc();
        System.out.println("UG Student Fine Details:");
        super.display();
    }

    @Override
    int calc() {
        finedays = Math.max(0, day - 15);
        fine = finedays >= 10 ? ((finedays - 10) * 10 + (10 * 5)) : finedays * 5;
        return fine;
    }
}

class PG extends Library {
    PG(int day) {
        super(day);
    }

    @Override
    void display() {
        calc();
        System.out.println("PG Student Fine Details:");
        super.display();
    }

    @Override
    int calc() {
        finedays = Math.max(0, day - 30);
        fine = finedays >= 10 ? ((finedays - 10) * 10 + (10 * 5)) : finedays * 5;
        return fine;
    }
}

class Staff extends Library {
    Staff(int day) {
        super(day);
    }

    @Override
    void display() {
        calc();
        System.out.println("STAFF Fine Details:");
        super.display();
    }

    @Override
    int calc() {
        finedays = Math.max(0, day - 90);
        fine = finedays * 10;
        return fine;
    }
}