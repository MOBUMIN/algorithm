package d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class mazesearch_2178 {
	static class pos {
		int x;
		int y;
		int d; // 방향

		pos(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	static Queue<pos> q = new LinkedList<>();
	static int START = 0;
	static int UP = 1;
	static int DOWN = 2;
	static int RIGHT = 3;
	static int LEFT = 4;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String[] str;
		N = Integer.parseInt(st.nextToken()); // 세로 길이 (x)
		M = Integer.parseInt(st.nextToken()); // 가로 길이 (y)
		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			str = new String[M];
			str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		pos pre = new pos(0, 0, START);
		visit[0][0] = true;
		search(pre);
		while(!q.isEmpty()) {
			pos next = q.poll();
			int x = next.x; int y = next.y; int d = next.d;
			if(visit[x][y]) continue;
			visit[x][y]=true;
			switch(d) {
			case 1: // UP
				map[x][y] += map[x+1][y]; break;
			case 2: // DOWN
				map[x][y] += map[x-1][y]; break;
			case 3: // RIGHT
				map[x][y] += map[x][y-1]; break;
			case 4: // LEFT
				map[x][y] += map[x][y+1]; break;
			}
			pre = next;
			if(visit[N-1][M-1]) break;
			search(next);
		}
		System.out.println(map[N-1][M-1]);
	}

	public static void search(pos p) { 
		pos left, right, up, down;
		
		/* p의 상측 확인 */
		if (p.x > 0) {
			up = new pos(p.x - 1, p.y, UP);
			if(!visit[up.x][up.y] && map[up.x][up.y]==1 ) q.add(up);
		}
		/* p의 하측 확인 */
		if (p.x+1 < N) {
			down = new pos(p.x + 1, p.y, DOWN);
			if(!visit[down.x][down.y] && map[down.x][down.y]==1) q.add(down);
		}
		/* p의 우측 확인 */
		if (p.y+1 < M) {
			right = new pos(p.x, p.y+1, RIGHT);
			if(!visit[right.x][right.y] && map[right.x][right.y]==1) q.add(right);
		}
		/* p의 좌측 확인 */
		if (p.y > 0) {
			left = new pos(p.x, p.y-1, LEFT);
			if(!visit[left.x][left.y] && map[left.x][left.y]==1) q.add(left);
		}
	}
}
