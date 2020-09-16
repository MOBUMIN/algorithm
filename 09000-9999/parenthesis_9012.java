import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//9012 괄호

public class parenthesis_9012 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int lcount;
		for (int i = 0; i < n; i++) {
			lcount = 0;
			
			/* 배열을 읽어와서 한 글자씩 char 배열에 넣음 */
			String arr = br.readLine();
			char[] arr_word = new char[arr.length()];
			for (int k = 0; k < arr_word.length; k++)
				arr_word[k] = arr.charAt(k);
			
			/* '(' 이면 lcount +1 아니면 lcount-1 해서 lcount가 -면 NO 출력 */
			for (int j = 0; j < arr_word.length; j++) {
				if (arr_word[j] == '(') // "("로 하니까 오류남 ㅡㅡ
					lcount++;
				else {
					lcount--;
					if (lcount < 0) {
						System.out.println("NO");
						break;
					}
				}
			}
			if (lcount == 0)
				System.out.println("YES");
			else if (lcount > 0)
				System.out.println("NO");
		}
	}
}
