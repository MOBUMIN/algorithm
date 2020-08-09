package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class MinHeap{
	private ArrayList<Integer> heap;
	private int size;
	MinHeap(){ heap = new ArrayList<>(); heap.add(0); size=0; }
	
	public boolean isEmpty() {
		if(size==0) return true;
		else return false;
	}
	public void swap(int a, int b) {
		int temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, temp);
	}
	public void insert(int n) {
		heap.add(n); size++;
		for(int i=size; i>1; i/=2) {
			if(heap.get(i) < heap.get(i/2)) swap(i, i/2);
			else break;
		}
	}
	public void delete() {
		if(isEmpty()) System.out.println("0");
		else {
			int trash = heap.get(1);
			heap.set(1, heap.get(size));
			heap.remove(size);
			size--;
			for(int i=1; i*2 <= size;) {
				int left = heap.get(i*2);
				int right;
				if(i*2+1 <= size) right = heap.get(i*2+1);
				else right = Integer.MAX_VALUE;
				
				if(heap.get(i) <= left && heap.get(i) <= right) break;
				
				if(left <= right) { swap(i,i*2); i *= 2; }
				else { swap(i,i*2+1); i = i*2 +1; }
			}
			System.out.println(trash);
		}
	}
}
public class MinumumHeap_1927 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); int next;
		MinHeap hip = new MinHeap();
		for(int i=0; i<N; i++) {
			next = Integer.parseInt(br.readLine());
			if(next == 0) hip.delete();
			else hip.insert(next);
		}
	}
}
