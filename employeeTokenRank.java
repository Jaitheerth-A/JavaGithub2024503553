import java.util.Scanner;
public class employeeTokenRank {
    private int empNo;
    private int overtimeHours;
    private Token token;

    public employeeTokenRank(int empNo, int overtimeHours) {
        this.empNo = empNo;
        // Enforce overtime limit
        this.overtimeHours = (overtimeHours > 8) ? 8 : overtimeHours;
        this.token = new Token();
    }

    // Nested Token class
    class Token {
        private String tokenId;
        private String rank;

        public Token() {
            generateToken();
        }

        private void generateToken() {
            String lastThreeDigits = String.format("%03d", empNo % 1000);
            rank = (overtimeHours == 8) ? "Senior" : "Junior";
            tokenId = lastThreeDigits + "-" + rank;
        }

        public String getRank() {
            return rank;
        }

        public String getTokenId() {
            return tokenId;
        }
    }

    // Method to get token info
    public void displayTokenInfo() {
        System.out.println("EmpNo: " + empNo + ", Token: " + token.tokenId + ", Rank: " + token.rank + ", Overtime Hours: " + overtimeHours);
    }

    public String getRank() {
        return token.getRank();
    }

    // Main method to demonstrate multiple employees
    public static void main(String[] args) {
        // Example array of Employee objects
        int n;
        System.out.print("Enter number of employees: ");
        Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            sc.nextLine();
            while(n <= 0) {
                System.out.print("Enter valid number of employees: ");
                n = sc.nextInt();
                sc.nextLine();
            }
       
        employeeTokenRank[] employees = new employeeTokenRank[n];
      
            for (int i = 0; i < n; i++) {
                System.out.print("Enter Employee Number for Employee " + (i + 1) + ": ");
                int empNo = sc.nextInt();
                System.out.print("Enter Overtime Hours for Employee " + (i + 1) + ": ");
                int overtimeHours = sc.nextInt();       
                employees[i] = new employeeTokenRank(empNo, overtimeHours);
            }    
        sc.close();

System.out.println("----- Employee Token and Rank Details -----");
        System.out.println("Employee Token Information:");
        for (employeeTokenRank emp : employees) {
            emp.displayTokenInfo();
        }

        System.out.println("\nEmployee Ranks:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Employee " + (i + 1) + " Rank: " + employees[i].getRank());
        }
    }
}