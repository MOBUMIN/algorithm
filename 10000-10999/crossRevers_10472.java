package q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class PC {
	int p;
	int c;
	PC(int p, int c){
		this.p = p;
		this.c = c;
	}
}

public class crossRevers_10472 {
	static int ans;
	static boolean[] visited;
	static int[][] reverse = {{8,7,5},{8,7,6,4},{7,6,3},{8,5,4,2},{7,5,4,3,1},{6,4,3,0},{5,2,1},{4,2,1,0},{3,1,0}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			visited = new boolean[513];
			int p = 0;
			ans = 0;
			Queue<PC> next = new LinkedList<>();
			/* make ans */
			for(int j=0; j<3; j++) {
				String[] line = br.readLine().split("");
				for(int k=0; k<3; k++) {
					if(line[k].equals("*")) ans+= Math.pow(2, p+k);
				}
				p += 3;
			}
			
			/* bfs */
			next.add(new PC(0, 0));
			while(!next.isEmpty()) {
				PC pos = next.poll();
				if(visited[pos.p]) continue; 
				visited[pos.p] = true;
				if(pos.p == ans) {
					System.out.println(pos.c);
					break;
				}
				/* map에 이진수 변환해서 넣기! */
				String[] map = new String[9];
				String[] binaryPos = Integer.toBinaryString(pos.p).split("");
				for(int j=0; j<9; j++) map[j] = "0";
				int k = 8;
				for(int j=binaryPos.length-1; j>=0; j--) map[k--] = binaryPos[j];
				
				/* 클릭 후 방문안한 곳 넣기! */
				for(int j=0; j<9; j++) {
					String[] nextMap = map.clone();
					for(k=0; k<reverse[j].length; k++) {
						if(nextMap[reverse[j][k]].equals("0")) nextMap[reverse[j][k]] = "1";
						else nextMap[reverse[j][k]] = "0";
					}
					int nextPos = Integer.parseInt(String.join("",nextMap),2);
					if(!visited[nextPos]) next.add(new PC(nextPos, pos.c+1));
				}
			}
		}
	}
}
