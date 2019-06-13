package sorting;

public class MergeSort {

	private static void merge(int[] arr, int p, int q, int r) {
		
		int n1 = q-p;
		int n2 = r-q;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i=1; i<n1; i++) {
			left[i] = arr[p+i];
		}
		
		for(int j=1; j<n2; j++) {
			right[j] = arr[r+1+j];
		}
		
		left[n1]= Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		
		int i=0,j=0;
		for(int k=p; k<r;k++) {
			
			if(left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
		}
	}
	
	public static void mergeSort(int arr[], int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q, r);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {5,12,4,7,1,19,-4,2};
		mergeSort(arr, 0, arr.length);
		for(int dig: arr) {
			System.out.println(dig);
		}
	}
}
