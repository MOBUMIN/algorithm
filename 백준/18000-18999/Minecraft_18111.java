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
		int N = Integer.parseInt(st.nextToken()); // ����
		int M = Integer.parseInt(st.nextToken()); // ����
		int B = Integer.parseInt(st.nextToken()); // ���� ��� ��
		int max_h = 256;
		int min_t = 999999999;
		int avg_h = 0;
		
		/* map �Է� �ޱ� */
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* 256���� ��� ������ ����� ���� ������. */
		for(int i=0; i<=256; i++) {
			int pull = 0; // ��� ����
			int push = 0; // ��� ���� �ֱ�
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					int h = map[j][k] - i;
					if(h>0) pull += h;
					else if(h<0) push -= h;
				}
			}
			/* ������ �׾ƾ��� ��� ������ �κ��丮 ��ϼ��� ���ƾ߸� �ð� ��� */
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
