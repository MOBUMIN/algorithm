import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10250 ACM ȣ��
//�ȴ� �Ÿ��� �Ű� x
public class ACMhotel_10250 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���� T

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken()); // ����(����)
			int W = Integer.parseInt(st.nextToken()); // �ʺ�(���)
			int N = Integer.parseInt(st.nextToken()); // �����
			find(H+1, W+1, N); // ���ڶ� �迭�ڸ��� ���� �Ϸ���
		}
		
		System.out.println(sb);
	}

	public static void find(int h, int w, int n) {
		/* �ָ� ������ ��� */
		/*
		int[][] hotel = new int[h][w];
		int h_full = 1; // ä�����ִ� ����
		int w_full = 1; // ä�����ִ� ���ȣ
		while (n > 0) {
			while (h > h_full) { // ���� 1ȣ�� ä���, ���� 2ȣ�� ä��� ���.
				if (hotel[h_full][w_full] == 0) {
					hotel[h_full][w_full] = 1;
					n--;
					if(n==0) break;
					h_full++;
				}
			}
			if(n==0) break;
			h_full=1; w_full++;
		}
		int ans = h_full*100 + w_full;
		sb.append(ans+"\n");
		*/
		
		/* ��� ��� */
		
		h--; w--; int ans,floor,room;
		if(n%h==0) { // ��� ���� �� ���� ������ �������ٸ�!
			floor = h; room = n/h; // ������ ����� ������ ����� ���� ������!, �����/�� ��ŭ �� �ڸ��� �� ����!
			ans = floor*100+room;
		}
		else {
			floor = n%h; // �� �����ϰ� ���� ������� �Ʒ������� ���� �÷�������ϱ� % ����
			room = n/h+1; // �����/���� ��ŭ ���� �� �������� ä������ϴϱ�!
			ans = floor*100 + room;
		}
		sb.append(ans+"\n");
		
	}		
}
