package n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* dp 문제는 언제나 점화식찾는 것이 어렵다 */
public class MultiMatrix_11409 {
	static int ROW =0;
	static int COL = 1;
	static int MAX = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 행렬의 개수
		int[][] mat = new int[N+1][2]; // 0:ROW, 1:COL
		for(int i=1;i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			mat[i][ROW] = Integer.parseInt(st.nextToken());
			mat[i][COL] =Integer.parseInt(st.nextToken());
		}
		long[][] dp = new long[N+1][N+1]; // i부터 j행렬까지의 곱의 최솟값
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++) {
				if(i==j) dp[i][j]=0;
				else dp[i][j]=MAX;
			}
		
		for(int i=1; i<N; i++)
			dp[i][i+1] = mat[i][ROW] * mat[i][COL] * mat[i+1][COL];
		
		for(int len=2; len<=N; len++) { // 행렬 곱셈할 길이
			for(int i=1; i<= N-len; i++) { // 시작
				int j = i+len; // 끝
				for(int k=i; k<j; k++) // 중간점
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + mat[i][ROW] * mat[k][COL] * mat[j][COL]);
			}
		}
		System.out.println(dp[1][N]);
	}
}
