package j;

import java.util.Scanner;
import java.util.Stack;

class Stringpos {
	int pos;
	String str;
	Stringpos(int p, String s){
		this.pos =p; this.str=s;
	}
}
public class goodseq_2661 {
	static int N;
	static String[] seq = {"3","2","1"};
	static Stack<Stringpos> t;
	static String answer;
	static int len;
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt(); answer ="";
		t = new Stack<>();
		len = 0;
		t.push(new Stringpos(0,"3")); t.push(new Stringpos(0,"2")); t.push(new Stringpos(0,"1"));
		while(true) {
			while(t.peek().pos!=len) {
				answer = answer.substring(0,len-1);
				len--;
			}
			answer += t.pop().str;
			len++;
			if(len==N) break;
			track();
		}
		System.out.println(answer);
	}
	public static void track() {
		for(int i=0; i<3; i++) 
			if(isPossible(seq[i])) t.push(new Stringpos(len,seq[i]));
	}
	public static boolean isPossible(String s) {
		String last = answer.substring(len-1);
		if(last.equals(s)) return false;
		String add = answer + s;
		int size = add.length();
		for(int i=2; i<=size/2; i++) { // 부분 수열의 크기
			for(int j=0; j<size; j++) { // 비교 시작 위치?
				if(j+i>size || j+2*i>size) break;
				String cp1 = add.substring(j,j+i);
				String cp2 = add.substring(j+i,j+2*i);
				if(cp1.equals(cp2)) return false;
			}
		}
		return true;
	}
}
