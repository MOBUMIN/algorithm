//5543����

import java.util.Scanner;


public class Macdonaldo_5543 {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// ���ſ� ���� ������ �迭 ����
		int burgur[] = new int[3];
		int drink[] = new int[2];
		
		for(int i=0; i<5; i++) {
			if(i<3) burgur[i]=scan.nextInt();
			else drink[i-3]=scan.nextInt();
		}
		
		int minb=2001, mind=2001;
		
		// ���Ŵ� ���ų���, ����� ���᳢�� �ּҰ��� ����.
		for(int j=0; j<3; j++)
			if(minb>burgur[j]) minb=burgur[j];
		
		for(int k=0; k<2; k++)
			if(mind>drink[k]) mind=drink[k];
		
		int sum=minb+mind-50;
		System.out.println(sum);
		
	}
}
