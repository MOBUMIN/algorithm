package l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Fish implements Comparable<Fish>{
	int r, c, size;
	int gap;
	Fish(int r, int c, int size){
		this.r=r; this.c=c; this.size=size;
	}
	@Override
	public int compareTo(Fish t) {
		// return 1이 되는 수가 밑으로 내려감

		if(gap>t.gap) return 1;
		else if(gap<t.gap) return -1;
		else {
			if(r>t.r) return 1;
			else if(r<t.r) return -1;
			else {
				if(c>t.c) return 1;
				else return -1;
			}
		}
	}
}
class Shark{
	int r, c;
	int size = 2;
	int eat = 0;
	Shark(int r, int c){
		this.r=r; this.c=c;
	}
}

class pos{
	int r,c;
	int cnt;
	pos(int r, int c,int cnt){this.r=r; this.c=c; this.cnt=cnt;}
}

public class BabyShark_16236 {
	static int time = 0;
	static int N;
	static int[][] map;
	static int[] dx = {0,-1,1,0};
	static int[] dy = {-1,0,0,1};
	static Shark shark = new Shark(0,0);
	static Queue<Fish> fish = new LinkedList<>();
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 공간의 크기
		map = new int[N][N]; // 공간
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) continue;
				if(map[i][j] == 9) shark = new Shark(i,j);
				else fish.add(new Fish(i,j,map[i][j]));
			}
		}
		
		PriorityQueue<Fish> prey = HowMany();
		
		if(prey.size() == 0) System.out.println(time);
		else if(prey.size() == 1) {
			System.out.println(BFS(prey.poll()));
		}
		else {
			map[shark.r][shark.c]=0;
			while(!prey.isEmpty()) {
				Fish p = prey.poll();
				time += BFS(p);
				Grow(p);
				while(!prey.isEmpty()) fish.add(prey.poll());
				prey = HowMany();
			}
			System.out.println(time);
		}
		
	}
	
	/* 현재 shark 가 먹을 수 있는 fish 고르기. */
	public static PriorityQueue<Fish> HowMany() {
		PriorityQueue<Fish> prey = new PriorityQueue<>();
		Queue<Fish> copy = new LinkedList<>();
		while(!fish.isEmpty()) {
			Fish temp = fish.poll();
			if(temp.size<shark.size) {
				temp.gap=BFS(temp);
				if(temp.gap>0)
					prey.add(temp);
				else copy.add(temp);
			}
			else copy.add(temp);
		}
		fish = copy;
		return prey;
	}
	
	/* shark -> fish 거리 구하기 */
	public static int BFS(Fish fish) {
		Queue<pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new pos(shark.r,shark.c,0));
		visited[shark.r][shark.c]=true;
		int cnt = 0;
		while(!q.isEmpty()) {
			pos now = q.poll();
			if(now.r==fish.r && now.c==fish.c) {
				cnt=now.cnt; break; 
			}
			for(int i=0; i<4; i++) {
				int nextr = now.r+dy[i];
				int nextc = now.c+dx[i];
				if(0<=nextr && nextr<N && 0<=nextc && nextc<N && !visited[nextr][nextc] && shark.size>=map[nextr][nextc]) {
					q.add(new pos(nextr,nextc,now.cnt+1));
					visited[nextr][nextc] = true;
				}
			}
		}
		
		return cnt;
	}
	/*shark가 먹이를 먹고 크기를 키움*/
	public static void Grow(Fish prey) {
		shark.eat++;
		if(shark.size==shark.eat) {
			shark.eat=0; shark.size++;
		}
		shark.r=prey.r; shark.c=prey.c;
		map[prey.r][prey.c]= 0; 
	}
}
