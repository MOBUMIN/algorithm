//13866����

import java.util.Scanner;
import java.util.Arrays;

public class devidingteam_13866 {

	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] team = new int[4];
		
		for(int i=0; i<4; i++)
			team[i]=scan.nextInt();
		
		// �������� ����
		Arrays.sort(team);
		
		//�� ��찡 ���̰� �ּڰ�!
		int x = team[0] + team[3];
		int y = team[1] + team[2];
		
		if(x>=y) System.out.println(x-y);
		else System.out.println(y-x);
	}
	
}
