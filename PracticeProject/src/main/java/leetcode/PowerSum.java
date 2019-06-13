package leetcode;

public class PowerSum {
	
	static int power(int num, int n) {
		if(n==0)
			return 1;
		if(n%2==0)
			return power(num, n/2) * power(num, n/2);
		else 
			return num*power(num, n/2) * power(num, n/2);
	}
	
	static int checkPower(int x, int n, int curr_num, int curr_sum) {
		
		int results = 0;
		int p = power(curr_num, n);
		while (p+curr_sum < x) {
			results+=checkPower(x, n, curr_num+1, p+curr_sum);
			curr_num++;
			p=power(curr_num, n);
		}
		if(p+curr_sum == x) {
			results++;
		}
		return results;
	}
	
	public static void main(String[] args) {
		int x=100, n=2;
		System.out.println(checkPower(x, n, 1, 0));
	}

}
