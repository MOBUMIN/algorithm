package j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class stareleven_2448 {
	static int N;
	static char[][] star;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		star = new char[N][N*2-1];
		for(int i=0; i<N; i++)
			for(int j=0; j<N*2-1; j++)
				star[i][j] = ' ';
		
		/* 첫 삼각형만 예외로 미리 만들어서 star 에 넣어둠.*/
		make(0,N-1);
		find(3,N-3);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N*2-1; j++)
				sb.append(star[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void find(int a, int b) {
		if(a>=N) return;
		for(int i=0; i<N*2-1; i++) {
			if(b+i>=N*2-1) break;
			/* 왼쪽 꼭짓점인 경우*/
			if(star[a-1][b+i] == '*' && star[a-1][b+i-1] == ' ') {
				if(star[a-1][b+i-2] != '*')
					make(a,b+i-1);
			}
			/* 오른쪽 꼭짓점인 경우 */
			else if(star[a-1][b+i] == '*' && star[a-1][b+i+1] == ' ') {
				if(star[a-1][b+i+2] != '*')
					make(a,b+i+1);
			}
		}
		find(a+3,0); // 삼각형의 왼쪽 꼭짓점이 어딘지 알려주기!
	}
	public static void make(int a, int b) {
		// a : 삼각형의 행 시작 위치
		// b : 삼각형의 열 시작 위치
		star[a][b] = '*';
		star[a+1][b-1] = '*';
		star[a+1][b+1] = '*';
		for(int i=0; i<5; i++)
			star[a+2][b-2+i] = '*';
		
	}
}
