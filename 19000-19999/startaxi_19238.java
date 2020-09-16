package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/* 1000ms 주는데 996ms로 엄청 아슬아슬하게 통과(주석이나 뭔가 조금만 느리게 만들어도 실패함 ㅠㅠ) */
class Passenger implements Comparable<Passenger>{
	int x, y, dx, dy, gap;
	Passenger(int x, int y, int dx, int dy, int gap){
		this.x = x; this.y = y;
		this.dx = dx; this.dy = dy;
		this.gap = gap;
	}
	public int compareTo(Passenger t) {
		/*
		 *  1이 return 되면 t가 우선순위가 높아짐 
		 * 그래서 t의 값이 더 작을때 1이 return 되도록!
		 * 최단거리 비교 후, 행 비교 후, 열 비교함.
		 */
		if(this.gap > t.gap) return 1;
		else if(this.gap<t.gap)return -1;
		else {
			if(this.x>t.x) return 1;
			else if(this.x<t.x) return -1;
			else {
				if(this.y>t.y) return 1;
				else if(this.y<t.y) return-1; 
			}
		}
		return 0;
	}
}
class Driver{
	int x,y,fuel;
	Driver(int x,int y,int f){
		this.x = x; this.y =y; this.fuel = f;
	}
}
class pos{
	int x,y,g;
	pos(int x,int y,int g){ this.x=x; this.y=y; this.g=g;}
}
public class startaxi_19238 {
	static int[][] map;
	static int N;
	static int[] mx = {0,0,-1,1};
	static int[] my = {-1,1,0,0};
	static int INF = 5000000;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		/* 
		 * N = map 크기, M = 승객 개수 Driver = 운전사의 위치, 연료를 나타내는 객체
		 * map = 0은 길, 1은 벽
		 * pq = Passenger(출발 행, 열, 도착 행, 열, Driver 최단 거리)
		 */
		N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		Driver driver = new Driver(0,0,Integer.parseInt(st.nextToken()));
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		driver.x= Integer.parseInt(st.nextToken()); driver.y= Integer.parseInt(st.nextToken());
		PriorityQueue<Passenger> pq = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			Passenger p = new Passenger(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
			p.gap = getDis(driver,p.x,p.y);
			if(p.gap == -1) p.gap = INF;
			pq.add(p);
		}
		boolean fail = false;
		/* 우선순위가 가장 높은 승객 데려다주기! */
		while(!pq.isEmpty()) {
			Passenger p = pq.poll();
			/* 승객 위치까지 이동 */
			if(p.gap==INF) { fail = true; break; } // 승객에게 갈 수 없으면 실패
			driver.x = p.x; driver.y= p.y; driver.fuel -= p.gap;
			/* 승객의 목적지로 이동 */
			int f = getDis(driver,p.dx,p.dy);
			if(f == -1) { fail = true; break; } // 만약 연료가 바닥나면 실패
			driver.x = p.dx; driver.y= p.dy; driver.fuel += f;
			/* 최단거리 Update */
			pq = gapUpdate(driver,pq);
		}
		if(fail) System.out.println(-1);
		else System.out.println(driver.fuel);
	}
	
	/* Driver의 위치로부터 원하는 좌표까지의 거리를 구하는 메서드 */
	public static int getDis(Driver d, int dx, int dy) {
		boolean[][] visit = new boolean[N+1][N+1];
		Queue<pos> Q = new LinkedList<>();
		Q.add(new pos(d.x,d.y,0));
		visit[d.x][d.y]=true;
		int gap = -1;
		while(!Q.isEmpty()) {
			pos pos = Q.poll();
			if(pos.x==dx && pos.y==dy) {
				gap = pos.g; break; 
			}
			for(int i=0; i<4; i++) {
				int nx = pos.x+mx[i];
				int ny = pos.y+my[i];
				int ng = pos.g+1;
				/* 조건 : nx,ny가 1보다 크거나 같고, N보다 작거나 같고. 방문하지 않았어야하고. 벽이 아니고. 최단거리가 fuel보다 작아야함. */
				if(nx>=1 && nx<=N && ny>=1 && ny<=N && !visit[nx][ny] && map[nx][ny] != 1 && ng<=d.fuel){
					Q.add(new pos(nx,ny,ng)); visit[nx][ny] = true;
					}
			}
		}
		return gap;
	}
	
	public static PriorityQueue<Passenger> gapUpdate(Driver d, PriorityQueue<Passenger> pq) {
		Queue<Passenger> temp = new LinkedList<>();
		while(!pq.isEmpty()) temp.add(pq.poll());
		while(!temp.isEmpty()) {
			Passenger p = temp.poll();
			p.gap = getDis(d,p.x,p.y);
			if(p.gap==-1) p.gap = INF;
			pq.add(p);
		}
		return pq;
	}
}
