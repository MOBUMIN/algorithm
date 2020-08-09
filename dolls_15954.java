package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dolls_15954 {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 인형의 개수
		int K = Integer.parseInt(st.nextToken()); // 포함되어야하는 최소값
		int[] prefer = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) prefer[i] = Integer.parseInt(st.nextToken());
		
		double ans=Math.pow(10, 14);
		double tmp, a, b; // a = 평균 b = 분산
		for(int i=0; i<=N-K; i++) {
			int count = K;
			while(i+count<=N) {
				tmp=0;
				/* average */
				for(int j = 0; j<count; j++)
					tmp += prefer[i+j];
				a = tmp / count;
				
				tmp = 0;
				/* variance */
				for(int k=0; k<count; k++)
					tmp += (prefer[i+k] - a) * (prefer[i+k]-a) ;
				b  = tmp / count;
				
				b = Math.sqrt(b);
				ans = Math.min(ans, b);
				count++;
			}
		}
		System.out.println(ans);
	}
	
}
