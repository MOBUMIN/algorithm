package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gumjeong_2475 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] num = new int[5];
		int ans = 0;
		for(int i=0; i<5; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			ans += num[i]*num[i];
		}
		System.out.println(ans%10);
	}
}
