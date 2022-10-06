import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * DFS(���� �켱) ���ٰ� �����鼭 �湮, ��ũ�� ����Ʈ �Ẹ��
 * BFS(�ʺ� �켱) ���������� �� �� �ִ°� �湮�ϸ鼭 ť�� ����
 */

 class DFS_link{
	 
	 StringBuilder ans = new StringBuilder();
	 
	 Queue<Integer> q = new LinkedList<Integer>();
	 LinkedList<Integer> list[];
	 boolean visit[];
	 boolean inqueue[];
	 
	 /* linked list ������ ����. �� linked list�� ������ �ϳ��� ������ ��! */
	 DFS_link(int N){ // (������) ������ ����
		 list = new LinkedList[N];
		 visit = new boolean[N]; // ������ �湮�ߴ��� �˱� ����
		 inqueue = new boolean[N]; // ť�� ������ �߰� ���Ϸ���
		 for (int i=0; i<N; i++)
			 list[i] = new LinkedList(); // �������� linkedlist �ϳ���!
	 }
	 
	 /* ���� �� ���� �ֹ����� �����ϴ� �κ� */
	 void connect(int p, int n) {  // (���� ����, �����ų ����)
		 int sizep = list[p].size();
		 int sizen = list[n].size();
		 int positionp = -1;
		 int positionn = -1;
		 /* �̹� ���ִ� �������� ũ�� �� ������ �ڷ� ������ ���� */
		 for(int i=0; i<sizep; i++) 
			 if(list[p].get(i)<n) positionp=i;
		 for(int j=0; j<sizen; j++)
			 if(list[n].get(j)<p) positionn=j;
		 
		 if(positionp==-1) list[p].addFirst(n);
		 else list[p].add(++positionp, n);
		 if(positionn==-1) list[n].addFirst(p);
		 else list[n].add(++positionn, p);
		 }

	 /* dfs Ž�� �ϴ� �� */
	 void dfs(int s) { // ������ 
		 visit[s] = true;
		 ans.append(s+1+" "); // �迭�̶� �� -1 �Ǿ� �־ +1 ����
		 Iterator<Integer> iter = list[s].iterator(); // ��ũ �� ��ŭ �ݺ� ���ִ� ��
		 while(iter.hasNext()) {
			 int next = iter.next();
			 if(!visit[next]) dfs(next); // ���� ������ �湮���� �ʾҴٸ� �湮�Ϸ� ����
		 }
	 }
	 
	 void bfs(int s) {
		 inqueue[s] = true;
		 ans.append(s+1+" ");
		Iterator<Integer> iter = list[s].iterator();
		while(iter.hasNext()) {
			int next = iter.next();
			if(!inqueue[next]) { // ť�� ���� �� next�� ������ �ִٸ� ť�� �� �� �ֱ�!
				q.add(next);
				inqueue[next] = true;
				}
		}
		if(!q.isEmpty()) bfs(q.poll()); // ���� �������� �̵�.
	 }
	 
	 void print() { System.out.println(ans); }
 }

public class dfs_bfs_1260 {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // ���� ��
		int M = Integer.parseInt(st.nextToken()); // ��ũ ��
		int start = Integer.parseInt(st.nextToken()); // ������
		
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
