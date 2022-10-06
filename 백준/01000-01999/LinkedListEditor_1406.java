package d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/*
 * L 커서 왼쪽
 * D 오른쪽
 * B 왼쪽 문자 삭제
 * P ㅁ 왼쪽에 문자 추가
 */

public class LinkedListEditor_1406 {

	public static void main(String args[]) throws IOException{
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(""); 			// 문자열 입력 받음
		int M = Integer.parseInt(br.readLine()); 	 	// 명령어 갯수
		char cmd; String ch; 									// 명령어의 종류
		Stack<String> left = new Stack<>(); 		// 연결리스트의 경우 시간복잡도 때문에 사용x
		Stack<String> right = new Stack<>();
		
		/* 왼쪽 스택에 문자열 다 넣기 */
		for(int i=0; i<str.length; i++)
			left.push(str[i]);
		
		/* 명령을 수행할 부분 */
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			cmd = st.nextToken().charAt(0);
			switch(cmd) {
			case 'L': // 커서를 왼쪽으로
				if(!left.isEmpty()) right.push(left.pop());
				break;
			case 'D': // 커서를 오른쪽으로
				if(!right.isEmpty()) left.push(right.pop());
				break;
			case 'B': // 커서의 왼쪽을 삭제
				if(!left.isEmpty()) left.pop();
				break;
			case 'P': // 커서의 왼쪽에 데이터 추가
				ch = st.nextToken();
				left.push(ch);
				break;
			}
		}
		
		/* 오른쪽 스택으로 다 넘기기. */
		int size = left.size();
		for(int i=0; i<size; i++)
			right.push(left.pop());
		
		size = right.size();
		for(int i=0; i<size; i++)
			System.out.print(right.pop());
		
	}
}
