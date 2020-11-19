package l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class docu{
	int i; int v;
	docu(int i, int v){
		this.i=i; this.v=v;
	}
}

public class PrinterQ_1966 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken()); // 개수
			int m = Integer.parseInt(st.nextToken()); // 위치
			Queue<docu> q = new LinkedList<>(); // 중요도 큐
			int[] key = new int[10]; // 중요도 분포
			init(key);
			st = new StringTokenizer(br.readLine()," ");
			int j=0;
			while(st.hasMoreTokens()) { 
				int k = Integer.parseInt(st.nextToken());
				key[k]++;
				q.add(new docu(j++,k));
				}
			find(n,m,q,key);
		}
	}
	public static void init(int[] k) {
		for(int i=0; i<10; i++) k[i] = 0;
	}
	public static void find(int n, int m, Queue<docu> q, int[] k) {
		int ans = 0;
		allout:
		while (true) {
			int max = find_key(k);
			while (true) {
				docu d = q.poll();
				if(d.v == max) {
					k[d.v]--; ans++;
					if(d.i==m) break allout;
					break;
				}
				q.add(d);
			}
		}
		System.out.println(ans);
	}
	public static int find_key(int[] k) {
		int max = 1;
		for(int i=1; i<10; i++) {
			if(k[i] > 0) max = i;
		}
		return max;
	}
}
