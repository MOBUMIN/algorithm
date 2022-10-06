package g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 1697.수빈이 숨바꼭질 문제 참조함 */

class item{
	int pos; int cnt;
	item(int p, int c){
		this.pos = p;
		this.cnt = c;
	}
}
public class Escape_16397 {
	static int  MAX = 100000;
	static int ans = 100000;
	static boolean[] visit;
	static Queue<item> q;
	static int G,T;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 현재 숫자
		T = Integer.parseInt(st.nextToken()); // 최대 시도 횟수
		G = Integer.parseInt(st.nextToken()); // 목표 숫자
		
		visit = new boolean[MAX];
		q = new LinkedList<>();
		q.add(new item(N,0));
		visit[N] = true;
		bfs();
		
		if(N == G) System.out.println("0");
		else if(ans > T) System.out.println("ANG");
		else System.out.println(ans);
	}
	/* 숨바꼭질에서 썼던 야매 bfs ( 재귀 ) 는 자꾸 stack over flow나서 while로 고쳤떠니 성공. */
	public static void bfs() {
		while(!q.isEmpty()) {
		item i = q.poll();
		if(i.cnt > T) break;
		if(i.pos == G) {
			ans = i.cnt; break;
		}
		visit[i.pos] = true;
		if(i.pos+1 < MAX && !visit[i.pos+1]) q.add(new item(i.pos+1, i.cnt+1));
		if(i.pos*2<MAX && !visit[Bbtn(i.pos)]) q.add(new item(Bbtn(i.pos), i.cnt+1));
		}
	}
	public static int Bbtn(int pos) {
		if(pos==0) return 0;
		pos = pos*2;
		if(pos/10 != 0) {
			if(pos/100 != 0) {
				if(pos/1000 != 0) {
					if(pos/10000 != 0)
						return pos-10000;
					return pos-1000;
				} return pos-100;
			} return pos-10;
		} return pos-1;
	}
}
