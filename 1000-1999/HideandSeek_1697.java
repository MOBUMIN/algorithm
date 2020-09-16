package f;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class item{
	int pos;
	int cnt;
	item(int pos, int cnt){
		this.pos = pos;
		this.cnt = cnt;
	}
}
public class HideandSeek_1697 {
	static int MAX = 100000;
	static int ans = MAX; static int K;
	static boolean[] visit;
	static Queue<item> q;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		K = scan.nextInt();
		visit = new boolean[MAX+1];
		q = new LinkedList<>();
		
		bfs(N, 0);
	}
	public static void bfs(int n, int cnt) {
		if( n == K) {System.out.println("0"); return;}
		visit[n] = true;
		if(n+1<=MAX) if(visit[n+1] == false) {q.add(new item(n+1, cnt+1)); visit[n+1] = true;}
		if(n-1>=0) if(visit[n-1] == false) {q.add(new item(n-1, cnt+1)); visit[n-1] = true;}
		if(n!=0 && n*2 <= MAX) if(visit[n*2] == false) { q.add(new item(n*2,cnt+1)); visit[n*2] = true;}
		if(!q.isEmpty()) {
			item i = q.poll();
			if(i.pos == K) {
				System.out.println(i.cnt); return;
			}
			bfs(i.pos, i.cnt);	
		}
	}

}
