package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Customer implements Serializable {
	
	transient int customerId;
    String customerName;
    transient String customerSSN = "A2";
 
    // 3-arg parameterized constructor for Customer
    public Customer(int customerId, String customerName, 
            String customerSSN) {
        super();
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSSN = customerSSN;
    }
 
    // to print nicely - customer object
    @Override
    public String toString() {
        return "Customer ["
                + "customerId=" + customerId 
                + ", customerName=" + customerName 
                + ", customerSSN=" + customerSSN 
                + "]";
    }
    
    
    private void writeObject(ObjectOutputStream oos) throws Exception{
    	try {
			oos.defaultWriteObject();
			
//			oos.writeObject(customerId);
//			oos.writeObject(customerSSN);
			
			int temId=customerId+333;
			String temSSN ="test"+customerSSN;
			
			oos.writeInt(temId);
			oos.writeObject(temSSN);
			
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void readObject(ObjectInputStream ois) throws Exception {
    	
    	try {
			ois.defaultReadObject();
			
			customerId = ois.readInt()-333;
			customerSSN = ois.readObject().toString().substring(4);
			
			System.out.println("###" + ois.readInt());
			System.out.println("$$$" + ois.readObject());
			
			ois.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
