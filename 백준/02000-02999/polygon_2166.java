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
		/* ó���̶� ������ ����! */
		coordinate[N] = coordinate[0];
		double ans = 0; 
		/* �˻��ؼ� ���� �ٰ��� ���ϴ� ����, ���밪�� ���� ������ ��� Ʋ�� */
		for(int i=0; i<N; i++) {ans+=(coordinate[i].x + coordinate[i+1].x) * (coordinate[i].y - coordinate[i+1].y);}
		ans/=2;
		ans = Math.abs(ans);
		System.out.println(String.format("%.1f",ans));
	}
}
