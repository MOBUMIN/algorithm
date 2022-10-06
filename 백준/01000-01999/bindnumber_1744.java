package e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class bindnumber_1744 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp;
		int p_c=0; // plus count
		int m_c=0; // minus count
		/* arr_temp���ٰ� �� �� �ְ� ���, ����, 0 �з��� */
		int[] arr_temp = new int[N];
		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(br.readLine());
			arr_temp[i] = temp;
			if(temp>0) p_c++;
			else if(temp<0)m_c++;
		}
		int[] arr_plus = new int[p_c];
		int[] arr_minus = new int[m_c];
		p_c=0; m_c=0;
		Stack<Integer> zero = new Stack<>();
		for(int i=0; i<N; i++) {
			if(arr_temp[i] >0) {arr_plus[p_c++] = arr_temp[i];}
			else if(arr_temp[i]==0) zero.push(arr_temp[i]);
			else arr_minus[m_c++] = arr_temp[i];
		}
		Arrays.sort(arr_plus);
		Arrays.sort(arr_minus);
		
		int ans=0;
		
		/* ��x���� ū������ ���ϱ�. ¦�� �ȸ����� �׳� ���ϱ�. 1�� ��찰�� ��(������ ������ ����)�� ����ؼ� Math.max ���. */
		for(int i=p_c-1; i>=0; i--) {
			if(i==0) ans += arr_plus[i];
			else {
				ans += Math.max(arr_plus[i] + arr_plus[i-1], arr_plus[i] * arr_plus[i-1]);
				i--;
			}
		}
		/* ��x���� �� �� ���� ���� 0�� ���ϱ�. �� �´´ٸ� ���밪�� ū ������ ����. */
		for(int i=0; i<m_c; i++) {
			if (i + 1 == m_c )
				if (zero.isEmpty()) ans += arr_minus[i];
				else zero.pop();
			else{
					ans += arr_minus[i] * arr_minus[i+1];
					i++;
				}
		}
		
		

		System.out.println(ans);
	}
}
