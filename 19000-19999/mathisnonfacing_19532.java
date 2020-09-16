package e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mathisnonfacing_19532 {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken()); int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken()); int f = Integer.parseInt(st.nextToken());
		int x,y;
		
		y = (a*f - c*d) / (a*e - b*d);
		if(a!=0)
			x = (c-b*y) / a;
		else
			x=(f-e*y) / d;
		
		System.out.println(x + " " + y);
	}
}
