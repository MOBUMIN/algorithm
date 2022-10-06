package p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class loc {
	int pos;
	int cnt;
	loc(int p, int c){
		this.pos = p;
		this.cnt = c;
	}
}

public class snakeGame_16928 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int map[] = new int[101];
		boolean visited[] = new boolean[101];
		
		/* Setting map */
		for(int i=1; i<=100; i++)
			map[i] = i;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from] = to;
		}
		
		/* bfs */
		int ans=0;
		Queue<loc> q = new LinkedList<>(); 
		q.add(new loc(1, 0));
		while(!q.isEmpty()) {
			boolean visitToggle = false;
			loc pos = q.poll();
			int prepos = pos.pos;
			visited[prepos] = true;
			int realPos = map[pos.pos];
			while(prepos != realPos) {
				if(visited[realPos]) {
					visitToggle = true;
					break;
				}
				visited[realPos] = true;
				prepos = realPos;
				realPos = map[prepos];
			}
			if(visitToggle) continue;
			if (realPos == 100) {
				ans = pos.cnt;
				break;
			}
			for(int i=1; i<=6; i++) {
				if(realPos+i <=100 && !visited[realPos+i])
					q.add(new loc(realPos+i, pos.cnt+1));
			}
		}
		System.out.println(ans);
	}
}
