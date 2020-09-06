package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class lib_1461 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// N = 책의 개수; M = 들고갈 수 있는 개수
		int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> book = new ArrayList<>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++)  book.add(Integer.parseInt(st.nextToken()));
		Collections.sort(book);
		int ans = 0;
		/* 좀 비효율적이지만 ㅠㅠ , 정렬된 book에서 양수의 끝이 큰지 음수의 끝이 큰지 비교후 그건 한 번만 더해주고 리스트에서 빼버림 */
		if(Math.abs(book.get(0)) > book.get(N-1)) {
			ans += Math.abs(book.get(0));
			for(int i=0; i<M; i++) if(book.get(0) < 0) book.remove(0);
		}
		else {
			ans += book.get(N-1);
			for(int i=0; i<M; i++) {
				if(book.get(book.size()-1) > 0) book.remove(book.size()-1);
			}
		}
		/* 음수인 경우 리스트에서 빼주고 양수인 경우 리스트에서 다 빼주면 댐 */
		while(!book.isEmpty()) {
			if(book.get(0) < 0) {
				ans+= Math.abs(book.get(0)) * 2;
				for(int i=0; i<M; i++) if(!book.isEmpty() && book.get(0)<0) book.remove(0);
				continue;
			}
			else if (book.get(0)>0) {
				ans+=book.get(book.size()-1)*2;
				for(int i=0; i<M; i++) if(!book.isEmpty()) book.remove(book.size()-1);
				continue;
			}
			else book.remove(0);
		}
		System.out.println(ans);
	}
}
