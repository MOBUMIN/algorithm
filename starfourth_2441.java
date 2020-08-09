package alone;
import java.util.Scanner;

public class starfourth_2441 {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++)
				System.out.print(" ");
			for(int k=n; k>i; k--) 
				System.out.print("*");
			System.out.print("\n");
		}
	}
}
