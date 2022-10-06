import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//10828 ����
/* �������̽� ���� */
interface customstack{
	//push X: ���� X�� ���ÿ� �ִ� �����̴�.
	public void push(int n);
	//pop: ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
	public void pop();
	//size: ���ÿ� ����ִ� ������ ������ ����Ѵ�.
	public void size();
	//empty: ������ ��������� 1, �ƴϸ� 0�� ����Ѵ�.
	public void empty();
	//top: ������ ���� ���� �ִ� ������ ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
	public void top();
}

/* �������̽��� �����ϴ� Ŭ���� */
class Cs implements customstack{
	int[] stack = new int[0]; // stack ������ �� �迭 ����
	
	public void push(int n) {
		int length = stack.length;
		int[] push_copy = new int[length+1]; // stack���� ũ�Ⱑ 1 ū �迭�� �����Ͽ�
		System.arraycopy(stack, 0, push_copy, 0, length); // ������ stack �迭�� �־���
		push_copy[length] = n; // �׸��� ���� ���� ������ ������ �ڸ��� push
		stack = push_copy;
	}
	public void pop() {
		int pop_number;
		int[] pop_copy;
		int length = stack.length;
		if(length>0) {
			pop_number = stack[length-1];
			pop_copy = new int[length-1];
			System.arraycopy(stack, 0, pop_copy, 0, stack.length-1); // �迭�� ũ�Ⱑ �پ��� ������ push�� ���� ����.
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
		Cs cus_stack = new  Cs(); // ����� ������ ������.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // ����� ����
		
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
