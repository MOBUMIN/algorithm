package p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class SE implements Comparable<SE> {
	int s;
	int e;
	SE(int s, int e){
		this.s=s;
		this.e=e;
	}
	@Override
    public int compareTo(SE se) {
         if (this.e < se.e) {
             return -1;
         } else if (this.e == se.e) {
        	 if(this.s < se.s)
        		 return -1;
        	 else if(this.s > se.s)
        		 return 1;
             return 0;
         } else {
             return 1;
         }
     }
}

public class meetingRoom_1931 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		SE sch[] = new SE[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sch[i] = new SE(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(sch);
		int ans = 1; int selected = 0;
		for(int i=1; i<N; i++) {
			if(sch[selected].e <= sch[i].s) {
				ans++;
				selected = i;
			}
		}
		System.out.println(ans);
	}
}
