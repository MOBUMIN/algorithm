package g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class postfix_1918 {

	public static void main(String args[]) throws IOException{
		StringBuilder ans = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] Equation = br.readLine().split("");
		int size = Equation.length;
		
		Stack<Character> t = new Stack<>();
		for(int i=0; i<size; i++) {
			char a = Equation[i].charAt(0);
			switch(a) {
			case '+':
			case '-':
				while(!t.isEmpty()) {
					if(t.peek() == '(') break;
					ans.append(t.pop());
				}
			case '(':
				t.push(a); break;
			case '*':
			case '/':
				if (!t.isEmpty()) {
					if (t.peek() == '*' || t.peek() == '/') {
						ans.append(t.pop());
						t.push(a);
					} else t.push(a);
				}
				else t.push(a);
				break;
			case ')':
				while(t.peek() != '(') ans.append(t.pop());
				t.pop(); break;
			default: ans.append(a); break;
			}
		}
		while(!t.isEmpty()) ans.append(t.pop());
		
		System.out.println(ans);
	}
}
