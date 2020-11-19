package k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS3_1958 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] A = br.readLine().split(""); String[] B = br.readLine().split(""); String[] C = br.readLine().split("");
		int alen = A.length; int blen = B.length; int clen = C.length;
		char[] a = new char[alen+1]; char[] b = new char[blen+1]; char[] c = new char[clen+1];
		// 0일때 예외처리를 피하기 위해서 1 start
		for(int i=1; i<=alen; i++) a[i] = A[i-1].charAt(0);
		for(int i=1; i<=blen; i++) b[i] = B[i-1].charAt(0);
		for(int i=1; i<=clen; i++) c[i] = C[i-1].charAt(0);
		/* dp 채우기 */
		int[][][] dp = new int[alen+1][blen+1][clen+1];
		for(int i=1; i<=alen; i++)
			for(int j=1; j<=blen; j++)
				for(int k=1; k<=clen; k++) {
					if(a[i] == b[j] && b[j] == c[k]) dp[i][j][k] = dp[i-1][j-1][k-1]+1;
					else {
						int max = Math.max(dp[i][j][k-1], dp[i][j-1][k]);
						dp[i][j][k] = Math.max(max, dp[i-1][j][k]);
					}
				}
		/*
		for(int i=1; i<=alen; i++) {
			for(int j=1; j<=blen; j++) {
				for(int k=1; k<=clen; k++)
					System.out.print(dp[i][j][k]);
				System.out.println();
			}
			System.out.println();
		}
		*/
		System.out.println(dp[alen][blen][clen]);
	}
}
