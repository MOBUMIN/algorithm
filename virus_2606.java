import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class virus_2606 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine())+1; // 컴터 수
		int pair = Integer.parseInt(br.readLine()); // 쌍 수

		int[][] map = new int[n][n];
		int[] visit = new int[n]; // 1번 컴퓨터가 방문할 수 있는지 표시

		/* map 채우는 부분 x->y로 갈 수 있냐 없냐 표시하는 것 */
		int x, y;
		for (int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y]=1;
			map[y][x]=1; // 양방향이기 때문에 해줘야함 ㅜㅜ
		}

		/* 1번에서 갈 수 있는 컴퓨터들 체킹 */
		for (int j = 1; j < n; j++) {
			if (map[1][j] > 0) {
				check(j,map,n,visit); // 1번에서 갈 수 있는 아이가 또 어디로 갈 수 있는지 체킹!
			}
		}
		
		/* 1번이 감염시킨 컴퓨터 갯수 출력 */
		int count = 0;
		for(int m=2; m<n; m++)
			if(visit[m] > 0) count++;
		
		System.out.println(count);
	}

	public static void check(int x, int[][] map, int n, int[] visit) {
		visit[x] = 1;
		for(int k=2;k<n;k++) {
			if(map[x][k]>0 && visit[k] == 0) { // && 뒤 조건을 넣지 않으면 무한재귀에 빠져버림
				check(k,map,n,visit);
			}
		}
	}
}
