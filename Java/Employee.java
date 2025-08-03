public class Employee {
    // Fields
    private int employeeId;
    private String name;
    private boolean isPermanent;

    // Constructor
    public Employee(int employeeId, String name, boolean isPermanent) {
        this.employeeId = employeeId;
        this.name = name;
        this.isPermanent = isPermanent;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Name       : " + name);
        System.out.println("Employee ID (Decimal): " + employeeId);
        System.out.println("Employee ID (Binary) : " + Integer.toBinaryString(employeeId));
        System.out.println("Employee ID (Hex)    : " + Integer.toHexString(employeeId).toUpperCase());
        System.out.println("Permanent Employee   : " + (isPermanent ? "Yes" : "No"));
        System.out.println("------------------------------------------");
    }

    // Main method to test
    public static void main(String[] args) {
        // Sample employees
        Employee emp1 = new Employee(101, "Alice", true);
        Employee emp2 = new Employee(202, "Bob", false);

        // Display details
        emp1.displayDetails();
        emp2.displayDetails();
    }
}