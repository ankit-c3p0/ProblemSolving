package skillenza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ObesityController {

	public static List<List<Integer>> permute(int[] nums) {
	    List<List<Integer>> result = new ArrayList<>();
	    helper(0, nums, result);
	    return result;
	}
	 
	private static void helper(int start, int[] nums, List<List<Integer>> result){
	    if(start==nums.length-1){
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int num: nums){
	            list.add(num);
	        }
	        result.add(list);
	        return;
	    }
	 
	    for(int i=start; i<nums.length; i++){
	        swap(nums, i, start);
	        helper(start+1, nums, result);
	        swap(nums, i, start);
	    }
	}
	 
	private static void swap(int[] nums, int i, int j){
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
	
	
	public static int caloriesCalculator(List<Integer> kmList) {
		
		int numDays = kmList.size();
		int prevDayKm = 0, totalCalories = 0, kmCovered = 0;
		for (Integer km: kmList) {
			totalCalories += 2*(kmCovered)+km;
			kmCovered+=km;
		}
		return totalCalories;
	}
	
	public static int caloriesCalculator(int[] kmArray) {
		
		int numDays = kmArray.length;
		int totalCalories = 0, milesCovered = 0;
		for(int i=0; i<numDays; i++) {
			
			totalCalories += 2*(milesCovered) + kmArray[i]; 
			milesCovered += kmArray[i];
		}
		return totalCalories;
	}
	
	static int[] reverse(int a[]) 
    { 
        int[] b = new int[a.length]; 
        int j = a.length; 
        for (int i = 0; i < a.length; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        } 
        return b;
    } 
	
	private static Entry<Integer, List<Integer>> getMaxCaloriesBurnt(int[] kms) {
		
		List<List<Integer>> cals = permute(kms);
		Map<Integer, List<Integer>> calorieMap = new HashMap<>();

		for(List<Integer> kmPerm : cals) {
			
			int calorie = caloriesCalculator(kmPerm);
			System.out.println(calorie);
			calorieMap.put(calorie, kmPerm);
		}
		
		Map<Integer, List<Integer>> sortedCalMap = new TreeMap<>(Collections.reverseOrder());
		sortedCalMap.putAll(calorieMap);
		
		Set<Entry<Integer, List<Integer>>> entrySet = sortedCalMap.entrySet();
		System.out.println(sortedCalMap);
		
		return entrySet.iterator().next();
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			int numTests, numInputs;
			String numLine;
			int inputs = 0;
			List<String []> inputlist = new ArrayList<>();
			while(sc.hasNext()) {
				numTests = sc.nextInt();
				for(int z = 0; z<numTests; z++) {
					numInputs = sc.nextInt();
					while (inputs != numInputs ) {
						numLine = sc.nextLine();
						inputlist.add(numLine.split(" "));
						inputs++;
					}
				}
				for(String[] ip: inputlist) {
					int[] result = new int[ip.length];
					for (int k = 0; k < ip.length; k++) {
						result[k] = Integer.parseInt(ip[k]);
					}
					getMaxCaloriesBurnt(result);
				}
				
			}
		}finally {
			sc.close();
		}
	}
}
