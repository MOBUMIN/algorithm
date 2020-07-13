import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//1874 스택수열
public class stackarray_1874 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int x[] = new int[n]; // 내가 만들어야 하는 수열
		for (int i = 0; i < n; i++)
			x[i] = Integer.parseInt(br.readLine());

		StringBuilder ans = new StringBuilder();

		int i = 0;
		int a = 1;
		int no = 0;
		while (i < n) {
			if (stack.empty()) {
				stack.push(a++);
				ans.append('+'+"\n");
			} else {
				if (stack.peek() != x[i]) {
					if(a>n) {
						no++;
						break;
					}
					stack.push(a++);
					ans.append('+'+"\n");
				} else {
					int k = stack.pop();
					if(k!=x[i]) {
						no++;
						break;
					}
					ans.append('-'+"\n");
					i++;
				}
			}

		}

		if (no > 0)
			System.out.println("NO");
		else {
			System.out.println(ans);
		}
	}
}
