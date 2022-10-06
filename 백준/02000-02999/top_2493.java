package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class index{
	int v;
	int i;
	index(int v, int i){
		this.v = v;
		this.i = i;
	}
}
public class top_2493 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ž�� ����
		Stack<index> top = new Stack<>(); // (��, �� ��° ž����)�� �� ����
		int[] ans = new int[N+1]; // ���� �迭
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int tmp,val,idx;
		for(int i=1; i<=N; i++) {
			tmp = Integer.parseInt(st.nextToken()); // (tmp,i) i��° ž value
            /* 
             * �ش� ž�� ���ÿ� �ִ� ž���� ������ ans�� �־��ְ� push
             * �ƴ϶�� ��� pop
             * ������ �ڿ� ������ ž�� �ش� ž���� ���� ���� ž�� �ƴ϶� �ش� ž�� �������� ��� �Ǿ� ����
             * ������ empty�Ǹ� �ش� ž push, ans�� 0���� �ʱ�ȭ�Ǿ��ִ� ���±⶧���� ���� ��ġ x
             */
			while(!top.isEmpty()) {
			val = top.peek().v; idx = top.peek().i;
			if(val>tmp) {
				ans[i] = idx;
				top.push(new index(tmp,i));
				break;
			}
			top.pop();
			}
            /* ������ ��������� �ش� ž�� push */
			if(top.isEmpty()) {
				top.push(new index(tmp,i)); continue;
			}
		}
		/* �ð� �ʰ��� �������� ����� stringbuilder */
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(ans[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
