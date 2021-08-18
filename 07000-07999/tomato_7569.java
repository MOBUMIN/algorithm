package r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class HNM {
	int h;
	int n;
	int m;
	HNM(int h, int n, int m){
		this.h=h; this.n=n; this.m=m;
	}
}
public class tomato_7569 {
	static int H, M, N;
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int[][][] map = new int[H][N][M];
		boolean[][][] visited = new boolean[H][N][M];
		Queue<HNM> next = new LinkedList<>();
		int ans = 0;
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int k=0; k<M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) {
						next.add(new HNM(i,j,k));
						visited[i][j][k] = true;
					}
					if(map[i][j][k] == -1) visited[i][j][k] = true;
				}
			}
		}
		
		int[] dx = {0,0,-1,1,0,0};
		int[] dy = {-1,1,0,0,0,0};
		int[] dh= {0,0,0,0,1,-1};
		while(!next.isEmpty()) {
			if(Check(visited)) break;
			Queue<HNM> today = new LinkedList<>();
			while(!next.isEmpty()) today.add(next.poll());
			// System.out.println(ans+ " today ------------");
			while(!today.isEmpty()) {
				HNM pos = today.poll();
				visited[pos.h][pos.n][pos.m]=true;
				// System.out.println(pos.h+", "+pos.n+", "+pos.m);
				for(int i=0; i<6; i++) {
					int nh = pos.h+dh[i];
					int nx = pos.n+dx[i];
					int ny = pos.m+dy[i];
					if(nh>=0 && nh<H && nx>=0 && nx<N && ny>=0 && ny<M && !visited[nh][nx][ny] && map[nh][nx][ny] == 0) {
						next.add(new HNM(nh,nx,ny));
						visited[nh][nx][ny] = true;
					}
				}
			}
			ans++;
		}
		if(!Check(visited)) ans = -1;
		System.out.println(ans);
	}
	public static boolean Check(boolean[][][] visited) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++)
					if(!visited[i][j][k]) {
						return false;
					}
			}
		}
		return true;
	}
}
