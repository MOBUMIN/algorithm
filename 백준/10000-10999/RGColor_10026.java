package r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class xy {
	int x;
	int y;
	xy(int x, int y) {
		this.x =x;
		this.y =y;
	}
}

public class RGColor_10026 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = str[j].charAt(0);
			}
		}
		
		int noRG = 0; int RG = 0;
		Queue<xy> next = new LinkedList<>();
		Queue<xy> all = new LinkedList<>();
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				all.add(new xy(i, j));
		while(!all.isEmpty()) {
			xy n = all.poll();
			if(visited[n.x][n.y]) continue;
			next.add(n); noRG++;
			while(!next.isEmpty()) {
				xy pos = next.poll();
				if(visited[pos.x][pos.y]) continue;
				visited[pos.x][pos.y]= true; 
				for(int i=0; i<4;i ++) {
					int nx = pos.x+dx[i];
					int ny = pos.y+dy[i];
					if(nx>=0 && nx<N && ny >=0 && ny<N) {
						if(visited[nx][ny]) continue;
						if(map[pos.x][pos.y] == map[nx][ny])
							next.add(new xy(nx, ny));
					}
				}
			}
		}
		
		visited = new boolean[N][N];
		next = new LinkedList<>();
		all = new LinkedList<>();
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				all.add(new xy(i, j));
		while(!all.isEmpty()) {
			xy n = all.poll();
			if(visited[n.x][n.y]) continue;
			next.add(n); RG++;
			while(!next.isEmpty()) {
				xy pos = next.poll();
				if(visited[pos.x][pos.y]) continue;
				visited[pos.x][pos.y]= true; 
				for(int i=0; i<4;i ++) {
					int nx = pos.x+dx[i];
					int ny = pos.y+dy[i];
					if(nx>=0 && nx<N && ny >=0 && ny<N) {
						if(visited[nx][ny]) continue;
						if(map[pos.x][pos.y] == map[nx][ny])
							next.add(new xy(nx, ny));
						else if((map[pos.x][pos.y]=='R' || map[pos.x][pos.y]=='G') && (map[nx][ny]=='R' || map[nx][ny]=='G')) {
							next.add(new xy(nx, ny));
						}
					}
				}
			}
		}
		
		System.out.println(noRG + " " + RG);
	}
}
