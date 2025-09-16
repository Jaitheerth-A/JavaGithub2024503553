import java.util.Scanner;

class Student {
    String sname;
    long rollNo;
    String university;
    String campus;
    int internalScore1, internalScore2, internalScore3;
    int endSemScore1, endSemScore2, endSemScore3;

    public Student(String sname, long rollNo, String university, String campus) {
        this.sname = sname;
        this.rollNo = rollNo;
        this.university = university;
        this.campus = campus;
    }

    public void inputScores(Scanner sc) {
        System.out.print("Enter internal scores for 3 courses (space-separated): ");
        internalScore1 = sc.nextInt();
        internalScore2 = sc.nextInt();
        internalScore3 = sc.nextInt();
        System.out.print("Enter end semester scores for 3 courses (space-separated): ");
        endSemScore1 = sc.nextInt();
        endSemScore2 = sc.nextInt();
        endSemScore3 = sc.nextInt();
    }

    public void computeAndDisplay() {
        // To be overridden in subclasses
    }

    protected String computeGrade(double totalScore) {
        if (totalScore >= 90)
            return "S";
        else if (totalScore >= 80)
            return "A+";
        else if (totalScore >= 70)
            return "A";
        else if (totalScore >= 60)
            return "B+";
        else if (totalScore >= 50)
            return "B";
        else
            return "U";
    }
}

class FullTime extends Student {
    public FullTime(String sname, long rollNo, String university, String campus) {
        super(sname, rollNo, university, campus);
    }

    @Override
    public void computeAndDisplay() {
        System.out.println("\nFull Time Student: " + sname + ", Roll No: " + rollNo);
        for (int i = 1; i <= 3; i++) {
            int internal = getInternalScore(i);
            int endSem = getEndSemScore(i);
            double totalScore = internal * 0.4 + endSem * 0.6;
            String grade = computeGrade(totalScore);
            System.out.printf("Course %d: Total Score = %.2f, Grade = %s%n", i, totalScore, grade);
        }
        System.out.println("----------------------------------------");
    }

    private int getInternalScore(int courseNo) {
        switch (courseNo) {
            case 1: return internalScore1;
            case 2: return internalScore2;
            case 3: return internalScore3;
        }
        return 0;
    }

    private int getEndSemScore(int courseNo) {
        switch (courseNo) {
            case 1: return endSemScore1;
            case 2: return endSemScore2;
            case 3: return endSemScore3;
        }
        return 0;
    }
}

class PartTime extends Student {
    public PartTime(String sname, long rollNo, String university, String campus) {
        super(sname, rollNo, university, campus);
    }

    @Override
    public void computeAndDisplay() {
        System.out.println("\nPart Time Student: " + sname + ", Roll No: " + rollNo);
        for (int i = 1; i <= 3; i++) {
            int internal = getInternalScore(i);
            int endSem = getEndSemScore(i);
            double totalScore = internal * 0.5 + endSem * 0.5;
            String grade = computeGrade(totalScore);
            System.out.printf("Course %d: Total Score = %.2f, Grade = %s%n", i, totalScore, grade);
        }
        System.out.println("----------------------------------------");
    }

    private int getInternalScore(int courseNo) {
        switch (courseNo) {
            case 1: return internalScore1;
            case 2: return internalScore2;
            case 3: return internalScore3;
        }
        return 0;
    }

    private int getEndSemScore(int courseNo) {
        switch (courseNo) {
            case 1: return endSemScore1;
            case 2: return endSemScore2;
            case 3: return endSemScore3;
        }
        return 0;
    }
}

public class UniversityRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine();  // Consume leftover newline

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Is the student Full-time (F) or Part-time (P)? ");
            String type = sc.nextLine().trim().toUpperCase();
            
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Roll Number: ");
            long rollNo = sc.nextLong();
            sc.nextLine();  // Consume leftover newline
            
            System.out.print("Enter University: ");
            String university = sc.nextLine();
            
            System.out.print("Enter Campus: ");
            String campus = sc.nextLine();
            
            if (type.equals("F")) {
                students[i] = new FullTime(name, rollNo, university, campus);
            } else {
                students[i] = new PartTime(name, rollNo, university, campus);
            }
            
            students[i].inputScores(sc);
        }

        System.out.println("\n\n===== STUDENT RESULTS =====");
        for (Student s : students) {
            s.computeAndDisplay();
        }

        sc.close();
    }
}