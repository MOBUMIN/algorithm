package m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ���Ʈ������ Ǯ�ٰ� Ʋ���� �ð��ʰ��� ���� ���� Ž���� ������
 * start�� end���� mid�� �ٲ��� �ʰ� --, ++�� �����ؼ� �ð��ʰ��� ��� ����.
 * ���߿� �˾�ä�� �����ϰ��� ���ѷ����� ���� ������ ���ܼ�
 * �����ϰ� �����־���.
 * */
public class CuttingTree_2805 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // ������ ��
		int M = Integer.parseInt(st.nextToken()); // �ʿ��� ����
		int[] tree = new int[N]; // �������� ����
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++)
			tree[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(tree);
		/* ���ܱ⿡ ������ ���� */
		int high = tree[N-1];
		int low = 0;
		int H = low;
		/* Ž�� */
		long sum;
		while(low<high) {
			sum=0;
			H = (high+low)/2;
			for(int i = N-1; i>=0; i--) {
				if(tree[i]>H) sum+=tree[i]-H;
				else break;
			}
			if(low==H) break; // �̰� ������ ��� ���� ���� �ݺ��ż� ���ѷ���.
			if(sum<M) high=H;
			else if(sum>M) low=H;
			else break;
		}
		System.out.println(H);
	}
}