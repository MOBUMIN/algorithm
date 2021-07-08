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
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for(int i=0; i<T; i++) {
			// 숫자 받아오기
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			int K = Integer.parseInt(st.nextToken()); // 배추 위치 개수
			int sect = 0; //벌레 개수
			map = new int[M][N]; // 배추 지도
			Queue<pos> togo = new LinkedList<>(); // 모든 좌표 담기
			
			// 위치 좌표 받기!
			for(int j=0; j<K; j++) {
				st  = new StringTokenizer(br.readLine(), " ");
				pos p = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				map[p.x][p.y] = 1;
				togo.add(p);
			}
			// 본격적으로 찾기!
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
		Queue<pos> next = new LinkedList<>(); // bfs 용 큐
		next.add(start);
		
		while(!next.isEmpty()) {
			pos p = next.poll();
			/* 상 */
			if(p.x>0)
				if(map[p.x-1][p.y] == 1) {
					map[p.x-1][p.y]=-1;
					next.add(new pos(p.x-1,p.y));
				}
			/* 하 */
			if(p.x<M-1)
				if(map[p.x+1][p.y]==1) {
					map[p.x+1][p.y]=-1;
					next.add(new pos(p.x+1,p.y));
				}
			/* 좌 */
			if(p.y>0)
				if(map[p.x][p.y-1]==1) {
					map[p.x][p.y-1]=-1;
					next.add(new pos(p.x, p.y-1));
				}
			/* 우 */
			if(p.y<N-1)
				if(map[p.x][p.y+1]==1) {
					map[p.x][p.y+1]=-1;
					next.add(new pos(p.x, p.y+1));
				}
		}
	}
}
