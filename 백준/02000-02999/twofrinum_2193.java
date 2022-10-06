package n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class twofrinum_2193 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N][2];
		dp[0][1] = 1;
		// 1, 10
		// 100, 101
		// 1000, 1010 (이전 dp의 뒷자리에 0붙이기)
		// 1001 (이전 dp의 자리에 1붙이기)
		for(int i=1; i<N; i++) {
			dp[i][0] += dp[i-1][0] + dp[i-1][1];
			dp[i][1] += dp[i-1][0];
		}
		
		System.out.println(dp[N-1][0]+dp[N-1][1]);
	}
}
