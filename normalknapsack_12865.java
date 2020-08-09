package e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class normalknapsack_12865 {
	static int[][] dp;
	static int[][] item;
	static final int W=0;
	static final int V=1;
	static int N, K;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken()); // 물건의 수
		K = Integer.parseInt(st.nextToken()); // 용량
		item = new int[N][2]; // 무게, 가치
		dp = new int[N][K+1]; // 위치, 무게 , -1 로 초기화
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<2; j++)
				item[i][j] = Integer.parseInt(st.nextToken()); // 무게, 가치 순으로 입력
		}
		
		for(int i=0; i<N; i++)
			for(int j=0; j<=K; j++)
				dp[i][j]=-1;
		
		System.out.println(knapsack(0,K));
	}
	
	public static int knapsack(int pos, int cap) {
		if(pos==N) return 0; // 더 이상 물건이 없어
		int temp=dp[pos][cap];
		/* 이미 체크했던 곳 */
		if(temp != -1) return dp[pos][cap];
		/* 체크 안한 곳 */
		if(item[pos][W] < cap) // 가방 용량이 가능하면 넣어주기.
			temp = knapsack(pos+1, cap-item[pos][W]) + item[pos][V];
		else if(item[pos][W]==cap)
			temp = item[pos][V];
		dp[pos][cap] = Math.max(temp, knapsack(pos+1,cap)); // 넣은 경우 vs 넣지 않고 간 경우
		return dp[pos][cap];
	}
}
