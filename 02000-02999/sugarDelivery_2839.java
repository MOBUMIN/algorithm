package q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sugarDelivery_2839 {
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int five = N/5; int three = 0; int ans = 0;
		N = N%5;
		while(N>0) {
			if(N%3==0) break;
			else if(five>0) {
				five--;
				N += 5;
			}
			else {
				ans=-1;
				break;
			}
		}
		three = N/3;
		if(ans==-1) System.out.println(ans);
		else System.out.println(five+three);
	}
}
