package b;

import java.util.Scanner;

public class Numberofnumber_2577 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int sum = scan.nextInt()*scan.nextInt()*scan.nextInt();
		String s = Integer.toString(sum);
		int[] number = new int[10];
		for(int i=0; i<s.length();i++)
			number[s.charAt(i)-'0']++;
		for(int i=0; i<10; i++)
			System.out.println(number[i]);
	}
}
