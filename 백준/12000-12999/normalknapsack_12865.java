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
		
		N = Integer.parseInt(st.nextToken()); // ������ ��
		K = Integer.parseInt(st.nextToken()); // �뷮
		item = new int[N][2]; // ����, ��ġ
		dp = new int[N][K+1]; // ��ġ, ���� , -1 �� �ʱ�ȭ
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<2; j++)
				item[i][j] = Integer.parseInt(st.nextToken()); // ����, ��ġ ������ �Է�
		}
		
		for(int i=0; i<N; i++)
			for(int j=0; j<=K; j++)
				dp[i][j]=-1;
		
		System.out.println(knapsack(0,K));
	}
	
	public static int knapsack(int pos, int cap) {
		if(pos==N) return 0; // �� �̻� ������ ����
		int temp=dp[pos][cap];
		/* �̹� üũ�ߴ� �� */
		if(temp != -1) return dp[pos][cap];
		/* üũ ���� �� */
		if(item[pos][W] < cap) // ���� �뷮�� �����ϸ� �־��ֱ�.
			temp = knapsack(pos+1, cap-item[pos][W]) + item[pos][V];
		else if(item[pos][W]==cap)
			temp = item[pos][V];
		dp[pos][cap] = Math.max(temp, knapsack(pos+1,cap)); // ���� ��� vs ���� �ʰ� �� ���
		return dp[pos][cap];
	}
}
