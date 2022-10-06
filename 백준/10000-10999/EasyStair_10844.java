package m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStair_10844 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] pre = {0,1,1,1,1,1,1,1,1,1};
		double[] now = {0,1,1,1,1,1,1,1,1,1};
		double dev = Math.pow(10, 9);
		for(int j=1; j<N; j++) {
			for(int i=0; i<10; i++) {
				int a = i-1; int b = i+1;
				double a_now=0; double b_now=0;
				if(a != -1) a_now = pre[a];
				if(b != 10) b_now = pre[b];
				now[i] = (a_now+b_now) % dev;
			}
			pre = now.clone();
		}
		/* Array Sum */
		double ans = 0;
		for(int i=0; i<10; i++)
			ans += now[i];
		System.out.println((long)(ans%dev));
	}
}
