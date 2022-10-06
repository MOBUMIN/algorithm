package o;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldBach_6588 {
	static boolean PrimeNum[];
	static int MAX = 1000000;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrimeNum = new boolean[MAX];
		Seek();
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			FindAns(N);
		}
	}
	public static void Seek() {
		for (int i=2; i<MAX; i++) {
			if(!PrimeNum[i])
				for(int j = i*2; j<MAX; j +=i)
					PrimeNum[j] = true;
		}
		for(int i=0; i<MAX; i++)
			PrimeNum[i] = !PrimeNum[i];
	}
	public static void FindAns(int n) {
		/* Á¤´ä a, b */
		int a = 0; int b = 0;
		for(int i=3; i<=n/2; i+=2) {
			if(PrimeNum[i] && PrimeNum[n-i]) {
				a=i; b=n-i; break;
			}
		}
		if(a>0)
			System.out.println(n+ " = " + a + " + " + b);
		else System.out.println("Goldbach's conjecture is wrong.");
	}
}
