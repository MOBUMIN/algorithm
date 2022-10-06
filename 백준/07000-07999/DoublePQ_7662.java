package l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class DoublePQ_7662 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		TreeMap<Long, Long> map;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine()); // 연산 개수
            map = new TreeMap<>();
			for(int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine()," ");
				
				char order =st.nextToken().charAt(0);
				long val = Long.parseLong(st.nextToken());
				
				if(order=='I') {
					if(map.containsKey(val)) map.put(val, map.get(val)+1);
					else map.put(val, 1L);
				}
				else if(order=='D') {
					if(map.isEmpty()) continue;
					if(val==1) {
						long maxKey = map.lastKey();
						long maxVal = map.get(maxKey)-1;
						if(maxVal==0) map.remove(maxKey);
						else map.put(maxKey, maxVal);
					}
					else if (val==-1) {
						long minKey = map.firstKey();
						long minVal = map.get(minKey)-1;
						if(minVal==0) map.remove(minKey);
						else map.put(minKey, minVal);
					}
			}
			}
			/* q의 최대 최소 출력 */
			if(map.isEmpty()) System.out.println("EMPTY");
			else System.out.println(map.lastKey()+" "+map.firstKey());
		}
	}
	}
