package n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hansu_1065 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i=1;i<=N; i++) {
			if(isSequence(i)) count++;
		}
		
		System.out.println(count);
	}
	
	public static boolean isSequence(int n) {
		int size = sizeof(n);
		if(size==1) return true;
		
		// 각 자리수를 digit에 담기
		int[] digit;
		digit= new int[size];
		for(int i=1; i<=size; i++) {
			digit[i-1] = (int) (n/(Math.pow(10, size-i)));
			n %= (Math.pow(10, size-i));
		}
		
		// 각 자리수 별 차이가 같은지 보기.
		int diff = digit[0] - digit[1];
		for(int i=1; i<size-1; i++) {
			if(diff != digit[i]-digit[i+1]) return false;
		}
		return true;
	}
	
	public static int sizeof(int i) {
		if(i/10 == 0) return 1;
		else if(i/100==0) return 2;
		else if(i/1000 ==0) return 3;
		else return 4;
	}
}
