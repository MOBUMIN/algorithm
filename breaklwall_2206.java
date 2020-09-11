package j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class pos{
	int x,y,cnt;
	boolean isBreak;
	pos(int x,int y,int c,boolean b){
		this.x=x; this.y=y; this.cnt=c; this.isBreak=b;
	}
}

public class breaklwall_2206 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); int M = Integer.parseInt(str[1]);
		int[][] map = new int[N+1][M+1];
		boolean[][] visit = new boolean[N+1][M+1];
		boolean[][] b_visit = new boolean[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String[] st = br.readLine().split("");
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st[j-1]);
			}
		}
		
		Queue<pos> q = new LinkedList<>();
		q.add(new pos(1,1,1,false));
		visit[1][1] = true;
		b_visit[1][1] = true;
		int ans = -1;
		while(!q.isEmpty()) {
			pos next = q.poll();
			if(next.x == N && next.y == M) {
				ans = next.cnt; break;
			}
			for(int i=0; i<4; i++) {
				int nx = next.x + dx[i];
				int ny =next.y + dy[i];
				int nc = next.cnt+1;
				if(0<nx && 0<ny && N>=nx && M>=ny) {
					if(!visit[nx][ny]) {
						if(map[nx][ny] == 1 && !next.isBreak) {
							q.add(new pos(nx,ny,nc,true));
							visit[nx][ny]=true;
							b_visit[nx][ny]=true;
						}
						else if(map[nx][ny]==0 && !next.isBreak) {
							q.add(new pos(nx,ny,nc,next.isBreak));
							visit[nx][ny] = true;
							b_visit[nx][ny]=true;
						}
						else if(map[nx][ny]==0 && next.isBreak && !b_visit[nx][ny]) {
							q.add(new pos(nx,ny,nc,next.isBreak));
							b_visit[nx][ny]=true;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
