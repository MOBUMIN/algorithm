import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2960 에라토스테네스의 체
public class eratostenes_2960 {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int t = 0; int j; int index=0;
		int[] del = new int[N-1]; // 삭제된 수를 담는 배열
		
		
		for(int i=2; i<=N; i++) {
			/* 배수를 찾으려는 수가 이미 삭제된 수를 담은 배열에 있다면 다음 수로 넘어가기*/
			for(int x=0; x<index; x++)
				if(del[x] == i) {i++; continue;}
					
			/* 삭제된 수를 담는 배열에 값을 넣어주는 부분 */
			j=i;
			while(j<=N) {
				/* 넣으려는 수가 이미 있는 수라면 넣지 않기 */
				for (int y = 0; y < index; y++) {
					if (del[y] == j) {t=1; break;}
				}
				if(t==1) j+=i;
				else { del[index++] = j; j+=i;}
				t=0;
			}
		}
		
		System.out.println(del[K-1]);
		
	}
}
