package l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Tile{
	int min; int max;
	Tile(int s, int b){
		this.min=s; this.max=b;
	}
}
public class Godown_2096 {
	static int[][] map;
	static Tile[][] tile;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		tile = new Tile[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				tile[i][j] = new Tile(map[i][j], map[i][j]);
			}
		}
		for(int k=1; k<N;k++)
			find_mm(k);
		int min,max;
		min = Math.min(tile[N-1][0].min, tile[N-1][1].min);
		min = Math.min(min,tile[N-1][2].min);
		max = Math.max(tile[N-1][0].max, tile[N-1][1].max);
		max = Math.max(max,tile[N-1][2].max);
		System.out.println(max+" "+min);
	}
	public static void find_mm(int r) {
		for(int i=0; i<3; i++) {
			int pos = map[r][i];
			Tile a,b,c;
			switch(i) {
			case 0:
				a = tile[r-1][i]; b=tile[r-1][i+1];
				tile[r][i].min = Math.min(pos+a.min, pos+b.min);
				tile[r][i].max=Math.max(pos+a.max, pos+b.max);
				break;
			case 1:
				a = tile[r-1][i-1]; b=tile[r-1][i]; c=tile[r-1][i+1];
				int com;
				com = Math.min(pos+a.min, pos+b.min);
				tile[r][i].min=Math.min(pos+c.min, com);
				com = Math.max(pos+a.max, pos+b.max);
				tile[r][i].max=Math.max(com, pos+c.max);
				break;
			case 2:
				a = tile[r-1][i-1]; b=tile[r-1][i];
				tile[r][i].min = Math.min(pos+a.min, pos+b.min);
				tile[r][i].max=Math.max(pos+a.max, pos+b.max);
				break;
			}
		}
	}
}
