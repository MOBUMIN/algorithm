package l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class twothousand_1924 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
		int sum = 0;
		for(int i=0; i<M-1; i++) {
			sum+=month[i];
		}
		sum+=D;
		System.out.println(day[sum%7]);
	}
}
