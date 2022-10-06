package b;

import java.util.Scanner;

public class Max_2562 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int max =0; int idx =0;
		for(int i=1; i<10; i++) {
			int a = scan.nextInt();
			if(a>max) {
				max = a;
				idx = i;
			}
		}
		System.out.println(max+"\n"+idx);
	}
}
