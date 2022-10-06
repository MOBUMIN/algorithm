package p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PosWithQ {
	int pos;
	String cmd = "";
	PosWithQ(int pos, String c){
		this.pos = pos;
		if(c != "X") cmd = cmd + c;
	}
}

public class DSLR_9019 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int reg[] = new int[10000];
			boolean visited[] = new boolean[10000];
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			Queue<PosWithQ> bfs = new LinkedList();
			bfs.add(new PosWithQ(from, "X"));
			while(!bfs.isEmpty()) {
				PosWithQ pos = bfs.poll();
				if(pos.pos == to) { System.out.println(pos.cmd); break; }
				if(visited[pos.pos]) continue;
				visited[pos.pos] = true; 
				bfs.add(D(pos)); bfs.add(S(pos));
				bfs.add(L(pos)); bfs.add(R(pos));
			}
		}
	}
	public static PosWithQ D(PosWithQ pos) {
		int newVal = pos.pos*2;
		if(newVal>9999) newVal %= 10000;
		PosWithQ newPos = new PosWithQ(newVal, pos.cmd+'D');
		return newPos;
	}
	public static PosWithQ S(PosWithQ pos) {
		int newVal = pos.pos-1;
		if(newVal<0) newVal = 9999;
		PosWithQ newPos = new PosWithQ(newVal, pos.cmd + 'S');
		return newPos;
	}
	public static PosWithQ L(PosWithQ pos) {
		int newVal = pos.pos*10;
		if(newVal>9999) {
			int temp = newVal/10000;
			newVal += temp;
			newVal %= 10000;
		}
		PosWithQ newPos = new PosWithQ(newVal, pos.cmd + 'L');
		return newPos;
	}
	public static PosWithQ R(PosWithQ pos) {
		int newVal = pos.pos/10;
		int temp = pos.pos%10;
		newVal += temp*1000;
		PosWithQ newPos = new PosWithQ(newVal, pos.cmd + 'R');
		return newPos;
	}
}
