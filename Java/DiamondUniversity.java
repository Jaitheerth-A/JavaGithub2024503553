interface University { //Basre interface
    default void info() {
        System.out.println("Information from University");
    }
}

// Derived interface 1
interface Teacher extends University {
    default void info() {
        System.out.println("Information from Teacher");
    }
}

// Derived interface 2
interface Student extends University {
    default void info() {
        System.out.println("Information from Student");
    }
}

// Class implementing both Teacher and Student - Diamond Ambiguity occurs
public class DiamondUniversity implements Teacher, Student {

    // Must override info() to resolve ambiguity
    @Override
    public void info() {
        // Choose which interface version to use
        Teacher.super.info(); // or Student.super.info()
    }

    public static void main(String[] args) {
        DiamondUniversity obj = new DiamondUniversity();
        obj.info();
    }
}
