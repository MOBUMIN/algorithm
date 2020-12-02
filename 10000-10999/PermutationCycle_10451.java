package l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PermutationCycle_10451 {
	static int[] P;
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			P = new int[N+1];
			boolean[] visited = new boolean[N+1];
			boolean[] isCycle = new boolean[N+1];
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) P[j]=Integer.parseInt(st.nextToken());
			int ans=0;
			/* 순열을 찾아볼까 */
			for(int k=1;k<=N;k++) {
				if(!isCycle[k])
					if(DFS(k,visited)) {
						ans++;
						for(int x=1; x<=N; x++)
							if(visited[x]) {
								isCycle[x] = true;
								visited[x] = false;
							}
					}
			}
			System.out.println(ans);
		}
	}
	public static boolean DFS(int k, boolean[] visited) {
		visited[k] = true;
		if(visited[P[k]] == true) return true;
		if(DFS(P[k], visited)) return true;
		return false;
	}
}
