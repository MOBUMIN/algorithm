package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class remote_1107 {
	static boolean[] F;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		F = new boolean[10];
		if(M>0) {
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<M; i++) F[Integer.parseInt(st.nextToken())] = true;
		}
		int ch=100, plus=N,minus=N, ans=Math.abs(100-N);
		if(ans == 0 ) ans = 0;
		else if(M!=10) {
			while (true) {
				if(minus>=0) {
					if(check(minus--)) {
						ch= minus+1; break;
					}
				}
				if(check(plus++)) {
					ch = plus-1; break;
				}
			}
			//System.out.println(ch);
			if(ch==0)
				ans = Math.min(ans, Math.abs(N-ch)+1);
			else
				ans = Math.min(ans, Math.abs(N-ch)+(int)(Math.log10(ch)+1));
		}
		System.out.println(ans);
	}
	public static boolean check(int n) {
		if(n==0) return !F[n];
		int len = (int)(Math.log10(n)+1);
		for(int i=0; i<len; i++) {
			int a = n%10;
			n/=10;
			if(F[a]) return false;
		}
		return true;
	}
}
