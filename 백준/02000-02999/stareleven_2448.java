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
		
		/* ù �ﰢ���� ���ܷ� �̸� ���� star �� �־��.*/
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
			/* ���� �������� ���*/
			if(star[a-1][b+i] == '*' && star[a-1][b+i-1] == ' ') {
				if(star[a-1][b+i-2] != '*')
					make(a,b+i-1);
			}
			/* ������ �������� ��� */
			else if(star[a-1][b+i] == '*' && star[a-1][b+i+1] == ' ') {
				if(star[a-1][b+i+2] != '*')
					make(a,b+i+1);
			}
		}
		find(a+3,0); // �ﰢ���� ���� �������� ����� �˷��ֱ�!
	}
	public static void make(int a, int b) {
		// a : �ﰢ���� �� ���� ��ġ
		// b : �ﰢ���� �� ���� ��ġ
		star[a][b] = '*';
		star[a+1][b-1] = '*';
		star[a+1][b+1] = '*';
		for(int i=0; i<5; i++)
			star[a+2][b-2+i] = '*';
		
	}
}
