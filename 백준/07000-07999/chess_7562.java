package o;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class xy {
	int x;
	int y;
	int cnt;

	xy(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class chess_7562 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int ans;
		for(int i=0; i<T; i++) {
			ans=0;
			Queue<xy> bfs = new LinkedList<>();
			int N = Integer.parseInt(br.readLine()); // 체스판 크기
			 st = new StringTokenizer(br.readLine(), " ");
			int visited[][] = new int[N][N];
			xy now = new xy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(br.readLine(), " ");
			xy to = new xy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			
			/* bfs */
			bfs.add(now);
			while(!bfs.isEmpty()) {
				xy pos = bfs.poll();
				if(visited[pos.x][pos.y] ==1 ) continue; 
				if(pos.x == to.x && pos.y == to.y) {
					ans = pos.cnt;
					break;
				}
				visited[pos.x][pos.y]= 1;
				int right = pos.x+1;
				int right_2 = pos.x+2;
				int left = pos.x-1;
				int left_2 = pos.x-2;
				int up = pos.y+1;
				int up_2 = pos.y+2;
				int down = pos.y-1;
				int down_2 = pos.y-2;
				int c = pos.cnt+1;
				if(right<N && up_2<N && visited[right][up_2] == 0)
					bfs.add(new xy(right, up_2, c));
				if(right_2<N && up<N && visited[right_2][up] == 0)
					bfs.add(new xy(right_2, up, c));
				if(right<N && down_2>=0 && visited[right][down_2] == 0)
					bfs.add(new xy(right, down_2, c));
				if(right_2<N && down>=0 && visited[right_2][down] == 0)
					bfs.add(new xy(right_2, down, c));
				if(left>=0 && down_2>=0 && visited[left][down_2] == 0)
					bfs.add(new xy(left, down_2, c));
				if(left_2>=0 && down>=0 && visited[left_2][down] == 0)
					bfs.add(new xy(left_2, down, c));
				if(left>=0 && up_2<N && visited[left][up_2] == 0)
					bfs.add(new xy(left, up_2, c));
				if(left_2>=0 && up<N && visited[left_2][up] == 0)
					bfs.add(new xy(left_2, up, c));
			}
			System.out.println(ans);
		}
	}
}
