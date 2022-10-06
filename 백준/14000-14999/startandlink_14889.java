package h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class startandlink_14889 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] S = new int[N][N];
		int ans = 100000; // 대충 문제에서 만들 수 없는 큰 수 주기 100*20
		
		/* S배열 읽어오기 */
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				S[i][j] = Integer.parseInt(st.nextToken());
		}

		/* 길이 N의 모든 subset 조합 구하는 알고리즘, 구글링 */
		int[] input = new int[N];
		for (int i = 0; i < N; i++) // 만약 N=6이면 0,1,2,3,4,5
			input[i] = i;
		int k = N / 2; // subset의 크기
		List<int[]> subsets = new ArrayList<>();
		int[] s = new int[k];
		for (int i = 0; (s[i] = i) < k - 1; i++); // N=6일때 첨에 0,1,2 까지만 받아옴
		subsets.add(getSubset(input, s)); // input의 0,1,2번째(input[s[0]], input[s[1]], input[s[2]])를 subset에! 
		for (;;) {
			int i;
			for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--); // 6 - 3 + 2 = 5, 6 - 3 + 1 = 4 ... 해당 자리수 끝에 도달하면 그 앞의 자릿수로 index 이동
			if (i < 0)break;
			s[i]++; // 1,2,5 -> 1,3,5 혹은 1,2,3 -> 1,2,4
			for (++i; i < k; i++) s[i] = s[i - 1] + 1; // 1,3,5 -> 1,3,4 , 끝자리수만 바꾸는 경우는 해당 없음 . 
			subsets.add(getSubset(input, s)); // 해당 subset 입력
		}

		/* start와 link를 두고 최소값 구하기! */
		int[] start = new int[N/2];
		int[] link = new int[N/2];
		for(int i=0; i<subsets.size(); i++) {
			boolean[] visit = new boolean[N]; // link를 정해주기 위해서 visit 체크 할 것임
			start = subsets.get(i);
			if(start[0] > 1) break; // 앞자리가 1일때만 다 해보면 모든 경우 다 해본거임(계산해보니 그럼)
			int link_index = 0;
			int ans_temp=0;
			/* start 배열에 있는 수들은 방문 체크 */
			for(int j=0; j<N/2; j++)
				visit[start[j]] = true;
			/* 방문이 안된 수를 link에 넣기 */
			for(int j=0; j<N; j++) {
				if(visit[j] == false) link[link_index++]=j;
				if(link_index>=N/2) break;
			}
			/* 0,1,2의 경우. 0,1(+1,0)-> 0,2(+2,0)-> 1,2(+2,1) 순으로 해주도록 함 */
			for(int j=0; j<N/2-1; j++) {
				for(int x=j+1; x<N/2; x++) {
				ans_temp += S[start[j]][start[x]] + S[start[x]][start[j]];
				ans_temp -= (S[link[j]][link[x]] + S[link[x]][link[j]]);
				}
			}
			ans = Math.min(ans, Math.abs(ans_temp));
			ans_temp=0;
		}
		System.out.println(ans);

	}

	static int[] getSubset(int[] input, int[] subset) {
		int[] result = new int[subset.length];
		for (int i = 0; i < subset.length; i++)
			result[i] = input[subset[i]];
		return result;
	}
}
