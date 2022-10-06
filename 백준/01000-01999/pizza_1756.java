package q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pizza_1756 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] oven = new int[D+1];
		int[] dow = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<D; i++) oven[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) dow[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<D-1; i++) {
			if(oven[i] <oven[i+1]) oven[i+1] = oven[i];
		}//  3 2 5 5 5
		int h=D; // 5 5 4 3 3 2 2
		for(int i=0; i<N; i++) {
			for(int j=h-1; j>=-1; j--) {
				if(j==-1) { h=j; break; }
				if(oven[j] < dow[i]) continue;
				else {
					h=j;
					break;
				}
			}
		}
		System.out.println(h+1);
	}
}
