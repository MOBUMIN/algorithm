package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class ind{
	int x,y,cnt,Bx,By;
	ind(int x,int y,int cnt, int Bx, int By){
		this.x=x; this.y=y; this.cnt=cnt;
		this.Bx=Bx; this.By=By;
	}
}
public class beadesc_13460 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); int M = Integer.parseInt(str[1]);
		int Rx = 0,Ry = 0,Bx=0,By=0;
		char[][] map = new char[N][M];
		for(int i=0; i<N; i++) {
			str = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = str[j].charAt(0);
				if(map[i][j]=='R') { Rx=i; Ry=j; }
				if(map[i][j]=='B') { Bx=i; By=j; }
			}
		}
		Queue<ind> q = new LinkedList<>();
		q.add(new ind(Rx,Ry,0,Bx,By));
		int ans = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		while(!q.isEmpty()) {
			if(ans==1) break;
			ind R = q.poll();
			if(R.cnt>10) {
				if(q.isEmpty()) {
					System.out.println("-1"); break;
				}
				continue;
			}
			for(int i=0; i<4; i++) {
				int nx = R.x + dx[i]; int Bnx = R.Bx + dx[i];
				int ny = R.y + dy[i]; int Bny = R.By + dy[i];
				int nc = R.cnt + 1;
				if(nc>10) continue;
					if(map[Bnx][Bny] == 'O') continue;
						switch(i){
						case 0:
							while(map[nx][ny] != '#' && map[nx][ny] != 'O' && map[Bnx][Bny] != 'O') {
							nx--;
							if(map[Bnx][Bny] != '#') Bnx--;
							if(nx==Bnx && ny == Bny) { nx++; break; }
							}
							while(map[Bnx][Bny] != 'O' && map[Bnx][Bny] != '#') {
								Bnx--;
								if(map[Bnx][Bny] != 'O') if(nx==Bnx && ny == Bny) {Bnx++; break;}
							}
							if(map[nx][ny] == 'O') {
								if(map[Bnx][Bny] == 'O') continue;
								System.out.println(nc); ans=1; break;
							}
							if(map[Bnx][Bny]=='O') continue;
							nx++; Bnx++;
							q.add(new ind(nx,ny,nc,Bnx,Bny)); break;
						case 1:
							while(map[nx][ny] != '#' && map[nx][ny] != 'O' && map[Bnx][Bny] != 'O') {
								nx++;
								if(map[Bnx][Bny] != '#') Bnx++;
								if(nx==Bnx && ny == Bny) { nx--; break; }
								}
							while(map[Bnx][Bny] != 'O' && map[Bnx][Bny] != '#') {
								Bnx++;
								if(map[Bnx][Bny] != 'O') if(nx==Bnx && ny == Bny) {Bnx--; break;}
							}
								if(map[nx][ny] == 'O') {
									if(map[Bnx][Bny] == 'O') continue;
									System.out.println(nc); ans=1; break;
								}
								if(map[Bnx][Bny]=='O') continue;
								nx--; Bnx--;
								q.add(new ind(nx,ny,nc,Bnx,Bny)); break;
						case 2:
							while(map[nx][ny] != '#' && map[nx][ny] != 'O' && map[Bnx][Bny] != 'O') {
								ny++;
								if(map[Bnx][Bny] != '#') Bny++;
								if(nx==Bnx && ny == Bny) { ny--; break; }
								}
							while(map[Bnx][Bny] != 'O' && map[Bnx][Bny] != '#') {
								Bny++;
								if(map[Bnx][Bny] != 'O') if(nx==Bnx && ny == Bny) {Bny--; break;}
							}
								if(map[nx][ny] == 'O') {
									if(map[Bnx][Bny] == 'O') continue;
									System.out.println(nc); ans=1; break;
								}
								if(map[Bnx][Bny]=='O') continue;
								ny--; Bny--;
								q.add(new ind(nx,ny,nc,Bnx,Bny)); break;
						case 3:
							while(map[nx][ny] != '#' && map[nx][ny] != 'O' && map[Bnx][Bny] != 'O') {
								ny--;
								if(map[Bnx][Bny] != '#') Bny--;
								if(nx==Bnx && ny == Bny) { ny++; break; }
								}
							while(map[Bnx][Bny] != 'O' && map[Bnx][Bny] != '#') {
								Bny--;
								if(map[Bnx][Bny] != 'O') if(nx==Bnx && ny == Bny) {Bny++; break;}
							}
								if(map[nx][ny] == 'O') {
									if(map[Bnx][Bny] == 'O') continue;
									System.out.println(nc); ans=1; break;
								}
								if(map[Bnx][Bny]=='O') continue;
								ny++; Bny++;
								q.add(new ind(nx,ny,nc,Bnx,Bny)); break;
						}
					}
				}
		if(ans != 1) System.out.println(-1);
	}
}
