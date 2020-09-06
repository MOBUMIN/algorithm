package h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class inkacalender_6064 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int M, N, x, y,last, b, s;
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine()," ");
			M= Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
			x= Integer.parseInt(st.nextToken()); y = Integer.parseInt(st.nextToken());
			last = getLast(M,N); // M.N의 최소 공배수가 last year
			if(M>N) { b=x; s=y; int temp = M; M= N; N=temp;}
			else {b=y; s=x;}
			while(b!=s) {
				while(b-s>=M) s+=M;
				if(b==s) break;
				s+=M; b+=N;
				if(b>last) break;
			}
			if(b>last) System.out.println("-1");
			else System.out.println(b);
		}
	}
	public static int getLast(int a, int b) {
		int big, small;
		if(a>b) {big =a; small = b;}
		else {big = b; small=a;}
		int gcd=gcd(big,small);
		return big*small/gcd;
	}
	public static int gcd(int b, int s) {
		if(b%s == 0) return s;
		return gcd(s, b%s);
	}
}
