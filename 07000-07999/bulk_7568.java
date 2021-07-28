package q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class bulk {
	int x, y, r;
	bulk(int x, int y, int r){
		this.x = x; this.y = y; this.r = r;
	}
}

public class bulk_7568 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder ans = new StringBuilder("");
		int N = Integer.parseInt(br.readLine());
		bulk[] arr = new bulk[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int rank = 1;
			arr[i] = new bulk(x,y,rank);
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(arr[i].x < arr[j].x && arr[i].y < arr[j].y)
					arr[i].r++;
			}
			ans.append(arr[i].r+" ");
		}
		System.out.println(ans);
	}
}
