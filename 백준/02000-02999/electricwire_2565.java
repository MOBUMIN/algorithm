package g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class electricwire_2565 {
	static int A = 0;
	static int B = 1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] wire = new int[N+1][2];
		int[] connect = new int[N+1]; // LIS
		for(int i=1; i<= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<2; j++)
				wire[i][j] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(wire, Comparator.comparingInt(o1->o1[0])); // A�� �������� �������� ����
		for(int i=1; i<=N; i++) { // LIS, ������ �Ǵ� A ����
			connect[i] = 1;
			for(int j=1; j<i; j++) { // ���ظ� ����� A vs ���ذ� ��ġ�� �ʴ� �������� �����̷� ������ �ִ� A
				if(wire[i][B]>wire[j][B]) connect[i] = Math.max(connect[i], connect[j]+1);
			}
		}
		Arrays.sort(connect);
		System.out.println(N-connect[N]);
	}
}
