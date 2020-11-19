package j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class position{
	int x,y;
	position(int x,int y){ this.x=x; this.y=y; }
}
public class icymountain_2573 {
	static int N,M;
	static int[][] map;
	static int uni_cnt;
	static int[] dx ={0,0,-1,1};
	static int[] dy ={-1,1,0,0};
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++)
				map[i][j]= Integer.parseInt(st.nextToken());
		}
		int year = 0;
		union_update();
		while(uni_cnt==1) {
			year++;
			melt();
			union_update();
		}
		if(uni_cnt==0) System.out.println("0");
		else System.out.println(year);
	}
	public static void union_update() {
		uni_cnt=0;
		boolean[][] visit = new boolean[N][M];
		Queue<position> q = new LinkedList<>();
		Queue<position> connect = new LinkedList<>();
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(map[i][j]>0) q.add(new position(i,j));
		while(!q.isEmpty()) {
			position pre = q.poll();
			if(!visit[pre.x][pre.y]) {
				uni_cnt++;
				connect.add(pre);
				visit[pre.x][pre.y] = true;
			}
			while(!connect.isEmpty()) {
				position cpre = connect.poll();
				for(int i=0; i<4; i++) {
					int nx = cpre.x + dx[i];
					int ny = cpre.y + dy[i];
					if(nx<N && ny<M && nx>=0 && ny>=0 && !visit[nx][ny]) {
						if(map[nx][ny]>0)
							connect.add(new position(nx,ny));
						visit[nx][ny] =true;
					}
				}
			}
		}
	}
	
	public static void melt() {
		/* 두 덩이 이상이면 끝나니까 어차피 빙산은 다 연결되어 있을 것임 */
		boolean[][] visit = new boolean[N][M];
		int[][] temp = new int[N][M];
		Queue<position> q = new LinkedList<>();
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) {
				temp[i][j] = map[i][j];
				if(map[i][j]>0) q.add(new position(i,j));
			}
		while(!q.isEmpty()) {
			position pre = q.poll();
			int cnt = 0;
			for(int i=0; i<4; i++) {
				int nx = pre.x+dx[i];
				int ny = pre.y+dy[i];
				if(nx<N && ny<M && nx>=0 && ny>=0 && map[nx][ny]==0)
					cnt++;
			}
			temp[pre.x][pre.y] -= cnt;
			if(temp[pre.x][pre.y]<0) temp[pre.x][pre.y]=0;
		}
		map = temp;
	}
}
