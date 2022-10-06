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
		// N = å�� ����; M = ��� �� �ִ� ����
		int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> book = new ArrayList<>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++)  book.add(Integer.parseInt(st.nextToken()));
		Collections.sort(book);
		int ans = 0;
		/* �� ��ȿ���������� �Ф� , ���ĵ� book���� ����� ���� ū�� ������ ���� ū�� ���� �װ� �� ���� �����ְ� ����Ʈ���� ������ */
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
		/* ������ ��� ����Ʈ���� ���ְ� ����� ��� ����Ʈ���� �� ���ָ� �� */
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
