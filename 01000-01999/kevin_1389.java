package r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kevin_1389 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		int[][] rel = new int[N+1][N+1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				rel[i+1][j+1] = 99999999;
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rel[a][b] = 1; rel[b][a] = 1;
		}
		
		for(int k=1; k<N+1; k++) {
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(rel[i][j] == 1 || i==j) continue;
					else if(rel[i][k] + rel[k][j] < rel[i][j]) {
						rel[i][j] = rel[i][k] + rel[k][j];
						rel[j][i] = rel[i][j];
					}
				}
			}
		}
		
		int idx = 0; int min = 999999; int cnt = 0;
		for(int i=1; i<N+1; i++) {
			cnt=0;
			for(int j=1; j<N+1; j++) {
				if(i==j) continue;
				cnt += rel[i][j];
			}
			if(min>cnt) {
				idx = i;
				min = cnt;
			}
		}
		
		System.out.println(idx);
	}
}
