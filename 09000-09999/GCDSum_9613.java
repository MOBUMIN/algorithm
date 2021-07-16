package o;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCDSum_9613 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� ����
		
		for(int i=0; i<T; i++) {
			// ���� �޾ƿ���
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			for(int n = 0; n<N; n++)
				arr[n] = Integer.parseInt(st.nextToken());
			long ans=0;
			
			// ù��° ������ ������ GCD ���ؼ� ���ϱ�
			for(int j=0; j<N; j++)
				for(int k=j; k<N; k++) {
					if(j==k) continue;
					ans += GCD(arr[j], arr[k]);
				}
			
			// ���
			System.out.println(ans);
		}
	}
	
	public static int GCD(int a, int b) {
		if(b>a) { int temp = a; a = b; b = temp;}
		 while(true){
		        int r = a%b;
		        if(r==0) return b;
				
		        a = b;
		        b = r;
		    }
	}
}
