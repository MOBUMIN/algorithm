package g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 무작정 재귀함수로 풀려다가 실패함, dp 추가후 성공 */
public class downhill_1520 {
	static int N, M;
	static int[][] map, dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++)
				{
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
				}
		}
		System.out.println(find(0,0));
	}
	public static int find(int x, int y) {
		if(x==N-1 && y==M-1) return 1;
		if(dp[y][x] == -1) {
			dp[y][x]=0;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M)
					if (map[ny][nx] < map[y][x])
						dp[y][x] += find(nx, ny);
			}
		}
		return dp[y][x];
	}
}
