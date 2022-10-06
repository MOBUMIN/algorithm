import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2579 ��� ������
public class upstairs_2579 {

	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stair = new int[n]; // �־����� ��� �迭
		int[] sum = new int[n]; // �� ��� ��ġ������ �ִ밪!(�� ���(������)�� ������ ��ƾ���)
		for(int i=0; i<n; i++)
			stair[i] = Integer.parseInt(br.readLine());
		
		up(stair, n, 0, sum);
		
		System.out.println(sum[n-1]);
		
	}
	
	public static void up(int[] stair, int n, int i, int[] sum) { // ��� �迭, ����� ��, ������, �ִ밪
		while(i<n) {
		/* ù ��° ����� ���϶� �ִ밪 */
		if(i==0) sum[i] = stair[i];
		/* �� ��° ����� ���϶� �ִ밪 */
		else if(i==1) sum[i] = sum[i-1] + stair[i];
		/* �� ��° ����� ���϶� �ִ밪, ���⼭���ʹ� ������ ���� ������ ������� */
		else if(i==2) sum[i] = Math.max(sum[i-2], stair[i-1])+stair[i];
		/* �ڱ�+�� ��ܰ� �� ������������ sum�� ū��, �ڱ�+���������� sum �� ū��*/
		else sum[i] = Math.max(sum[i-2], sum[i-3]+stair[i-1])+stair[i];
		
		i++;
		}
	}
}
