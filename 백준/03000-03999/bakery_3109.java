package k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bakery_3109 {
	static int R;
	static int C;
	static boolean visited[][];
	static int cnt=0;
	static int dr[] = {-1, 0, 1};
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		/* map 채워넣기 */
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0;j<C;j++)
				if(temp[j].charAt(0)!='.') visited[i][j] = true;
		}
		/* dfs 시작(위에서부터) */
		for(int i=0; i<R; i++)
			dfs(i,0);
		System.out.println(cnt);
	}
	public static boolean dfs(int r, int c) {
		/* 무사히 빵집 도달, 파이프++ */
		if(c==C-1 && !visited[r][c]) {
			cnt++; return true;
		}
		visited[r][c] = true;
		for(int i=0; i<3; i++) {
			int nextR = r+dr[i];
			int nextC = c+1;
			if(0<=nextR && nextR<R && !visited[nextR][nextC])
				if(dfs(nextR,nextC)) return true;
		}
		return false;
	}
}
