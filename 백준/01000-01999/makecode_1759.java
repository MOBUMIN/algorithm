package h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* n���� c���� �̴� ���(����)�� �ڵ��غ� �� �־���! */
/* �ƽ�Ű ��ȯ�� �׳� ĳ��Ʈ �����ڸ� ���⸸ �ϸ� �ƴ� ���. */
public class makecode_1759 {
	static boolean[] visit;
	static int[] code;
	static int C;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken()); // ��ȣ ����
		C = Integer.parseInt(st.nextToken()); // �ɼ��ִ� ���� ����
		code = new int[C]; st = new StringTokenizer(br.readLine()," ");
		visit = new boolean[C];
		for(int i=0; i<C; i++)
			code[i] = (int)st.nextToken().charAt(0);
		Arrays.sort(code); // ���ĺ� �������� ����
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
