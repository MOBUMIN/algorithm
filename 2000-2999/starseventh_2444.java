package alone;
import java.util.Scanner;

public class starseventh_2444 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int kk = n*2-3;
		for(int i=1; i<=n; i++) {
			
			for(int j=1; j<=n-i; j++)
				System.out.print(" ");
			
			for(int k=1; k<=i*2-1; k++)
				System.out.print("*");
			System.out.println();
		}
		for(int i=1; i<n; i++) {
			
			for(int j=1; j<=i; j++)
				System.out.print(" ");
			
			for(int k=1; k<=kk; k++)
				System.out.print("*");
			kk-=2;
			System.out.println();
		}
	}
}
