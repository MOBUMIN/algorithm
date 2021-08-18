package r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class gaussianHeap_11286 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(N,  new Comparator<Integer>() {
			public int compare(Integer w1, Integer w2) {
				if(Math.abs(w1) < Math.abs(w2)) return -1;
				else if(Math.abs(w1) > Math.abs(w2)) return 1;
				else {
					if(w1<w2) return -1;
					else if(w1>w2) return 1;
					else return 0;
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int cmd = Integer.parseInt(br.readLine());
			if(cmd == 0) {
				if(pq.isEmpty()) sb.append(0+"\n");
				else sb.append(pq.poll()+"\n");
			}
			else pq.add(cmd);
		}
		System.out.println(sb);
	}
}
