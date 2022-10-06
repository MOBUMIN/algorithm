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
			q.add(digit/10); // �־��� �ڸ����� �����ϴ� ����. ť�� ����!
			return;
		}
		for(int i = 0; i<10; i++) {
			if(isPrime(digit+i)) find((digit+i)*10, size*10); // �Ҽ��� 10�� ���ؼ� ���� �ڸ������� ������
		}
	}
	private static boolean isPrime(int n) { // ���ͳݿ� �ִ� �Ҽ� �Ǻ� �ڵ�
		if(n==1 || n==0) return false;
		for(int i=2; i<=Math.sqrt(n); i++)
			if(n%i==0) return false;
		return true;
	}
}
