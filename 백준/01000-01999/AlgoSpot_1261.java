package m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class maze implements Comparable<maze>{
	int i,j,b;
	maze(int i, int j, int b){ // ��ǥ1,��ǥ2,�μ���
		this.i = i;
		this.j = j;
		this.b= b;
	}
	public int compareTo(maze t) {
		return this.b <= t.b ? -1: 1;
	}
}

public class AlgoSpot_1261 {
	public static void main(String args[]) throws IOException{
		/* �Է� */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int INF = 1000000;
		int M = Integer.parseInt(st[0]); // ���α���
		int N = Integer.parseInt(st[1]); // ���α���
		int[][] map = new int[N+1][M+1]; // �̷�
		int[][] v = new int[N+1][M+1];
		boolean[][] visited = new boolean[N+1][M+1]; // �湮 ����
		PriorityQueue<maze> pq = new PriorityQueue<>();
		for(int i=1; i<N+1; i++) {
			st = br.readLine().split("");
			for(int j=1; j<M+1; j++) {
				map[i][j] = Integer.parseInt(st[j-1]);
				v[i][j] = INF;
			}
		}
		
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		
		/* Ž�� */
		visited[1][1] = true;
		v[1][1] = 0;
		pq.add(new maze(1,1,0));
		
		while(!pq.isEmpty()) {
			maze pos = pq.poll(); // ���� ��ġ
			int x = pos.i; int y = pos.j;
			//System.out.println(x+","+y);
			visited[x][y]=true; 
			// ���� ��ġ���� �� �� �ִ� ��
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>0 && nx<N+1 && ny>0 && ny<M+1 && !visited[nx][ny]) {
					if(map[nx][ny]==0) { // ���� ��ġ�� ���� �ƴ� ���
						if(v[nx][ny] > pos.b) {
							pq.add(new maze(nx,ny,pos.b));
							v[nx][ny] = pos.b;
						}
					}
					else{ // ���� ��ġ�� ���� ���
						if(v[nx][ny] > pos.b+1){
							pq.add(new maze(nx,ny,pos.b+1));
							v[nx][ny] = pos.b+1;
						}
					}
				}
			}
		}
		
		System.out.println(v[N][M]);
		
	}
}
