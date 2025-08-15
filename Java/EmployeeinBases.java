public class EmployeeinBases {
    private int employeeId;
    private String name;
    private boolean isPermanent;

    // Constructor
    public EmployeeinBases(int employeeId, String name, boolean isPermanent) {
        this.employeeId = employeeId;
        this.name = name;
        this.isPermanent = isPermanent;
    }

    // Method to display employee details in different formats
    public void displayEmployeeDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Is Permanent: " + isPermanent);
        System.out.println("Employee ID (Decimal): " + employeeId);
        System.out.println("Employee ID (Binary): " + Integer.toBinaryString(employeeId));
        System.out.println("Employee ID (Hexadecimal): " + Integer.toHexString(employeeId));
    }

    // Main method to test
    public static void main(String[] args) {
        EmployeeinBases emp1 = new EmployeeinBases(12345, "Arun", true);
        emp1.displayEmployeeDetails();
        System.out.println("--------------------");
        EmployeeinBases emp2 = new EmployeeinBases(255, "Bala", false);
        emp2.displayEmployeeDetails();
    }
}