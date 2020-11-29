package l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Counter{
	int pos, cnt;
	Counter(int p, int c){
		this.pos = p; this.cnt=c;
	}
}
public class startlink_5014 {
	static int F,S,G,U,D;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		F = Integer.parseInt(st.nextToken()); // 건물의 층 수
		S = Integer.parseInt(st.nextToken()); // 강호의 위치
		G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
		U =Integer.parseInt(st.nextToken()); D = Integer.parseInt(st.nextToken());
		
		/* BFS 시작 */
		int ans = -1;
		Queue<Counter> q = new LinkedList<>();
		boolean[] visited = new boolean[F+1];
		q.add(new Counter(S,0)); visited[S] = true;
		while(!q.isEmpty()) {
			Counter p = q.poll();
			int pos = p.pos;
			int cnt = p.cnt;
			if(pos==G) { ans = cnt; break; }
			if(pos+U<=F && !visited[pos+U]) {
				q.add(new Counter(pos+U,cnt+1));
				visited[pos+U]=true;
			}
			if(pos-D>0 && !visited[pos-D]) {
				q.add(new Counter(pos-D,cnt+1));
				visited[pos-D]=true;
			}
		}
		
		if(ans==-1) System.out.println("use the stairs");
		else System.out.println(ans);
	}
}
