import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11729 �ϳ���ž
public class hanoitop_11729 {

	static int cnt = 0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ������ ����
		
		StringBuilder sb = new StringBuilder(); // sysout�� �ð��ʰ����� ;

		hanoi(1, 3, N, 2, sb); // 1�� ������ 3�� ������ N ���� 2�� ���� �̿��Ͽ� �ű��!
		System.out.println(cnt);
		System.out.println(sb);

	}

	public static void hanoi(int from, int to, int n, int by, StringBuilder sb) {

			if(n>0) {
				cnt++;
				hanoi(from, by, n - 1, to,sb); // 1������ 1�� ���� �� 2������
				sb.append(from+" "+to+"\n"); // 1���� �����ִ� �ϳ��� 3������!
				hanoi(by, to, n - 1, from,sb); // 2���� �ִ°� �� 3������!
			}

	}
}
