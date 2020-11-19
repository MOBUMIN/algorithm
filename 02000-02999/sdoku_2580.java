package j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class zeropos{
	int x,y,ans,i;
	zeropos(int x,int y){
		this.x =x; this.y =y;
	}
	zeropos(int i, int x,int y){
		this.i = i; this.x = x; this.y = y;
	}
	zeropos(int i,int x, int y, int ans){
		this.i=i; this.x=x; this.y=y; this.ans=ans;
	}
}
public class sdoku_2580 {
	static int N = 9;
	static int[][] sdoku;
	static ArrayList<zeropos> zeroq;
	static Stack<zeropos> stack;
	static boolean[] isExist;
	static zeropos[][] Square;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sdoku = new int[N][N]; zeroq = new ArrayList<>();
		stack = new Stack<>(); isExist = new boolean[N+1];
		Square = new zeropos[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++){
				sdoku[i][j] = Integer.parseInt(st.nextToken());
				if(sdoku[i][j] == 0) zeroq.add(new zeropos(zeroq.size(),i,j));
				}
		}
		makeSquare(); int i = 0;
		while(true) {
			make_zero(i);
			FindPossible(i);
			zeropos zero = stack.pop();
			sdoku[zero.x][zero.y]=zero.ans;
			//System.out.println(zero.x+","+zero.y+"="+zero.ans);
			i = zero.i+1;
			if(i==zeroq.size()) break;
			//print_sdoku(); System.out.println();
		}
		print_sdoku(); 
	}
	public static void print_sdoku() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N ;j++)
				System.out.print(sdoku[i][j]+ " ");
			System.out.println();
		}
	}
	public static void make_zero(int i) {
		int size = zeroq.size();
		for(int j=i; j<size; j++) {
			zeropos z = zeroq.get(j);
			sdoku[z.x][z.y]=0;
		}
	}
	public static void FindPossible(int index) {
		zeropos zero = zeroq.get(index);
		R_check(zero.x,zero.y); C_check(zero.x,zero.y);
		S_check(zero.x,zero.y);
		int cnt = 0;
		for(int i=0; i<N; i++)
			if(!isExist[i+1]) {
				zero.ans = i+1;
				stack.push(new zeropos(zero.i, zero.x, zero.y, zero.ans));
			}
		init(isExist);
	}
	public static void init(boolean[] v) {
		for(int i=0; i<N+1; i++)
			v[i] = false;
	}
	public static void R_check(int x,int y) { // Row Check
		for(int i=0; i<N; i++)
			isExist[sdoku[x][i]] = true;
	}
	public static void C_check(int x, int y) { // Column Check
		for(int i=0; i<N; i++)
			isExist[sdoku[i][y]] = true;
	}
	public static void S_check(int x, int y) { // Square Check
		int index=0;
		all: for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(Square[i][j].x == x && Square[i][j].y == y) {
					index = i; break all;
				}
		for(int i=0; i<N; i++) {
			int a = Square[index][i].x; int b = Square[index][i].y;
			
				isExist[sdoku[a][b]] = true;
		}
	}
	public static void makeSquare() {
		int c=0; int r=0; int l=0;
		for(int i=0; i<N; i++) {
			for(int j=r; j<r+3; j++)
				for(int k=c; k<c+3; k++) {
					Square[i][l] = new zeropos(j,k); l++;
				}
			c+=3; l=0;
			if(c==9) {
				c=0; r+=3;
			}
		}
	}
}
