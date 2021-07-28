package q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class cardSort_1715 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++)
			pq.add(Integer.parseInt(br.readLine()));
		int ans = 0;
		if(N==1) ans = 0;
		else
			while(!pq.isEmpty()) {
				int a = pq.poll();
				int b = pq.poll();
				ans += (a+b);
				if(pq.isEmpty()) break;
				pq.add(a+b);
			}
		System.out.println(ans);
	}
}
