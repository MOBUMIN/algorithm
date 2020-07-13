import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//11689¹ø ¹®Á¦
public class GCD_11689 {

	public static double usergcd(double n) {

		double ans = n;

		for (double i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				while (n % i == 0)
					n /= i;
				ans *= (1.0 - (1.0 / i));
			}
		}
		if(n>1)
			ans *= (1.0-(1.0/n));
		return ans;
	}


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double n = Double.parseDouble(br.readLine());
		double ans;

		ans = usergcd(n);

		System.out.println((long)ans);

	}
}
