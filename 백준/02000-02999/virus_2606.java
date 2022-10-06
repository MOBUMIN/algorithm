import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class virus_2606 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine())+1; // ���� ��
		int pair = Integer.parseInt(br.readLine()); // �� ��

		int[][] map = new int[n][n];
		int[] visit = new int[n]; // 1�� ��ǻ�Ͱ� �湮�� �� �ִ��� ǥ��

		/* map ä��� �κ� x->y�� �� �� �ֳ� ���� ǥ���ϴ� �� */
		int x, y;
		for (int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y]=1;
			map[y][x]=1; // ������̱� ������ ������� �̤�
		}

		/* 1������ �� �� �ִ� ��ǻ�͵� üŷ */
		for (int j = 1; j < n; j++) {
			if (map[1][j] > 0) {
				check(j,map,n,visit); // 1������ �� �� �ִ� ���̰� �� ���� �� �� �ִ��� üŷ!
			}
		}
		
		/* 1���� ������Ų ��ǻ�� ���� ��� */
		int count = 0;
		for(int m=2; m<n; m++)
			if(visit[m] > 0) count++;
		
		System.out.println(count);
	}

	public static void check(int x, int[][] map, int n, int[] visit) {
		visit[x] = 1;
		for(int k=2;k<n;k++) {
			if(map[x][k]>0 && visit[k] == 0) { // && �� ������ ���� ������ ������Ϳ� ��������
				check(k,map,n,visit);
			}
		}
	}
}
