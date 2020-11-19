package k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Building implements Comparable<Building>{
	int i;
	int degree;
	int time;
	Stack<Integer> input = new Stack<>();
	Building(int N,int i) {this.i = i;this.degree = 0;}
	@Override
	public int compareTo(Building t) {
		if(this.degree>t.degree) return 1;
		else if(this.degree<t.degree) return -1;
		return 0;
	}
}
public class gamedevelop_1516 {
	public static void main(String args[]) throws IOException{
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Building> q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		Building[] building = new Building[N+1];
		int[] ans = new int[N+1];
		
		for(int i=1; i<=N; i++) 
			building[i] = new Building(N, i);
		
		for(int i=1; i<=N; i++) {
			q.add(building[i]);
			st = new StringTokenizer(br.readLine()," ");
			building[i].time = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				if(n!=-1) {
					building[i].degree++;
					building[n].input.add(i);
				}
			}
		}
		
		while(!q.isEmpty()) {
			Building b = q.poll();
			if(b.degree != 0) {q.add(b); continue;}
			ans[b.i] += b.time; 
			while(!b.input.isEmpty()) {
				int p = b.input.pop();
				building[p].degree--; 
				ans[p] = Math.max(ans[p], ans[b.i]);
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int j=1; j<=N; j++) sb.append(ans[j] + "\n");
		System.out.println(sb);

	}
}
