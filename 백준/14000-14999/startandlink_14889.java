package h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class startandlink_14889 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] S = new int[N][N];
		int ans = 100000; // ���� �������� ���� �� ���� ū �� �ֱ� 100*20
		
		/* S�迭 �о���� */
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				S[i][j] = Integer.parseInt(st.nextToken());
		}

		/* ���� N�� ��� subset ���� ���ϴ� �˰���, ���۸� */
		int[] input = new int[N];
		for (int i = 0; i < N; i++) // ���� N=6�̸� 0,1,2,3,4,5
			input[i] = i;
		int k = N / 2; // subset�� ũ��
		List<int[]> subsets = new ArrayList<>();
		int[] s = new int[k];
		for (int i = 0; (s[i] = i) < k - 1; i++); // N=6�϶� ÷�� 0,1,2 ������ �޾ƿ�
		subsets.add(getSubset(input, s)); // input�� 0,1,2��°(input[s[0]], input[s[1]], input[s[2]])�� subset��! 
		for (;;) {
			int i;
			for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--); // 6 - 3 + 2 = 5, 6 - 3 + 1 = 4 ... �ش� �ڸ��� ���� �����ϸ� �� ���� �ڸ����� index �̵�
			if (i < 0)break;
			s[i]++; // 1,2,5 -> 1,3,5 Ȥ�� 1,2,3 -> 1,2,4
			for (++i; i < k; i++) s[i] = s[i - 1] + 1; // 1,3,5 -> 1,3,4 , ���ڸ����� �ٲٴ� ���� �ش� ���� . 
			subsets.add(getSubset(input, s)); // �ش� subset �Է�
		}

		/* start�� link�� �ΰ� �ּҰ� ���ϱ�! */
		int[] start = new int[N/2];
		int[] link = new int[N/2];
		for(int i=0; i<subsets.size(); i++) {
			boolean[] visit = new boolean[N]; // link�� �����ֱ� ���ؼ� visit üũ �� ����
			start = subsets.get(i);
			if(start[0] > 1) break; // ���ڸ��� 1�϶��� �� �غ��� ��� ��� �� �غ�����(����غ��� �׷�)
			int link_index = 0;
			int ans_temp=0;
			/* start �迭�� �ִ� ������ �湮 üũ */
			for(int j=0; j<N/2; j++)
				visit[start[j]] = true;
			/* �湮�� �ȵ� ���� link�� �ֱ� */
			for(int j=0; j<N; j++) {
				if(visit[j] == false) link[link_index++]=j;
				if(link_index>=N/2) break;
			}
			/* 0,1,2�� ���. 0,1(+1,0)-> 0,2(+2,0)-> 1,2(+2,1) ������ ���ֵ��� �� */
			for(int j=0; j<N/2-1; j++) {
				for(int x=j+1; x<N/2; x++) {
				ans_temp += S[start[j]][start[x]] + S[start[x]][start[j]];
				ans_temp -= (S[link[j]][link[x]] + S[link[x]][link[j]]);
				}
			}
			ans = Math.min(ans, Math.abs(ans_temp));
			ans_temp=0;
		}
		System.out.println(ans);

	}

	static int[] getSubset(int[] input, int[] subset) {
		int[] result = new int[subset.length];
		for (int i = 0; i < subset.length; i++)
			result[i] = input[subset[i]];
		return result;
	}
}
