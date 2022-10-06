package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/* 1000ms �ִµ� 996ms�� ��û �ƽ��ƽ��ϰ� ���(�ּ��̳� ���� ���ݸ� ������ ���� ������ �Ф�) */
class Passenger implements Comparable<Passenger>{
	int x, y, dx, dy, gap;
	Passenger(int x, int y, int dx, int dy, int gap){
		this.x = x; this.y = y;
		this.dx = dx; this.dy = dy;
		this.gap = gap;
	}
	public int compareTo(Passenger t) {
		/*
		 *  1�� return �Ǹ� t�� �켱������ ������ 
		 * �׷��� t�� ���� �� ������ 1�� return �ǵ���!
		 * �ִܰŸ� �� ��, �� �� ��, �� ����.
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
		 * N = map ũ��, M = �°� ���� Driver = �������� ��ġ, ���Ḧ ��Ÿ���� ��ü
		 * map = 0�� ��, 1�� ��
		 * pq = Passenger(��� ��, ��, ���� ��, ��, Driver �ִ� �Ÿ�)
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
		/* �켱������ ���� ���� �°� �������ֱ�! */
		while(!pq.isEmpty()) {
			Passenger p = pq.poll();
			/* �°� ��ġ���� �̵� */
			if(p.gap==INF) { fail = true; break; } // �°����� �� �� ������ ����
			driver.x = p.x; driver.y= p.y; driver.fuel -= p.gap;
			/* �°��� �������� �̵� */
			int f = getDis(driver,p.dx,p.dy);
			if(f == -1) { fail = true; break; } // ���� ���ᰡ �ٴڳ��� ����
			driver.x = p.dx; driver.y= p.dy; driver.fuel += f;
			/* �ִܰŸ� Update */
			pq = gapUpdate(driver,pq);
		}
		if(fail) System.out.println(-1);
		else System.out.println(driver.fuel);
	}
	
	/* Driver�� ��ġ�κ��� ���ϴ� ��ǥ������ �Ÿ��� ���ϴ� �޼��� */
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
				/* ���� : nx,ny�� 1���� ũ�ų� ����, N���� �۰ų� ����. �湮���� �ʾҾ���ϰ�. ���� �ƴϰ�. �ִܰŸ��� fuel���� �۾ƾ���. */
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
