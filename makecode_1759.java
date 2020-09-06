package h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* n개중 c개를 뽑는 경우(조합)를 코딩해볼 수 있었음! */
/* 아스키 변환이 그냥 캐스트 연산자를 쓰기만 하면 됐던 사실. */
public class makecode_1759 {
	static boolean[] visit;
	static int[] code;
	static int C;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken()); // 암호 개수
		C = Integer.parseInt(st.nextToken()); // 될수있는 문자 개수
		code = new int[C]; st = new StringTokenizer(br.readLine()," ");
		visit = new boolean[C];
		for(int i=0; i<C; i++)
			code[i] = (int)st.nextToken().charAt(0);
		Arrays.sort(code); // 알파벳 오름차순 정렬
		track(0,L,0,0);// (index, remain, Vowel, Consonant)
	}
	public static void track(int s, int r, int v, int c) {
		if(r==0) {
			if(v<1 || c<2) return;
			for(int i=0; i<C;i++) 
				if(visit[i]) System.out.print((char)code[i]);
			System.out.println();
		}
		for(int i=s; i<C; i++) {
			visit[i] = true;
			if(isVowel(code[i])) track(i+1,r-1,v+1,c);
			else track(i+1,r-1,v,c+1);
			visit[i]=false;
		}
	}
	public static boolean isVowel(int v) {
		int[] Vowel = {(int)'a', (int)'e', (int)'i', (int)'o', (int)'u'};
		for(int i=0; i<5; i++) if(Vowel[i] == v) return true;
		return false;
	}
}
