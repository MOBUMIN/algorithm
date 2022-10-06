package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class operator_14888 {
	static int N;
	static int[] A;
	static int MAX = -(int) Math.pow(10, 9);
	static int MIN = (int) Math.pow(10, 9);
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		/* ���� �迭 �о���� */
		A = new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		/* ������ ���� �о���� */
		int[] op = new int[4];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<4; i++) op[i] = Integer.parseInt(st.nextToken());
		
		/* ���Ʈ ���� �ݺ� (��ġ, ������ ����, ���������� ��� ��)*/
		iteration(0, op, A[0]);
		System.out.println(MAX + "\n" + MIN);
		
	}
	private static void iteration(int pos, int[] op, int ans) {
		boolean[] visit = new boolean[4];
		int temp = ans;
		if(pos+1 == N) { // ���� �迭�� ����!
			MAX = Math.max(MAX, ans);
			MIN = Math.min(MIN, ans);
			return;
		}
		for(int i=0; i<4; i++) {
			/* �ش� �����ڸ� �湮 x && �ش� �����ڰ� ���� ���� �� */
			if(visit[i] == false && op[i] > 0) {
				visit[i] = true;
				switch(i) {
				case 0 : // PLUS
					ans += A[pos+1];
					op[i]--;
					iteration(pos+1, op, ans);
					op[i]++; ans = temp;  // ���� �����ڸ� Ž���� ���� ���� ���� ������ ��������
					break;
				case 1 : // MINUS
					ans -= A[pos+1];
					op[i]--;
					iteration(pos+1, op, ans);
					op[i]++; ans = temp;
					break;
				case 2 : // MUL
					ans *= A[pos+1];
					op[i]--;
					iteration(pos+1, op, ans);
					op[i]++; ans = temp; 
					break;
				case 3 : // DEV
					if(ans < 0) { // ������ ���� ������ ���´�� - �ٿ��ֱ�
						ans = Math.abs(ans);
						ans /= A[pos+1];
						ans = 0-ans;
					}
					else if(ans ==0) ans = 0;
					else ans /= A[pos+1];
					op[i]--;
					iteration(pos+1, op, ans);
					op[i]++; ans = temp;
					break;
				}
			}
		}
	}
}
