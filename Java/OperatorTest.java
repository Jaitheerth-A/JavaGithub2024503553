  class A { 
int x; 
A() 
{ 
this(5);
System.out.print("A "); 
}
A(int x) 
{ System.out.print("B "); } 
} 
class OperatorTest {
    public static void main(String[] args) 
    { A obj = new A(); } 
    }
