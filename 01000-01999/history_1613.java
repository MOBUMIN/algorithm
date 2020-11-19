package j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class history_1613 {
	static int INF = 10000;
	static int N;
	public static void main(String args[]) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
		int[][] his = new int[N+1][N+1];
		init(his);
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int pre = Integer.parseInt(st.nextToken()); int post = Integer.parseInt(st.nextToken());
			his[pre][post]=-1; his[post][pre]=1;
		}
		
		for(int c=1; c<=N; c++) {
			for(int a=1; a<=N; a++) {
				if (a == c) continue;
				for (int b = 1; b <= N; b++) {
					if (a == b || c == b) continue;
					if (his[a][b] == INF) {
						if (his[a][c] == 1 && his[c][b] == 1) {
							his[a][b] = 1;
							his[b][a] = -1;
						}
						else if(his[a][c]==-1 && his[c][b] == -1) {
							his[a][b] = -1; his[b][a] = 1;
						}
					}
				}
			}
		}
		
		
		int s = Integer.parseInt(br.readLine());
		for(int i=0; i<s; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int pre = Integer.parseInt(st.nextToken()); int post = Integer.parseInt(st.nextToken());
			if(his[pre][post] == INF || his[pre][post] == 0) sb.append(0+"\n");
			else sb.append(his[pre][post]+"\n");
		}
		System.out.println(sb);
	}
	public static void init(int[][] a) {
		for(int i=0; i<=N;i++)
			for(int j=0;j<=N;j++) {
				if(i==j) a[i][j] = 0;
				else a[i][j] = INF;
			}
	}
}
