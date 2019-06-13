package sorting;

public class QuickSort {

	static int partition(int[] arr, int p, int r) {
		
		int x = arr[r];
		int i = p-1;
		
		for (int j=p; j<=r-1; j++) {
			if(arr[j] <= x) {
				i = i+1;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = temp;
		return i+1;
	}
	
	static void sort(int[] arr, int p, int r) {
		if(p<r) {
			int q = partition(arr, p, r);
			sort(arr, p, q-1);
			sort(arr, q+1, r);
		}
	}
	
	public static void main(String[] args) {
		
		int[] a = {4,1,9,7,2,5};
		sort(a, 0, a.length-1);
		for(int d: a) {
			System.out.println(d);
		}
		
	}
}
