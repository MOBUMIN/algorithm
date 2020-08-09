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
		/* arr_temp에다가 값 다 넣고 양수, 음수, 0 분류함 */
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
		
		/* 양x양은 큰수부터 곱하기. 짝이 안맞으면 그냥 더하기. 1인 경우같은 것(곱보다 덧셈이 나음)을 대비해서 Math.max 사용. */
		for(int i=p_c-1; i>=0; i--) {
			if(i==0) ans += arr_plus[i];
			else {
				ans += Math.max(arr_plus[i] + arr_plus[i-1], arr_plus[i] * arr_plus[i-1]);
				i--;
			}
		}
		/* 음x음은 페어가 안 맞을 때는 0과 곱하기. 페어가 맞는다면 절대값이 큰 수끼리 곱함. */
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
