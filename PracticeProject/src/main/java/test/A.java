package test;

class A 
{
public int c = 10;
public int d = 10;

static {
	System.out.println("In A static block");
}
public A() {
System.out.println("Impicit call to superclass constructor. In A constructor");
System.out.println("The value of c: " + c);
System.out.println("The value of d: " + d);
printc();
c = 15;
}

public void printc() {
System.out.println("In A.printc - we should never get here...");
System.out.println("In A.printc. c is: " + c);
System.out.println("In A.printc. d is: " + d);
}
}