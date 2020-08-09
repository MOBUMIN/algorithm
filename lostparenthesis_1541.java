package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//55-50+40
public class lostparenthesis_1541 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split("");
		
		Queue<Integer> num = new LinkedList<>();
		Queue<Character> op = new LinkedList<>();
		Queue<Integer> num_temp = new LinkedList<>(); // 여기에 입력받아서 number에 자리수 맞춰 더해서 num에다가 옮길거임
		
		/* 입력 받은 문자열을 처리하는 부분 */
		int size = st.length;
		for(int i=0; i<size; i++) {
			if(st[i].equals("+") || st[i].equals("-")) {
				op.add(st[i].charAt(0));
				
				int l = num_temp.size()-1; int number=0;
				while(l>=0)
					number += num_temp.poll()*Math.pow(10, l--); // 자릿수 맞추기
				num.add(number);
			}
			else num_temp.add(Integer.parseInt(st[i]));
		}
		int l = num_temp.size()-1; int number=0;
		while(l>=0) number += num_temp.poll()*Math.pow(10, l--); // 마지막 한 번은 저기서 못 돌아서 여기서 마저 해줌
		num.add(number);
		
		
		int ans= num.poll();
		while(true) {
			if(op.isEmpty() || num.isEmpty()) break;
			char oper = op.poll();
			if(oper == '+') ans += num.poll();
			else if(oper == '-') { // -가 나온 순간부터는 걍 다 빼주게 됨 ㅇㅇ그래야 최소
				while(true) {
					ans-=num.poll();
					if(num.isEmpty()) break;
				}
			}
		}
		System.out.println(ans);
		
		
	}
}
