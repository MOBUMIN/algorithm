package d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Tree{
	char val;
	Tree left;
	Tree right;
	
	Tree(char value, Tree left, Tree right) {
		this.val = value;
		this.left = left;
		this.right = right;
	}
	static void preorder(Tree r) { // 전위순회, 루트-왼-오
		if(r == null || r.val == '.') return;
		System.out.print(r.val);
		preorder(r.left);
		preorder(r.right);
	}
	static void inorder(Tree l) { // 중위순회, 왼-루트-오
		if(l == null || l.val == '.') return;
		inorder(l.left);
		System.out.print(l.val);
		inorder(l.right);
	}
	static void postorder(Tree l) { // 후위순회, 왼-오-루트
		if(l == null || l.val == '.') return;
		postorder(l.left);
		postorder(l.right);
		System.out.print(l.val);
	}
}

public class treeorder_1991 {

	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		/* 미리 tree들을 초기화(?) 시켜둬야 나중에 null이 아닌 제대로 된 주소값을 입력받을 수 있음 */
		Tree[] t = new Tree[100];
		for(char i='A';i<'Z'+1; i++)
			t[i] = new  Tree(i,null,null);
		
		char a, b, c;
		char root = 'a';
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = st.nextToken().charAt(0);
			b = st.nextToken().charAt(0);
			c = st.nextToken().charAt(0);		
			t[a].left = t[b]; t[a].right = t[c];
			if(i==0) root =a;
		}
		t[root].preorder(t[root]); System.out.println();
		t[root].inorder(t[root]); System.out.println();
		t[root].postorder(t[root]);
	}
}
