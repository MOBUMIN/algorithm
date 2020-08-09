package d;
import java.util.Scanner;

public class factorialfive_1564 {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		long N = scan.nextLong();
		long M = N;
		long mul = N-1;
		long k = (long)Math.pow(10, 12);
		
		for(long i=1; i<M; i++) {
			N *= mul;
			mul--;
			while(N%10==0)
				N/=10;
			N%=k;
		}
		N%=100000;
		if(N-N%10000==0) System.out.print("0");
		if(N-N%1000==0)System.out.print("0");
		if(N-N%100==0)System.out.print("0");
		if(N-N%10==0)System.out.print("0");
		
		System.out.println(N);
	}
}
