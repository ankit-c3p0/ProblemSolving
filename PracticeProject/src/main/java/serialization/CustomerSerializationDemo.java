package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomerSerializationDemo {

	public static void main(String[] args) {
		
		Customer c1 = new Customer(1, "A", "A1");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		Customer object = null;
		
		try {
			fos = new FileOutputStream("customer.ser");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(c1);
			
//			oos.flush();
//			oos.close();
//			fos.close();
			
			ois = new ObjectInputStream(new FileInputStream("customer.ser"));
			 
			object = (Customer) ois.readObject();
			System.out.println(object);
			
//			ois.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.flush();
				//oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
