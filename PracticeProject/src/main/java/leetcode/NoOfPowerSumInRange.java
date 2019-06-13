package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoOfPowerSumInRange {

	List<Integer> powers = new ArrayList<>();
	Set<Integer> squares = new HashSet<>();
	
	int N = 5000000;
	
	void computePower() {
		
		for(int i=2; i<N; i++) {
			squares.add(i*i);
			
			if(squares.contains(i)) {
				continue;
			}
			
			int tmp =1;
			
			while(i*i<=Integer.MAX_VALUE/tmp) {
				tmp*=(i*i);
				
				squares.add(tmp);
			}
		}

		for(int j: squares) {
			powers.add(j);
		}
	}
	
	/*int getPowers(int L, int R) {
		
		double pSq = Math.floor(Math.sqrt(R))-Math.floor(Math.sqrt(L-1));
		
		
//		return pSq;
	}*/
}
