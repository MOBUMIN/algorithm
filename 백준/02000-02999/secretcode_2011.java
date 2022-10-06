package h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class secretcode_2011 {
	static int[] dp;
	static int[] s;
	static int len;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		len = str.length+1;
		s = new int[len];
		dp = new int[len];
		for(int i =1; i<len; i++) s[i] = Integer.parseInt(str[i-1]);
		dp[0] = 1; dp[1] = 1;
		int error = 0; // 0�� �������� �� ���. ������ 0�� ���(���ڰ� �ѱ����϶��� ����ؾ���), 30 40...
		if(s[1]==0) error++;
		else {
			for(int i=2; i<len; i++) {
				if(s[i] ==0 && s[i-1]==0) {error++; break;}
				if(s[i] ==0 && s[i-1]>2) {error++; break;}
				dp[i] = dp[i-1];
				int j = s[i-1]*10 + s[i];
				/* 1�� �ڸ����� 0�� ��� Ȥ�� 10�� �ڸ����� 0�� ���� ���� */
				if(i<len-1) {
					if(s[i+1] != 0) if(s[i] !=0 && j>10 && j<27) dp[i] += dp[i-2];
				}
				else if(s[i] !=0 && j>10 && j<27) dp[i] += dp[i-2];
				dp[i] %= 1000000;
			}
		}
		if(error>0) System.out.println("0");
		else System.out.println(dp[len-1]);
	}
}
