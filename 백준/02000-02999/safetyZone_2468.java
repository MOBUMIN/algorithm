package q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class XY {
	int x;
	int y;
	XY(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class safetyZone_2468 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int ans = 1;
		int[][] map = new int[N][N];
		int min = 100; int max = 1;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(min > map[i][j]) min = map[i][j];
				if(max < map[i][j]) max = map[i][j];
			}
		}
		
		for(int i=min; i<max; i++) {
			int cnt = 0;
			int[] dx = {0, 0, -1, 1};
			int[] dy = {-1, 1, 0, 0};
			Queue<XY> toGo = new LinkedList<>();
			/* make new map */
			boolean[][] visited = new boolean[N][N];
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(map[j][k] <= i) visited[j][k] = true;
					else toGo.add(new XY(j, k));
				}
			}
			
			/* bfs */
			while(!toGo.isEmpty()) {
				XY pos = toGo.poll();
				if(visited[pos.x][pos.y]) continue;
				visited[pos.x][pos.y] = true;
				cnt++;
				Queue<XY> connected = new LinkedList<>();
				for(int m=0; m<4; m++) {
					int nx = pos.x+dx[m];
					int ny = pos.y+dy[m];
					if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny])
						connected.add(new XY(nx, ny));
				}
				while(!connected.isEmpty()) {
					XY cPos = connected.poll();
					if(visited[cPos.x][cPos.y]) continue;
					visited[cPos.x][cPos.y] = true;
					for(int m=0; m<4; m++) {
						int nx = cPos.x+dx[m];
						int ny = cPos.y+dy[m];
						if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny])
							connected.add(new XY(nx, ny));
					}
				}
			}
			if(ans<cnt) ans = cnt;
		}
		System.out.println(ans);
	}
}
