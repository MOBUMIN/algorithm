package o;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class pos {
	int x;
	int y;

	pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class OrganicCabbage_1012 {
	static int M, N;
	static int[][] map;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� ����
		
		for(int i=0; i<T; i++) {
			// ���� �޾ƿ���
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken()); // ���α���
			N = Integer.parseInt(st.nextToken()); // ���α���
			int K = Integer.parseInt(st.nextToken()); // ���� ��ġ ����
			int sect = 0; //���� ����
			map = new int[M][N]; // ���� ����
			Queue<pos> togo = new LinkedList<>(); // ��� ��ǥ ���
			
			// ��ġ ��ǥ �ޱ�!
			for(int j=0; j<K; j++) {
				st  = new StringTokenizer(br.readLine(), " ");
				pos p = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				map[p.x][p.y] = 1;
				togo.add(p);
			}
			// ���������� ã��!
			while(!togo.isEmpty()) {
				pos p = togo.poll();
				if(map[p.x][p.y]== -1) continue;
				sect++;
				Search(p);
			}
			
			System.out.println(sect);
		}
	}
	public static void Search(pos start) {
		Queue<pos> next = new LinkedList<>(); // bfs �� ť
		next.add(start);
		
		while(!next.isEmpty()) {
			pos p = next.poll();
			/* �� */
			if(p.x>0)
				if(map[p.x-1][p.y] == 1) {
					map[p.x-1][p.y]=-1;
					next.add(new pos(p.x-1,p.y));
				}
			/* �� */
			if(p.x<M-1)
				if(map[p.x+1][p.y]==1) {
					map[p.x+1][p.y]=-1;
					next.add(new pos(p.x+1,p.y));
				}
			/* �� */
			if(p.y>0)
				if(map[p.x][p.y-1]==1) {
					map[p.x][p.y-1]=-1;
					next.add(new pos(p.x, p.y-1));
				}
			/* �� */
			if(p.y<N-1)
				if(map[p.x][p.y+1]==1) {
					map[p.x][p.y+1]=-1;
					next.add(new pos(p.x, p.y+1));
				}
		}
	}
}
