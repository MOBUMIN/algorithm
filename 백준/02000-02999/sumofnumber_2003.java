import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2003�� ������ ��2

public class sumofnumber_2003 {

	public static void main(String args[]) throws IOException {

		/* N, M, A �о���� �κ� */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A[] = new int[N];

		str = br.readLine();
		st = new StringTokenizer(str, " ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		int ans = compare(N,M,A);
		
		System.out.println(ans);

	}

	/* 1��° �׺��� target�� �ɶ����� �� target�� �ǰų� �ʰ��Ǹ�, Ȥ�� ������ ���̸� �ι�°�׺��� �� */
	public static int compare(int end, int target, int[] A) {
		int count = 0;
		for (int i = 0; i < end; i++) {
			int j = i;
			int temp = 0;
			while (temp <= target) {
				if(j==end) break;
				temp += A[j++];
				if(temp==target) {count++; break;}
			}
		}
		return count;
	}
}
