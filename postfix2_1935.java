package g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 *  double 말고 float으로 했다가 한 번 틀림.
 * 소수점 자르는 법 배움 round 방식(버림)과 %.2f방식(반올림)
 * 후위 표기식 복습할 수 있었음.
 */
public class postfix2_1935 {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Character> equation = new LinkedList<>();
		String[] str = br.readLine().split("");
		for(int i=0; i<str.length; i++)
			equation.add(str[i].charAt(0));
		
		double[] alphabet = new double[N];
		for(int i=0; i<N; i++)
			alphabet[i] = Double.parseDouble(br.readLine());
		
		Stack<Double> s = new Stack<>();
		while(!equation.isEmpty()) {
			char t = equation.poll();
			switch(t) {
			case '+':
				s.push(s.pop()+s.pop());break;
			case '-':
				double a = s.pop();
				s.push(s.pop()-a);break;
			case '/':
				double b = s.pop();
				s.push(s.pop()/b);break;
			case '*':
				s.push(s.pop()*s.pop()); break;
			default:
				s.push(alphabet[t - 65]); // 'A' = ASCII 65
				break;
			}
		}
		
		System.out.println(String.format("%.2f", s.pop()));
	}
}
