import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2110 ������ ��ġ

public class homerouter_2110 {

	public static void main(String args[]) throws IOException {

		/* ���� ���� N, �������� ���� C, �� ��ǥ �� x[] �о���� �κ� */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] x = new int[N]; // ���� ��ǥ�� ����Ǵ� �迭
		for (int i = 0; i < N; i++)
			x[i] = Integer.parseInt(br.readLine());
		Arrays.sort(x); // ��ǥ �������� ����
		
		if (C == 2)
			System.out.println(x[N - 1] - x[0]);
		else {

			int ans = (x[N - 1] - x[0]) / C; // �� �Ÿ��� ���̶�� ����!

			/* ������ �Ÿ���ŭ router�� ���� �� �ִٸ�, �Ÿ��� �÷����� */
			while (checkans(x, ans++, C, N)) { ans++; }
			/* ������ �Ÿ���ŭ router�� ���� �� ���ٸ�, �Ÿ��� �ٿ����� */
			while(!checkans(x,ans,C,N)) { ans--; }

			System.out.println(ans);
		}

	}
	
	public static boolean checkans(int[] house, int ans, int C, int N) { //��ǥ�迭, ������ ����, �������� ����, �� ����
		int pre=0; // ���� �����Ⱑ ��ġ�� ��ġ
		int cur=1; // �����⸦ ��ġ�� ��ġ
		int router = C-1; // ���� �������� ����
		
		for(int j=1; j<C; j++) {// ù��° ������ ������ �����⸦ ��ġ�ϴϱ� 1���� ����. ���� ������ ������ŭ �ݺ�.
			while(cur<N) {
				if(house[cur] - house[pre] >= ans) {
					pre = cur;
					cur++;
					router--;
				}
				else cur++;
			}
		}
		if(router>0) return false;
		else return true;
	}
}
