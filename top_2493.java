package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class index{
	int v;
	int i;
	index(int v, int i){
		this.v = v;
		this.i = i;
	}
}
public class top_2493 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 탑의 개수
		Stack<index> top = new Stack<>(); // (값, 몇 번째 탑인지)가 들어간 스택
		int[] ans = new int[N+1]; // 정답 배열
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int tmp,val,idx;
		for(int i=1; i<=N; i++) {
			tmp = Integer.parseInt(st.nextToken()); // (tmp,i) i번째 탑 value
            /* 
             * 해당 탑이 스택에 있는 탑보다 작으면 ans에 넣어주고 push
             * 아니라면 계속 pop
             * 어차피 뒤에 들어오는 탑은 해당 탑보다 작은 이전 탑이 아니라 해당 탑에 레이저를 쏘게 되어 있음
             * 스택이 empty되면 해당 탑 push, ans는 0으로 초기화되어있는 상태기때문에 따로 터치 x
             */
			while(!top.isEmpty()) {
			val = top.peek().v; idx = top.peek().i;
			if(val>tmp) {
				ans[i] = idx;
				top.push(new index(tmp,i));
				break;
			}
			top.pop();
			}
            /* 스택이 비어있으면 해당 탑을 push */
			if(top.isEmpty()) {
				top.push(new index(tmp,i)); continue;
			}
		}
		/* 시간 초과가 무서워서 사용한 stringbuilder */
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(ans[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
