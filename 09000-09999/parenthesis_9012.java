import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//9012 ��ȣ

public class parenthesis_9012 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int lcount;
		for (int i = 0; i < n; i++) {
			lcount = 0;
			
			/* �迭�� �о�ͼ� �� ���ھ� char �迭�� ���� */
			String arr = br.readLine();
			char[] arr_word = new char[arr.length()];
			for (int k = 0; k < arr_word.length; k++)
				arr_word[k] = arr.charAt(k);
			
			/* '(' �̸� lcount +1 �ƴϸ� lcount-1 �ؼ� lcount�� -�� NO ��� */
			for (int j = 0; j < arr_word.length; j++) {
				if (arr_word[j] == '(') // "("�� �ϴϱ� ������ �Ѥ�
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
