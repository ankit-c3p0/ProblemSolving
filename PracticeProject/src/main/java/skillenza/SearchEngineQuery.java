package skillenza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SearchEngineQuery {
	
	public static Map<String, Integer> getCountMap(List<String> searchWordList) {
		
		int count = 0;
		Map<String, Integer> wordCountMap = new TreeMap<>();
		for(String word: searchWordList) {
			if(!wordCountMap.containsKey(word)) {
				wordCountMap.put(word, count);
			} else {
				wordCountMap.put(word, wordCountMap.get(word)+1);
			}
		}
		Map<String, Integer> sortedMap = wordCountMap
		        .entrySet()
		        .stream()
		        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
		                LinkedHashMap::new));
		return sortedMap;
	}
	
	public static void processWordList(List<String> searchWordList) {
		
		int topCount=0;
		for(String word: searchWordList) {
			if(word.startsWith("top")) {
				topCount = Integer.parseInt(word.substring(3));
			}
		}
		Map<String, Integer> countMap = getCountMap(searchWordList);
//		System.out.println(countMap);
		
		Set<String> searchQueryArr = countMap.keySet();
		List<String> searchList = new ArrayList<>(searchQueryArr);
		String searchQueryString = new String();
		for(int i=0; i<topCount; i++) {
			searchQueryString += searchList.get(i) + " ";
		}
		System.out.println();
		System.out.print(searchQueryString.substring(0, searchQueryString.length()-1));
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numTests, numInputs;
		List<String> inputWordList = null;
		try {
			while (sc.hasNext()) {
				
				numTests = sc.nextInt();
//				System.out.println("Total Tests:" + numTests);
				for(int i=0; i<numTests; i++) {
					String nextIp = sc.next();
					numInputs = Integer.parseInt(nextIp);
					inputWordList = new ArrayList<>();
					for(int j=0; j<numInputs+1; j++) {
						String nextLine = sc.nextLine();
						if(!nextLine.startsWith("top")) {
							inputWordList.add(nextLine);
						} else {
							String topWord = nextLine;
							String[] topWordArr = topWord.split(" ");
							inputWordList.add(topWordArr[0]+topWordArr[1]);
						}
					}
					inputWordList.remove(0);
//					System.out.println(inputWordList);
					processWordList(inputWordList);
					
				}
			}
		} finally {
			sc.close();
		}
		
	}

}
