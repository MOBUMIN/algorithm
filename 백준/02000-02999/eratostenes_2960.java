import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2960 �����佺�׳׽��� ü
public class eratostenes_2960 {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int t = 0; int j; int index=0;
		int[] del = new int[N-1]; // ������ ���� ��� �迭
		
		
		for(int i=2; i<=N; i++) {
			/* ����� ã������ ���� �̹� ������ ���� ���� �迭�� �ִٸ� ���� ���� �Ѿ��*/
			for(int x=0; x<index; x++)
				if(del[x] == i) {i++; continue;}
					
			/* ������ ���� ��� �迭�� ���� �־��ִ� �κ� */
			j=i;
			while(j<=N) {
				/* �������� ���� �̹� �ִ� ����� ���� �ʱ� */
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
