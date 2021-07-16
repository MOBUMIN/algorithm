package p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드-와샬
public class findRoute_11403 {
	public static void main(String args[]) throws IOException{
		/* input 받기 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int adj[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++)
				adj[i][j] = Integer.parseInt(st.nextToken());
		}
		
		/* 모든 경로 탐색 */
		for(int k=0; k<N; k++) { // 거치는 정점
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(adj[i][j] == 1) continue;
					else if (adj[i][k] == 1 && adj[k][j] == 1) adj[i][j] = 1;
				}
			}
		}
		
		/* output */
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				System.out.print(adj[i][j]+" ");
			System.out.println();
		}
	}
}
