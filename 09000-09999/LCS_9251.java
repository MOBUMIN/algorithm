package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LCS_9251 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] A = br.readLine().split(""); String[] B = br.readLine().split("");
		int Alen = A.length+1; int Blen = B.length+1;
		char[] a = new char[Alen]; char[] b = new char[Blen];
		int[][] dp = new int[Alen][Blen];
		for(int i=1; i<Alen; i++) a[i] = A[i-1].charAt(0);
		for(int i=1; i<Blen; i++) b[i] = B[i-1].charAt(0);
		/* dp ä��� */
		for(int i=1; i<Alen; i++) {
			for(int j=1; j<Blen; j++) {
				if(a[i] == b[j]) dp[i][j] = dp[i-1][j-1] +1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		Stack<Character> ans = new Stack<>();
		int i = Alen-1; int j = Blen-1;
		/* ���� ���ڸ� �信 �ְ� �밢������ ������. �ƴϸ� ���ʰ� �� �� �� �� ū ���ڰ� �ִ� ������ ���� */
		while(dp[i][j] != 0) {
			if(a[i] == b[j]) {
				ans.push(a[i]);
				i--; j--;
			}
			else {
				if(dp[i-1][j] > dp[i][j-1]) i--;
				else j--;
			}
		}
		System.out.println(ans.size());
	}
}
