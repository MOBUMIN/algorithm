import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//2012 등수 매기기
public class ranking_2012 {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] rank = new int[N+1];
		for(int i=1; i<N+1; i++)
			rank[i] = Integer.parseInt(br.readLine());
		Arrays.sort(rank);
		
		long complaint = 0; // 불만
		
		for(int i=1; i<N+1; i++) {
			if(rank[i] != i) {
				complaint += Math.abs(rank[i] - i);
			}
		}
		
		System.out.println(complaint);
	}
}
