package h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int a; int b; double w;
	Edge(int a, int b, double w){
		this.a=a; this.b=b; this.w=w;
	}
	public int compareTo(Edge o) {
		if(this.w<o.w) return -1;
		else if(this.w>o.w)return 1;
		return 0;
	}
}
class mapp{
	double x; double y;
	mapp(double x, double y){
		this.x=x; this.y=y;
	}
}
/* 프림으로 구현하려고 했으나 이미 다 그루핑되어 있으면 탐색 불가, kruskal로 변경함 */
public class spacegod_1774 {
	public static int getParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent[x]);
	}
	public static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a<b) parent[b] = a;
		else parent[a]=b;
	}
	public static int findParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a==b) return 1; else return 0;
	}
	public static double getDis(int a, int b) {
		double x = Math.abs(co[a].x-co[b].x);
		double y = Math.abs(co[a].y-co[b].y);
		double r = x*x + y*y;
		r = Math.sqrt(r);
		return r;
	}
	static mapp[] co;
	static int[] parent;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		/* N  = 점개수, M = 이미 연결된 통로 개수*/
		int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		co = new mapp[N+1]; // 좌표를 담을 배열
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		parent = new int[N+1];
		double len = 0; // 정답, 연결된 통로의 최소값 
		
		/* parent 초기화 */
		for(int i=1; i<=N;i++)
			parent[i]=i;
		/* co에 좌표 담기 */
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			co[i] = new mapp(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}
		/* pq에 간선 담기 (모든 점-점 거리) */
		boolean[] visit = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			visit[i] = true;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(visit[j]) continue;
				pq.offer(new Edge(i,j,getDis(i,j)));
			}
		}
		/* 이미 연결되어 있는 점들 처리 */
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
			unionParent(a,b);
			}
		Edge next;
		while(!pq.isEmpty()) {
			next = pq.poll();
			if(findParent(next.a,next.b)==0) { // 부모가 다르면
				len+=next.w;
				unionParent(next.a,next.b);
			}
		}
		/* 질문에 있던 소수점 둘째까지 출력하는 부분 */
		System.out.printf("%.2f",(double)Math.round(len*100)/100);
	}
}
