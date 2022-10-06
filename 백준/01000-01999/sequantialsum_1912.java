package e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sequantialsum_1912 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws IOException {
		yesarr(); // �迭 �ְ� Ǭ��
		noarr(); // ������ �迭 ���ذ�
	}
	
	public static void yesarr() throws IOException{
		int n = Integer.parseInt(br.readLine());
		
		int[] inputarr = new int[n]; // �Է¸� ����
		int[] compare = new int[n]; // max(�Է�, ���������� �� + �Է�)
		
		/* �Է� �޴� �κ� */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++)
			inputarr[i] = Integer.parseInt(st.nextToken());
		compare = inputarr; // �ϴ� ���� �� �Է� ���� ������ ������.
		
		/*���� ��� */
		int ans = inputarr[0]; // �ӽ÷� ���� ó�� ���̸� �������� �����ص�.
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
