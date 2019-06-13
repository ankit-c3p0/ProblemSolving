package test;

public class AnagramCheck {

	static class Word {
		String str;
		int index;
		
		public Word(String str, int index) {
			this.str = str;
			this.index = index;
		}
	}

	class WordArray {
		
		Word[] wordArr; 
		int size;
		
		public WordArray(String[] arr, int size) {
			
			this.size = size;
			wordArr = new Word[size];
			
			for(int i=0; i<size; i++) {
				
			}
			
			
		}
		
	}
}
