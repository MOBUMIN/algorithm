import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1308  D-Day
/*
 * 2008 12 27
 * 2009 1 22
 */
public class dday_1308 {

	public static void main(String args[]) throws IOException {
		/* 날짜 입력 받아오는 부분 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer first = new StringTokenizer(br.readLine(), " ");
		StringTokenizer second = new StringTokenizer(br.readLine(), " ");
		int[] present = new int[3]; // [0] : year, [1] : mon, [2] : day
		int[] dday = new int[3];
		for (int i = 0; i < 3; i++) {
			present[i] = Integer.parseInt(first.nextToken());
			dday[i] = Integer.parseInt(second.nextToken());
		}
		
		int ans = find_d(present, dday);
		
		int gy = dday[0] - present[0];
		gy = 1;
		if(gy > 1000) System.out.println("gg");
		else if(gy==1000) {
			if(present[1]<dday[1]) System.out.println("gg");
			else if(present[1] == dday[1]) {
				if(present[2]<dday[2] || present[2] == dday[2]) System.out.println("gg");
				else System.out.println("D-"+ans);
			}
			else System.out.println("D-"+ans);
		}
		else { System.out.println("D-"+ans); }
		

	}

	public static int find_d(int[] p, int[] day) {
		int d = 0;
		int[] pre = new int[3];
		for(int i=0; i<3; i++)
			pre[i] = p[i];
		
		/* 연도가 딸리면 연도 증가 시키기 */
		while (pre[0] != day[0]) {
			
			switch (pre[1]) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				while (pre[2] != 31) { pre[2]++; d++; }
				if (pre[1] == 12) {pre[1] = 1; pre[0]++;}
				else { pre[1]++; }
				pre[2] = 1; d++;
				break;
				
			case 4: case 6: case 9: case 11:
				while (pre[2] != 30) { pre[2]++; d++; }
				pre[1]++; pre[2] = 1; d++;
				break;
				
			default:
				if (check(pre[0])) { while(pre[2] != 29) { pre[2]++; d++; } }
				else { while(pre[2] != 28) { pre[2]++; d++;} }
				pre[1]++; pre[2]=1; d++;
				break;
			}
		}
		
		/* 월 수가 딸리면 월 수 증가 시키기 */
		while (pre[1] != day[1]) {
			switch (pre[1]) {
			case 1: case 3: case 5: case 7: case 8: case 10:
				while (pre[2] != 31) { pre[2]++; d++;}
				pre[1]++; pre[2] = 1; d++;
				break;
				
			case 4: case 6: case 9: case 11:
				while (pre[2] != 30) { pre[2]++; d++; }
				pre[1]++; pre[2] = 1; d++;
				break;
				
			default:
				if (check(pre[0])) { while(pre[2] != 29) { pre[2]++; d++; } }
				else { while(pre[2] != 28) { pre[2]++; d++; } }
				pre[1]++; pre[2]=1; d++;
				break;
			}
		}
		
		/* 일수가 딸리면 일수 증가 시키기 */
		while(pre[2] != day[2]) {
			pre[2]++; d++;
		}
		return d;
	}


	/* 윤년인지 체킹 해주는 메서드 */
	public static boolean check(int year) {
		if(year % 400 == 0) return true;
		if(year % 100 == 0) return false;
		if(year % 4 ==0) return true;
		return false;
		/*
		//4로 나누어 떨어지는 해는 윤년
		if (year% 4 == 0 && year%100!=0)
			return true;
		// 400으로 나누어 떨어지는 해 역시 윤년
		if (year % 400 == 0)
			return true;
		return false;
		*/
	}
}
