package m;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Minecraft_18111 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int B = Integer.parseInt(st.nextToken()); // 가진 블록 수
		int max_h = 256;
		int min_t = 999999999;
		int avg_h = 0;
		
		/* map 입력 받기 */
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* 256까지 모든 높이의 경우의 수를 따진다. */
		for(int i=0; i<=256; i++) {
			int pull = 0; // 블록 제거
			int push = 0; // 블록 꺼내 넣기
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					int h = map[j][k] - i;
					if(h>0) pull += h;
					else if(h<0) push -= h;
				}
			}
			/* 꺼내서 쌓아야할 블록 수보다 인벤토리 블록수가 많아야만 시간 계산 */
			if(push <= B+pull) {
				int t = pull*2 + push;
				if(t<=min_t) {
					min_t = t;
					avg_h = i;
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = min_t + " " + avg_h;
		bw.write(s);
		bw.flush();
		bw.close();
	}
}
