import java.util.Scanner;

public class register {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get number of participants in quiz
        System.out.print("Enter number of quiz participants: ");
        int quizCount = sc.nextInt();
        sc.nextLine(); // consume newline
        String[] quiz = new String[quizCount];
        System.out.println("Enter names of quiz participants:");
        for (int i = 0; i < quizCount; i++) {
            quiz[i] = sc.nextLine();
        }

        // Get number of participants in paper presentation
        System.out.print("Enter number of paper presentation participants: ");
        int paperCount = sc.nextInt();
        sc.nextLine();
        String[] paper = new String[paperCount];
        System.out.println("Enter names of paper presentation participants:");
        for (int i = 0; i < paperCount; i++) {
            paper[i] = sc.nextLine();
        }

        // Find and display participants registered for both
        System.out.println("\nParticipants registered for both quiz and paper presentation:");
        boolean found = false;
        for (int i = 0; i < quiz.length; i++) {
            for (int j = 0; j < paper.length; j++) {
                if (quiz[i].equalsIgnoreCase(paper[j])) {
                    System.out.println(quiz[i]);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("None");
        }

        sc.close();
    }
}