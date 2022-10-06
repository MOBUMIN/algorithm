import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//10809 알파벳 찾기
public class findalphabet_10809 {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char arr[] = br.readLine().toCharArray();
		int[] alphabet = new int[26];
		int length = arr.length;
		int order = 99;
		
		for(int i=0; i<26; i++)
			alphabet[i]=-1;
		
		for(int i=0; i<length; i++) {
			int t = arr[i];
			// 아스키코드를 쓰면 더 간단할 것 같기도..? 귀찬하.
			switch(t) {
			case 'a': order=0; break;
			case 'b': order=1; break;
			case 'c': order=2; break;
			case 'd': order=3; break;
			case 'e': order=4; break;
			case 'f': order=5; break;
			case 'g': order=6; break;
			case 'h': order=7; break;
			case 'i': order=8; break;
			case 'j': order=9; break;
			case 'k': order=10; break;
			case 'l': order=11; break;
			case 'm': order=12; break;
			case 'n': order=13; break;
			case 'o': order=14; break;
			case 'p': order=15; break;
			case 'q': order=16; break;
			case 'r': order=17; break;
			case 's': order=18; break;
			case 't': order=19; break;
			case 'u': order=20; break;
			case 'v': order=21; break;
			case 'w': order=22; break;
			case 'x': order=23; break;
			case 'y': order=24; break;
			case 'z': order=25; break;
			}
				if(alphabet[order]==-1) alphabet[order]=i;
		}
		
		for(int i=0; i<26; i++) {
			if(i==25) System.out.print(alphabet[i]);
			else System.out.print(alphabet[i]+" ");
		}
		
	}
}
