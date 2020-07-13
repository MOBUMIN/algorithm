import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//10828 스택
/* 인터페이스 연습 */
interface customstack{
	//push X: 정수 X를 스택에 넣는 연산이다.
	public void push(int n);
	//pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public void pop();
	//size: 스택에 들어있는 정수의 개수를 출력한다.
	public void size();
	//empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	public void empty();
	//top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public void top();
}

/* 인터페이스를 참조하는 클래스 */
class Cs implements customstack{
	int[] stack = new int[0]; // stack 역할을 할 배열 선언
	
	public void push(int n) {
		int length = stack.length;
		int[] push_copy = new int[length+1]; // stack보다 크기가 1 큰 배열을 선언하여
		System.arraycopy(stack, 0, push_copy, 0, length); // 원래의 stack 배열을 넣어줌
		push_copy[length] = n; // 그리고 새로 만든 스택의 마지막 자리에 push
		stack = push_copy;
	}
	public void pop() {
		int pop_number;
		int[] pop_copy;
		int length = stack.length;
		if(length>0) {
			pop_number = stack[length-1];
			pop_copy = new int[length-1];
			System.arraycopy(stack, 0, pop_copy, 0, stack.length-1); // 배열의 크기가 줄어들기 때문에 push와 같은 과정.
			stack = pop_copy;
			System.out.println(pop_number);
		}
		else System.out.println(-1);
	}
	public void size() {
		int size = stack.length;
		System.out.println(size);
	}
	public void empty() {
		if(stack.length<=0) System.out.println(1);
		else System.out.println(0);
	}
	public void top() {
		int length = stack.length;
		int top_n;
		if(length>0)
			top_n = stack[length-1];
		else top_n = -1;
		System.out.println(top_n);
	}
}

public class userstack_10828 {

	public static void main(String args[]) throws IOException{	
		Cs cus_stack = new  Cs(); // 사용할 스택을 선언함.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 명령의 개수
		
		while(N>0) {
			String[] cmd = br.readLine().split(" ");
			switch(cmd[0]) {
			case "push": 
				cus_stack.push(Integer.parseInt(cmd[1]));
				break;
			case "pop":
				cus_stack.pop();
				break;
			case "size":
				cus_stack.size();
				break;
			case "empty":
				cus_stack.empty();
				break;
			case "top":
				cus_stack.top();
			}
			N--;
		}
	}
}
