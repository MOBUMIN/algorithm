package d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* ���� �˰��� */

public class MST_1197 {
	static int INF = 100001;
	
	static class map implements Comparable<map>{
		int V; // ���� V�� ����
		int W;// ����ġ W
		map(int v, int w){
			this.V = v;
			this.W = w;
		}
		
		public int compareTo(map o) { // �켱���� ť�� ���� ���� �������̵� ����, w�� �������� �켱���� ����.
			if(this.W > o.getw()) return 1;
			else if(this.W == o.getw()) return 0;
			else return -1;
		}
		public int getw() {
			return W;
		}
	}
	
	static boolean[] visit;
	static LinkedList<map> link[]; // �� �������� ������ �ִ� ���� ����Ʈ. (����, ����ġ)�� �����.
	
	public static void main(String args[]) throws IOException{
		PriorityQueue<map> pq = new PriorityQueue<map>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken()); // ������ ����
		int E = Integer.parseInt(st.nextToken()); // ������ ����
		
		/* �������� ���Ḯ��Ʈ �Ҵ� */
		link = new LinkedList[V+1];
		for(int i=0; i<V+1; i++)
			link[i] = new LinkedList();
		
        visit = new boolean[V+1];
		
        /* �о���� �κ� */
		int a,b,c;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a= Integer.parseInt(st.nextToken());
			b= Integer.parseInt(st.nextToken());
			c= Integer.parseInt(st.nextToken());
			
			link[a].add(new map(b,c)); link[b].add(new map(a,c));
		}
		
		int start = 1; // ���� 1�������� ����
		visit[start] = true;
		LinkedList first = link[start];
		int fsize = first.size();
		for(int i=0; i<fsize;i++)
			pq.offer((map) first.get(i)); // ���������� �� �� �ִ� �������� �� �켱���� ť�� ����. ���� ���� ��ġ�� ������ �������� �� ����.
		
		map next; int nextv, ans =0; int cnt =0 ;
		while(!pq.isEmpty()) {
			next = pq.poll();
			nextv=next.V;
			
			if(visit[nextv]==true) continue;
			ans += next.W;
			cnt++;
			visit[nextv] = true;
			if(cnt > V) break;
			
			/* ���� �湮�� ������ �������� �� pq�� ���� */
			LinkedList n = link[nextv];
			int nsize = n.size();
			for(int i=0; i<nsize; i++)
				pq.offer((map) n.get(i));
		}
		
		System.out.println(ans);
	}
}
