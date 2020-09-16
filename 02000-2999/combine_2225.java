package g;

import java.util.Scanner;

public class combine_2225 {
	static int[][] dp;
	static int d = 1000000000;
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); int K = scan.nextInt();
		dp = new int[N+1][K+1];
		System.out.println(combine(N, K)%d);
	}
	public static int combine(int n, int k) {
		if(dp[n][k] != 0) return dp[n][k];
		if(k == 1) return 1;
		for(int i=0; i<=n; i++) {
			dp[n][k] += combine(i,k-1);
			dp[n][k] %=d;
		}
		return dp[n][k];
	}
}
