package d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/*
 * L Ŀ�� ����
 * D ������
 * B ���� ���� ����
 * P �� ���ʿ� ���� �߰�
 */

public class LinkedListEditor_1406 {

	public static void main(String args[]) throws IOException{
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(""); 			// ���ڿ� �Է� ����
		int M = Integer.parseInt(br.readLine()); 	 	// ��ɾ� ����
		char cmd; String ch; 									// ��ɾ��� ����
		Stack<String> left = new Stack<>(); 		// ���Ḯ��Ʈ�� ��� �ð����⵵ ������ ���x
		Stack<String> right = new Stack<>();
		
		/* ���� ���ÿ� ���ڿ� �� �ֱ� */
		for(int i=0; i<str.length; i++)
			left.push(str[i]);
		
		/* ����� ������ �κ� */
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			cmd = st.nextToken().charAt(0);
			switch(cmd) {
			case 'L': // Ŀ���� ��������
				if(!left.isEmpty()) right.push(left.pop());
				break;
			case 'D': // Ŀ���� ����������
				if(!right.isEmpty()) left.push(right.pop());
				break;
			case 'B': // Ŀ���� ������ ����
				if(!left.isEmpty()) left.pop();
				break;
			case 'P': // Ŀ���� ���ʿ� ������ �߰�
				ch = st.nextToken();
				left.push(ch);
				break;
			}
		}
		
		/* ������ �������� �� �ѱ��. */
		int size = left.size();
		for(int i=0; i<size; i++)
			right.push(left.pop());
		
		size = right.size();
		for(int i=0; i<size; i++)
			System.out.print(right.pop());
		
	}
}
