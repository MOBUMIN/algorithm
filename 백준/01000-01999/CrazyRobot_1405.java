package m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class pos{
	int x,y;
	int percent=0;
	pos(int x, int y){ this.x=x; this.y=y; }
}
public class CrazyRobot_1405 {
	static int[][] map;
	static int N;
	static double[] d;
	static double ans = 0;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 취할 행동의 수
		d = new double[4]; // 방향에 따른 확률 동/서/남/북
		for(int i=0; i<4; i++) d[i] = Double.parseDouble(st.nextToken())/100;
		map = new int[30][30]; // 임의로 정한 map.
		map[15][15]=1;
		dfs(15,15,0,1);
		System.out.println(ans);
	}
	public static void dfs(int x, int y, int n, double p) {
		if(n==N) {
			ans += p;
			return;
		}
		map[x][y] = 1;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(map[nx][ny]==0) {
				dfs(nx,ny,n+1,p*d[i]);
			}
		}
		map[x][y]=0;
	}
}
