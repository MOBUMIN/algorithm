package h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class map{
	double x;double y;
	map(double x, double y){this.x=x;this.y=y;}
}
public class polygon_2166 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		map[] coordinate = new map[N+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			coordinate[i] = new map(x,y);
		}
		/* 처음이랑 마지막 연결! */
		coordinate[N] = coordinate[0];
		double ans = 0; 
		/* 검색해서 나온 다각형 구하는 공식, 절대값을 먼저 씌워서 계속 틀림 */
		for(int i=0; i<N; i++) {ans+=(coordinate[i].x + coordinate[i+1].x) * (coordinate[i].y - coordinate[i+1].y);}
		ans/=2;
		ans = Math.abs(ans);
		System.out.println(String.format("%.1f",ans));
	}
}
