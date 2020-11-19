package d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 프림 알고리즘 */

public class MST_1197 {
	static int INF = 100001;
	
	static class map implements Comparable<map>{
		int V; // 정점 V로 가는
		int W;// 가중치 W
		map(int v, int w){
			this.V = v;
			this.W = w;
		}
		
		public int compareTo(map o) { // 우선순위 큐를 쓰기 위해 오버라이드 해줌, w를 기준으로 우선순위 형성.
			if(this.W > o.getw()) return 1;
			else if(this.W == o.getw()) return 0;
			else return -1;
		}
		public int getw() {
			return W;
		}
	}
	
	static boolean[] visit;
	static LinkedList<map> link[]; // 각 정점마다 가지고 있는 연결 리스트. (정점, 가중치)가 저장됨.
	
	public static void main(String args[]) throws IOException{
		PriorityQueue<map> pq = new PriorityQueue<map>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		/* 정점마다 연결리스트 할당 */
		link = new LinkedList[V+1];
		for(int i=0; i<V+1; i++)
			link[i] = new LinkedList();
		
        visit = new boolean[V+1];
		
        /* 읽어오는 부분 */
		int a,b,c;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a= Integer.parseInt(st.nextToken());
			b= Integer.parseInt(st.nextToken());
			c= Integer.parseInt(st.nextToken());
			
			link[a].add(new map(b,c)); link[b].add(new map(a,c));
		}
		
		int start = 1; // 정점 1에서부터 시작
		visit[start] = true;
		LinkedList first = link[start];
		int fsize = first.size();
		for(int i=0; i<fsize;i++)
			pq.offer((map) first.get(i)); // 시작점에서 갈 수 있는 간선들을 다 우선순위 큐에 넣음. 가장 낮은 수치를 가지는 간선부터 고를 예정.
		
		map next; int nextv, ans =0; int cnt =0 ;
		while(!pq.isEmpty()) {
			next = pq.poll();
			nextv=next.V;
			
			if(visit[nextv]==true) continue;
			ans += next.W;
			cnt++;
			visit[nextv] = true;
			if(cnt > V) break;
			
			/* 내가 방문한 정점의 간선들을 다 pq에 넣음 */
			LinkedList n = link[nextv];
			int nsize = n.size();
			for(int i=0; i<nsize; i++)
				pq.offer((map) n.get(i));
		}
		
		System.out.println(ans);
	}
}
