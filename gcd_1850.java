package d;
import java.util.Scanner;

public class gcd_1850 {
	/* 유클리드 호제법 */
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		long A = scan.nextLong();
		long B = scan.nextLong();
		long ans=0; long temp;
		StringBuilder printans = new StringBuilder();
		
		if(A>B) {
			while(A%B!=0) {
				temp = A%B;
				A=B; B=temp;
			}
			ans = B;
		}
		else if(A<B) {
			while(B%A!=0) {
				temp = B%A;
				B=A; A=temp;
			}
			ans = A;
		}
		else ans = A;
		
		while(ans>0) {
			printans.append("1");
			ans--;
		}
		System.out.println(printans);
		
	}
}
