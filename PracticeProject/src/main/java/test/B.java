package test;

class B extends A 
{
// variables are not overridden, but hidden...
public int d = 10;
private int e = 5;

static {
System.out.println("In B static initializer");
}

{
System.out.println("In B instance initializer");
System.out.println("c is not set, c is : " + c); 
System.out.println("The value of d is: " + d);
System.out.println("The value of e is: " + e);
c = 20;
d = 20;
System.out.println("c is set to 20, now c is : " + c);
System.out.println("d is set to 20, now d is : " + d);
}

public B() {
// Here we have an implicit call to super();
System.out.println("In B constructor");
System.out.println("c is not set set, c is : " + c); 
System.out.println("d is not set set, d is : " + d); 
c = 30;
d = 30;
System.out.println("c is set to 30, now c is : " + c);
System.out.println("d is set to 30, now c is : " + d);
}

public void printc() {
System.out.println("In B.printc");
System.out.println("In B.printc. c is: " + c);
System.out.println("In B.printc. d is: " + d);
System.out.println("in B.printc. e is: " + e);
}

public static void main(String[] args) {
System.out.println("Start of static main");
B b = new B();
System.out.println("End of static main"); 
}
}