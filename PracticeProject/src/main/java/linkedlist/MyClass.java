package linkedlist;

import java.io.FileOutputStream;
import java.io.IOException;

class MyClass
{
    public static void main (String[] args) 
    {
        int A1[] = {1, 2, 3};
        int A2[] = {1, 2, 3};
        if (A1.equals(A2))
            System.out.println("Same");
        else
            System.out.println("Not same");
        
        
        /*Test2 [][] obj = new Test2[3][];
        System.out.println(obj[2][0].toString());
        */
        /*try 
        {
            System.out.println("Hello world ");
            throwit();
            System.out.println("try block ");
        }
        finally 
        {
            System.out.println("Finally");
        }
        */
        FileOutputStream out = null;
        try 
        {
            out = new FileOutputStream("output.out");
            out.write(125486);
        }
        catch(IOException io) 
        {
            System.out.println("Error");
        }
        finally 
        {
//            out.close();
        }
        
    }

    public static void throwit() 
    {
        throw new RuntimeException();
    }
    
    class Test2{}
}
