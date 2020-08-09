package e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class appletree_19539 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> one = new LinkedList<>();
		Queue<Integer> other = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		int[] tree = new int[N];
		int no = 0;
		int no_sum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i] == 1) one.add(i);
			else if(tree[i] ==2 || tree[i]>3) other.add(i);
			no_sum += tree[i];
		}

		if (no_sum % 3 != 0)
			no++;
		else {
			while(!one.isEmpty()) {
				int i = one.poll();
				if(other.isEmpty()) {no++; break;}
				int j = other.poll();
				
				tree[i] -=1; tree[j]-=2;
				if(tree[j] == 2 || tree[j] > 3) other.add(j);
				
				}
			}
			no_sum=0;
			for(int i=0; i<N; i++)
				no_sum+=tree[i];
			if(no_sum%3!=0) no++;

		if (no > 0)
			System.out.println("NO");
		else
			System.out.println("YES");

	}
}
