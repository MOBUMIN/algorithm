import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * DFS(깊이 우선) 들어갔다가 나오면서 방문, 링크드 리스트 써보기
 * BFS(너비 우선) 시작점에서 갈 수 있는거 방문하면서 큐에 넣음
 */

 class DFS_link{
	 
	 StringBuilder ans = new StringBuilder();
	 
	 Queue<Integer> q = new LinkedList<Integer>();
	 LinkedList<Integer> list[];
	 boolean visit[];
	 boolean inqueue[];
	 
	 /* linked list 여러개 생성. 각 linked list는 정점당 하나씩 가지는 것! */
	 DFS_link(int N){ // (생성자) 정점의 개수
		 list = new LinkedList[N];
		 visit = new boolean[N]; // 정점을 방문했는지 알기 위해
		 inqueue = new boolean[N]; // 큐에 있으면 추가 안하려고
		 for (int i=0; i<N; i++)
			 list[i] = new LinkedList(); // 정점마다 linkedlist 하나씩!
	 }
	 
	 /* 정점 두 개를 쌍방으로 연결하는 부분 */
	 void connect(int p, int n) {  // (현재 정점, 연결시킬 정점)
		 int sizep = list[p].size();
		 int sizen = list[n].size();
		 int positionp = -1;
		 int positionn = -1;
		 /* 이미 들어가있는 정점보다 크면 그 정점의 뒤로 가도록 정렬 */
		 for(int i=0; i<sizep; i++) 
			 if(list[p].get(i)<n) positionp=i;
		 for(int j=0; j<sizen; j++)
			 if(list[n].get(j)<p) positionn=j;
		 
		 if(positionp==-1) list[p].addFirst(n);
		 else list[p].add(++positionp, n);
		 if(positionn==-1) list[n].addFirst(p);
		 else list[n].add(++positionn, p);
		 }

	 /* dfs 탐색 하는 거 */
	 void dfs(int s) { // 시작점 
		 visit[s] = true;
		 ans.append(s+1+" "); // 배열이라 다 -1 되어 있어서 +1 해줌
		 Iterator<Integer> iter = list[s].iterator(); // 링크 수 만큼 반복 해주는 거
		 while(iter.hasNext()) {
			 int next = iter.next();
			 if(!visit[next]) dfs(next); // 다음 정점을 방문하지 않았다면 방문하러 ㄱㄱ
		 }
	 }
	 
	 void bfs(int s) {
		 inqueue[s] = true;
		 ans.append(s+1+" ");
		Iterator<Integer> iter = list[s].iterator();
		while(iter.hasNext()) {
			int next = iter.next();
			if(!inqueue[next]) { // 큐에 없는 걸 next로 가지고 있다면 큐에 싹 다 넣기!
				q.add(next);
				inqueue[next] = true;
				}
		}
		if(!q.isEmpty()) bfs(q.poll()); // 다음 정점으로 이동.
	 }
	 
	 void print() { System.out.println(ans); }
 }

public class dfs_bfs_1260 {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 정점 수
		int M = Integer.parseInt(st.nextToken()); // 링크 수
		int start = Integer.parseInt(st.nextToken()); // 시작점
		
		DFS_link DFS = new DFS_link(N);
		DFS_link BFS = new DFS_link(N);
		
		int p, n;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			p = Integer.parseInt(st.nextToken())-1;
			n = Integer.parseInt(st.nextToken())-1;
			DFS.connect(p, n);
			BFS.connect(p, n);
		}
		DFS.dfs(start-1);
		BFS.bfs(start-1);
		DFS.print();
		BFS.print();
	}
}
