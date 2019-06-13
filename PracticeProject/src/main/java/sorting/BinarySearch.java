package sorting;

import java.util.List;

public class BinarySearch {

	public static int performBinarySearch(List<Integer> list, Integer num, int low, int high) {
		int index=-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(list.get(mid).equals(num)) {
				index = mid;
			} else if (num < list.get(mid)) {
				high = mid -1;
			} else {
				low = mid+1;
			}
		}
		return index;
	}
}
