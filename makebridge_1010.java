/*
 * 1010번 문제
 * 그냥 조합 문제였지만, 나는 조합을 생각 못하고 계속 노가다를 했었다.
 * 오버플로우를 처리해야했다.
 */

import java.util.Scanner;


public class makebridge_1010 {
	
	public static double factorial(int z) {
		if(z==0) return 1;
		double sum=1;
		while(z>0) {
				sum*=z;
				z--;
			}
		return sum;
	}
	
	public static double halfac(int boy, int mom) {
		int mom2 = boy-mom;
		double sum=1;
		
		if(mom>mom2) {
			int i = boy-mom;
			for(;i>0;i--)
				sum*=boy--;
			sum=sum/factorial(mom2);
		}
		else {
			int i = boy-mom2;
			for(;i>0;i--)
				sum*=boy--;
			sum=sum/factorial(mom);
		}
		return sum;
	}
	
	public static double cal( int arr1, int arr2) {
		
		double ans;
		
		if(arr1==1)
			return arr2;
		
		if(arr1==arr2)
			return 1;
		
		ans = halfac(arr2,arr1);
		
		return ans;
	}
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int n,m;
		double ans;
		
		for(int i=0; i<T; i++) {
			n = scan.nextInt();
			m = scan.nextInt();
			ans = cal(n,m);
			System.out.println((int)ans);
		}
		
	}
	
}
