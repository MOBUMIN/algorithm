package r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class cocompression_18870 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(str[i]);
		int[] clone = arr.clone();
		Arrays.sort(arr);
		HashMap<Integer,Integer> map = new HashMap<>();
		int cnt=0;
		for(int i=0; i<N; i++) {
			if(!map.containsKey(arr[i]))
				map.put(arr[i], cnt++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(map.get(clone[i])+ " ");
		}
		System.out.println(sb);
	}
}
