package leetcode;

public class MoveZeroes {

	public static void moveZeroes_1(int[] nums) {

		int index[] = new int[nums.length];
		int k = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				index[k += 1] = i;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (index[i] != 0) {
				System.out.println(nums[index[i]]);
			} else {
				System.out.println("0");
			}
		}
	}

	public static void moveZeroes(int[] nums) {

		int i=0;
		for(int n: nums) {
			if(n != 0) {
				nums[i++] = n;
			}
		}
		while (i<nums.length) {
			nums[i++] =0;}
		
		System.out.print("[");
		for(int j=0;j<nums.length;j++) {
			if(j==i-1) 
				System.out.print(nums[j]);
			else 
				System.out.print(nums[j] + ",");
		}
		System.out.print("]");
	}

	public static void main(String[] args) {

		int nums[] = { 0, 1, 0, 3, 12 };
		MoveZeroes.moveZeroes(nums);
		
	}

}
