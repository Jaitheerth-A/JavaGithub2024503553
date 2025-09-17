// Parent Class
class Parent {
    int parentValue;

    // Parameterized constructor
    public Parent(int val) {
        parentValue = val;
    }
}

// Child Class derived from Parent
class Child extends Parent {
    int childValue;

    // Child class constructor
    public Child(int childVal) {
        super(100);  // Call parent constructor with a value
        childValue = childVal;
    }

    public void displayValues() {
        // Access parent class variable directly
        System.out.println("Parent Value (inherited): " + parentValue);
        System.out.println("Child Value: " + childValue);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Child obj = new Child(50);
        obj.displayValues();
    }
}
// Parent Class
class Parent2 {
    int parentValue;

    // Default constructor
    public Parent2() {
        parentValue = 100;  // Initialize parent variable
    }
}

// Child Class derived from Parent
class Child2 extends Parent2{
    int childValue;

    // Default constructor
    public Child2() {
        // Automatically calls super() by default
        childValue = 50;
    }

    public void displayValues() {
        // Access parent class variable directly
        System.out.println("Parent Value (inherited): " + parentValue);
        System.out.println("Child Value: " + childValue);
    }
}


class InheritanceDemoNoArgs {
    public static void main(String[] args) {
        Child2 obj = new Child2();
        obj.displayValues();
    }
}


// Parent Class
class Parent0 {
    int parentValue;

    // Default constructor
    public Parent0() {
        parentValue = 0;  // Default initialization
    }

    // Parameterized constructor
    public Parent0(int val) {
        parentValue = val;
    }
}

// Child Class derived from Parent
class Child0 extends Parent0 {
    int childValue;

    // Constructor that uses super to initialize parent class member
    public Child0(int parentVal, int childVal) {
        super(parentVal);  // Explicitly initialize parent variable
        childValue = childVal;
    }

    public void displayValues() {
        System.out.println("Parent Value (initialized using super): " + parentValue);
        System.out.println("Child Value: " + childValue);
    }
}

class SuperKeywordDemo {
    public static void main(String[] args) {
        Child0 obj = new Child0(200, 50);
        obj.displayValues();
    }
}

// Grandparent Class
class Grandparent {
    public Grandparent() {
        System.out.println("Grandparent Constructor called");
    }
}

// Parent Class (inherits Grandparent)
class Parent1 extends Grandparent {
    public Parent1() {
        System.out.println("Parent Constructor called");
    }
}

// Child Class (inherits Parent)
class Child1 extends Parent1 {
    public Child1() {
        System.out.println("Child Constructor called");
    }
}

class ConstructorOrderDemo {
    public static void main(String[] args) {
        System.out.println("Creating Child Object:");
       // Child1 obj = new Child1();
    }
}