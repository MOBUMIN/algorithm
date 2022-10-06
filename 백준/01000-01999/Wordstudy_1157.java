package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Wordstudy_1157 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alphabet = new int[26];
		String input = br.readLine();
		input = input.toUpperCase();
		for(int i=0; i<input.length();i++) {
			alphabet[(int)input.charAt(i)-65]++;
		}
		int max = 0;
		for(int i=1; i<26; i++)
			if(alphabet[max] < alphabet[i])
				max = i;
		Arrays.sort(alphabet);
		if(alphabet[24]==alphabet[25]) System.out.println("?");
		else System.out.println((char)(max+65));
	}
}
