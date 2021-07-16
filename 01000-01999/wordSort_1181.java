package p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class wordSort_1181 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> words = new ArrayList<String>();
		for(int i=0; i<N; i++) words.add(br.readLine());
		HashSet<String> temp = new HashSet<String>(words);
		words = new ArrayList<String>(temp);
		Collections.sort(words, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	        	if(s1.length() > s2.length()) return 1;
	        	else if (s1.length() < s2.length()) return -1;
	        	else {
	        		int i=0;
	        		while(i<s1.length()) {
	        			if(s1.charAt(i)>s2.charAt(i)) return 1;
		        		else if(s1.charAt(i) < s2.charAt(i)) return -1;
	        			i++;
	        		}
	        	}
	        	return 0;
	        }
		});
		for (String str : words) {
	        System.out.println(str);
	    }
	}
}
