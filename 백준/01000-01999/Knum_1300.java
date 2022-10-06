package n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 주어진 배열이 계속 증가하므로 이분 탐색 문제 */
public class Knum_1300 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine()); // NxN 배열 A
		long K = Long.parseLong(br.readLine()); // 찾으려는 index, B[K]

		long count;
		long mid=K, left=0, right=N*N;
		long ans=0;
		while(left<=right) { // 이분 탐색 시작
			mid=(left+right)/2; count =0;
			System.out.println("left: "+left+" right: "+right+" mid: "+mid);
			for(int i=1; i<=Math.min(mid, N); i++) 
				count += Math.min(N, mid/i);
			System.out.println("count: "+count);
			if ( count >= K ) {
				ans=mid;
				right=mid-1;
			}else if ( count < K ){
				left=mid+1;
			}
		}
		System.out.println(ans);
	}
}
