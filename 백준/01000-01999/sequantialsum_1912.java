package e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sequantialsum_1912 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws IOException {
		yesarr(); // 배열 있게 푼거
		noarr(); // 위에꺼 배열 없앤거
	}
	
	public static void yesarr() throws IOException{
		int n = Integer.parseInt(br.readLine());
		
		int[] inputarr = new int[n]; // 입력만 받음
		int[] compare = new int[n]; // max(입력, 이전까지의 합 + 입력)
		
		/* 입력 받는 부분 */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++)
			inputarr[i] = Integer.parseInt(st.nextToken());
		compare = inputarr; // 일단 각자 다 입력 값을 가지는 것으로.
		
		/*정답 계산 */
		int ans = inputarr[0]; // 임시로 가장 처음 아이를 정답으로 선언해둠.
		for(int i=1; i<n; i++) {
			compare[i] = Math.max(inputarr[i], compare[i-1] + inputarr[i]);
			ans = Math.max(ans, compare[i]);
		}
		
		System.out.println(ans);
	}
	
	public static void noarr() throws IOException{
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int next;
		int temp = Integer.parseInt(st.nextToken());
		int ans = temp;
		while (st.hasMoreTokens()) {
			next = Integer.parseInt(st.nextToken());
			next = Math.max(temp+next, next);
            ans = Math.max(ans, next);
            temp = next;
			}
		System.out.println(ans);
	}
	
}
