package l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SeriesSum_1644 {
	static ArrayList<Integer> PN;
	static int size;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PN = new ArrayList<>();
		int N = Integer.parseInt(br.readLine()); // 목표
		/* 해당 수까지의 소수 arraylist에 때려박기 */
		for(int i=2; i<=N; i++)
			if(isPrime(i)) PN.add(i);
		size = PN.size();
		int ans = 0;
		for(int i=0; i<size; i++)
			if(Find(N,i)) ans++;
		System.out.println(ans);
	}
	
	public static boolean isPrime(int n) {
		if(n==2) return true;
		for(int i=2; i*i<=n; i++)
			if(n%i==0) return false;
		return true;
	}
	
	public static boolean Find(int target, int idx) {
		if(target==0) return true;
		else if (target<0 || idx>= size) return false;
		else return Find(target-PN.get(idx),idx+1);
	}
}
