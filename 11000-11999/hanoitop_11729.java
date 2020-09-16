import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11729 하노이탑
public class hanoitop_11729 {

	static int cnt = 0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 원판의 개수
		
		StringBuilder sb = new StringBuilder(); // sysout은 시간초과때매 ;

		hanoi(1, 3, N, 2, sb); // 1번 봉에서 3번 봉으로 N 개를 2번 봉을 이용하여 옮기기!
		System.out.println(cnt);
		System.out.println(sb);

	}

	public static void hanoi(int from, int to, int n, int by, StringBuilder sb) {

			if(n>0) {
				cnt++;
				hanoi(from, by, n - 1, to,sb); // 1번에서 1개 빼고 다 2번으로
				sb.append(from+" "+to+"\n"); // 1번에 남아있는 하나는 3번으로!
				hanoi(by, to, n - 1, from,sb); // 2번에 있는거 다 3번으로!
			}

	}
}
