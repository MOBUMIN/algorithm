package r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class OP implements Comparable<OP> {
	int from;
	int to;
	double gap;
	OP(int f, int t, double g) {
		this.from= f;
		this.to = t;
		this.gap = g;
	}
	@Override
	public int compareTo(OP target) {
        return this.gap <= target.gap ? -1 : 1;
    }
}

public class starLink_4386 {
	static int parent[];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		double[][] map = new double[n][2];
		parent = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[i][0] = Double.parseDouble(st.nextToken());
			map[i][1] = Double.parseDouble(st.nextToken());
			parent[i] = i;
		}
		
		PriorityQueue<OP> kru = new PriorityQueue<>();
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				double cal = Math.pow(map[j][0] - map[i][0], 2) + Math.pow(map[j][1] - map[i][1], 2);
				cal = Math.sqrt(cal);
				kru.add(new OP(i, j, cal));
			}
		}
		
		double ans = 0;
		while(!kru.isEmpty()) {
			OP pos = kru.poll();
			if(Find(pos.from, pos.to)) continue;
			Union(pos.from, pos.to);
			ans += pos.gap;
		}
		
		System.out.println(ans);
	}
	
	public static int getParent(int a) {
		if(a==parent[a])
			return parent[a];
		else return parent[a] = getParent(parent[a]);
	}
	
	public static boolean Find(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);
		if(pa == pb) return true;
		else return false;
	}
	
	public static void Union(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);
		parent[pb] = pa;
	}
}
