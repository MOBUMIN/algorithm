package alone;
import java.util.Scanner;

public class starsixth_2443 {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k_n = n*2-1;
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<i; j++)
				System.out.print(" ");
			
			for(int k=k_n; k>0; k--)
				System.out.print("*");
			System.out.println();
			k_n-=2;
		}
	}
}
