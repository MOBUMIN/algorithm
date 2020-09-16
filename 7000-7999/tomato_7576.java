package e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* bfs 문제, 2178, 1260 과 비슷함 */

class pos {
	int x;
	int y;

	pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class tomato_7576 {
	static int M, N;
	static int day;
	public static void main(String args[]) throws IOException {
		Queue<pos> today = new LinkedList<>();
		Queue<pos> next = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) today.add(new pos(i,j));
			}
		}
		day=0;
		while(true) {
			while (!today.isEmpty()) {
				pos cur = today.poll();
				search(cur, map, next);
			}
			if(next.isEmpty()) break;
			day++;
			while(!next.isEmpty())
				today.add(next.poll());
			next.clear();
		}
		int imposible=0;
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				if(map[i][j] == 0) imposible=1;
		if(imposible>0) System.out.println("-1");
		else System.out.println(day);

	}
	
	public static void search(pos p, int[][] map, Queue<pos> n) {
		/* 상 */
		if(p.x>0)
			if(map[p.x-1][p.y] == 0) {
				map[p.x-1][p.y]=1;
				n.add(new pos(p.x-1,p.y));
			}
		/* 하 */
		if(p.x<N-1)
			if(map[p.x+1][p.y]==0) {
				map[p.x+1][p.y]=1;
				n.add(new pos(p.x+1,p.y));
			}
		/* 좌 */
		if(p.y>0)
			if(map[p.x][p.y-1]==0) {
				map[p.x][p.y-1]=1;
				n.add(new pos(p.x, p.y-1));
			}
		/* 우 */
		if(p.y<M-1)
			if(map[p.x][p.y+1]==0) {
				map[p.x][p.y+1]=1;
				n.add(new pos(p.x, p.y+1));
			}
	}
}
