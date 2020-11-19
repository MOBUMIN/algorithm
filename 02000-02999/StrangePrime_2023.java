package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class StrangePrime_2023 {
	static int N;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		find(0, 10);
		
		while(!q.isEmpty()) {ans.append(q.poll()); ans.append("\n");}
		System.out.println(ans);
	}
	private static void find(int digit, int size) {
		if(size == Math.pow(10, N+1)) {
			q.add(digit/10); // 주어진 자리수에 부합하는 수임. 큐에 넣음!
			return;
		}
		for(int i = 0; i<10; i++) {
			if(isPrime(digit+i)) find((digit+i)*10, size*10); // 소수면 10을 곱해서 다음 자릿수까지 ㅇㅇㅇ
		}
	}
	private static boolean isPrime(int n) { // 인터넷에 있는 소수 판별 코드
		if(n==1 || n==0) return false;
		for(int i=2; i<=Math.sqrt(n); i++)
			if(n%i==0) return false;
		return true;
	}
}
