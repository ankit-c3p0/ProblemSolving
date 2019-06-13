package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] temp= br.readLine().split(" ");
            int L = Integer.parseInt(temp[0]);
            int R = Integer.parseInt(temp[1]);
            int out_ = PowerulNumbers(R, L);
            System.out.println(out_);
         }

         wr.close();
         br.close();
    }
	
	
    static int PowerulNumbers(int R, int L){
        // Write your code here
    	
    	int count=0;
    	for (int i=L; i<=R; i++) {
    		String numStr = String.valueOf(i);
    		char numStrArr[] = numStr.toCharArray(); 
    		int j =0;
    		Set<Character> set = new HashSet<>();
    		while(j < numStrArr.length) {
    			set.add(numStrArr[j]);
    			j++;    			
    		}
    		if(set.size() < 3) {
    			continue;
    		} else {
    			count++;
    		}
    	}
    
    	return count;
    }
    
    static void printUnique(int l, int r) 
    { 
        // Start traversing the numbers 
        for (int i=l ; i<=r ; i++) 
        { 
            int num = i; 
            boolean visited[] = new boolean[10]; 
       
            // Find digits and maintain its hash 
            while (num != 0) 
            { 
                // if a digit occcurs more than 1 time 
                // then break 
                if (visited[num % 10]) 
                    break; 
       
                visited[num%10] = true; 
       
                num = num/10; 
            } 
       
            // num will be 0 only when above loop 
            // doesn't get break that means the 
            // number is unique so print it. 
            if (num == 0) 
                System.out.print(i + " "); 
        } 
    } 
    
}