import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10250 ACM 호텔
//걷는 거리는 신경 x
public class ACMhotel_10250 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 개수 T

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken()); // 높이(층수)
			int W = Integer.parseInt(st.nextToken()); // 너비(방수)
			int N = Integer.parseInt(st.nextToken()); // 사람수
			find(H+1, W+1, N); // 숫자랑 배열자리랑 같게 하려고
		}
		
		System.out.println(sb);
	}

	public static void find(int h, int w, int n) {
		/* 주먹 구구식 방법 */
		/*
		int[][] hotel = new int[h][w];
		int h_full = 1; // 채워져있는 층수
		int w_full = 1; // 채워져있는 방번호
		while (n > 0) {
			while (h > h_full) { // 층별 1호를 채우고, 층별 2호를 채우는 방식.
				if (hotel[h_full][w_full] == 0) {
					hotel[h_full][w_full] = 1;
					n--;
					if(n==0) break;
					h_full++;
				}
			}
			if(n==0) break;
			h_full=1; w_full++;
		}
		int ans = h_full*100 + w_full;
		sb.append(ans+"\n");
		*/
		
		/* 계산 방법 */
		
		h--; w--; int ans,floor,room;
		if(n%h==0) { // 사람 수가 층 수로 나누어 떨어진다면!
			floor = h; room = n/h; // 마지막 사람은 무조건 꼭대기 층에 있을것!, 사람수/층 만큼 간 자리에 방 배정!
			ans = floor*100+room;
		}
		else {
			floor = n%h; // 다 배정하고 남은 사람들은 아래서부터 위로 올려줘야히니까 % 연산
			room = n/h+1; // 사람수/층수 만큼 가고 그 다음부터 채워줘야하니까!
			ans = floor*100 + room;
		}
		sb.append(ans+"\n");
		
	}		
}
