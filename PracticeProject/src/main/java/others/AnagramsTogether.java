package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramsTogether {

	public static void printAnagramsTogether(String[] arr) {
		
		HashMap<Integer, List<String>> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			
			String word = arr[i];
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String newWord = new String(letters);
			
			int n = newWord.hashCode();
			if(map.containsKey(n)) {
				List<String> words = map.get(n);
				words.add(word);
				map.put(n, words);
			} else {
				List<String> words = new ArrayList<>();
//				words.add(word);
				map.put(n, words);
			}
		}
		
		for(Integer i:map.keySet()) {
			List<String> values = map.get(i);
			if(values.size()>1) 
				System.out.print(values);
		}
	}
	
	public static void main(String[] args) 
    { 
  
        // Driver program 
        String arr[] = { "cat", "dog", "tac", "god", "act" }; 
        printAnagramsTogether(arr); 
    }
}
