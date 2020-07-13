import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2110 공유기 설치

public class homerouter_2110 {

	public static void main(String args[]) throws IOException {

		/* 점의 개수 N, 공유기의 개수 C, 각 좌표 값 x[] 읽어오는 부분 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] x = new int[N]; // 집의 좌표가 저장되는 배열
		for (int i = 0; i < N; i++)
			x[i] = Integer.parseInt(br.readLine());
		Arrays.sort(x); // 좌표 오름차순 정렬
		
		if (C == 2)
			System.out.println(x[N - 1] - x[0]);
		else {

			int ans = (x[N - 1] - x[0]) / C; // 이 거리가 답이라고 가정!

			/* 가정한 거리만큼 router를 놓을 수 있다면, 거리를 늘려보기 */
			while (checkans(x, ans++, C, N)) { ans++; }
			/* 가정한 거리만큼 router를 놓을 수 없다면, 거리를 줄여보기 */
			while(!checkans(x,ans,C,N)) { ans--; }

			System.out.println(ans);
		}

	}
	
	public static boolean checkans(int[] house, int ans, int C, int N) { //좌표배열, 가정한 정답, 공유기의 개수, 집 개수
		int pre=0; // 이전 공유기가 설치된 위치
		int cur=1; // 공유기를 설치할 위치
		int router = C-1; // 남은 공유기의 개수
		
		for(int j=1; j<C; j++) {// 첫번째 점에는 무조건 공유기를 설치하니까 1부터 시작. 남은 공유기 개수만큼 반복.
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
