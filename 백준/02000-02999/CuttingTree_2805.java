package m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 브루트포스로 풀다가 틀리고 시간초과가 나서 이진 탐색을 썼으나
 * start와 end값을 mid로 바꾸지 않고 --, ++로 조정해서 시간초과가 계속 났다.
 * 나중에 알아채고 수정하고나자 무한루프를 도는 현상이 생겨서
 * 간단하게 없애주었다.
 * */
public class CuttingTree_2805 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 필요한 길이
		int[] tree = new int[N]; // 나무들의 높이
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++)
			tree[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(tree);
		/* 절단기에 설정할 높이 */
		int high = tree[N-1];
		int low = 0;
		int H = low;
		/* 탐색 */
		long sum;
		while(low<high) {
			sum=0;
			H = (high+low)/2;
			for(int i = N-1; i>=0; i--) {
				if(tree[i]>H) sum+=tree[i]-H;
				else break;
			}
			if(low==H) break; // 이게 없으면 계속 같은 값이 반복돼서 무한루프.
			if(sum<M) high=H;
			else if(sum>M) low=H;
			else break;
		}
		System.out.println(H);
	}
}