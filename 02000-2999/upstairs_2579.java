import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2579 계단 오르기
public class upstairs_2579 {

	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stair = new int[n]; // 주어지는 계단 배열
		int[] sum = new int[n]; // 그 계단 위치까지의 최대값!(그 계단(마지막)은 무조건 밟아야함)
		for(int i=0; i<n; i++)
			stair[i] = Integer.parseInt(br.readLine());
		
		up(stair, n, 0, sum);
		
		System.out.println(sum[n-1]);
		
	}
	
	public static void up(int[] stair, int n, int i, int[] sum) { // 계단 배열, 계단의 수, 시작점, 최대값
		while(i<n) {
		/* 첫 번째 계단이 끝일때 최대값 */
		if(i==0) sum[i] = stair[i];
		/* 두 번째 계단이 끝일때 최대값 */
		else if(i==1) sum[i] = sum[i-1] + stair[i];
		/* 세 번째 계단이 끝일때 최대값, 여기서부터는 밟을지 말지 결정을 해줘야함 */
		else if(i==2) sum[i] = Math.max(sum[i-2], stair[i-1])+stair[i];
		/* 자기+전 계단과 그 전전전까지의 sum이 큰지, 자기+전전까지의 sum 이 큰지*/
		else sum[i] = Math.max(sum[i-2], sum[i-3]+stair[i-1])+stair[i];
		
		i++;
		}
	}
}
