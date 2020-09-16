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
		
		/* 숫자 배열 읽어오기 */
		A = new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		/* 연산자 개수 읽어오기 */
		int[] op = new int[4];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<4; i++) op[i] = Integer.parseInt(st.nextToken());
		
		/* 브루트 포스 반복 (위치, 연산자 개수, 이전까지의 계산 답)*/
		iteration(0, op, A[0]);
		System.out.println(MAX + "\n" + MIN);
		
	}
	private static void iteration(int pos, int[] op, int ans) {
		boolean[] visit = new boolean[4];
		int temp = ans;
		if(pos+1 == N) { // 숫자 배열이 끝남!
			MAX = Math.max(MAX, ans);
			MIN = Math.min(MIN, ans);
			return;
		}
		for(int i=0; i<4; i++) {
			/* 해당 연산자를 방문 x && 해당 연산자가 남아 있을 때 */
			if(visit[i] == false && op[i] > 0) {
				visit[i] = true;
				switch(i) {
				case 0 : // PLUS
					ans += A[pos+1];
					op[i]--;
					iteration(pos+1, op, ans);
					op[i]++; ans = temp;  // 다음 연산자를 탐색할 때를 위해 원래 값으로 돌려놓기
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
					if(ans < 0) { // 음수일 때는 지문에 나온대로 - 붙여주기
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
