public class BinaryTree {
	Node head;
	private int size;
	
	public BinaryTree() {
		size = 0;
		head = null;
	}
	
	public int size() {
		return size;
	}
	
	public void add(Node n) {
		if (size == 0) {
			head = n;
			size++;
		}
		Node curr = head;
		while (curr.right != null && curr.left != null) {
			if (n.data() >= curr.data()) {
				curr = curr.right;
			}
			if (n.data() < curr.data()) {
				curr = curr.left;
			}
		}
		if (n.data() < curr.data()) {
			curr.left = n;
		}
		if (n.data() >= curr.data()) {
			curr.right = n;
		}
		
	}
	
	public void print() {
		//print all the elements - no specifics on how for the time being
		System.out.println(head.data());
		System.out.println(head.left.data());
		System.out.println(head.right.data());
		
	}
	
	public String bfs() {
		//return a string representation of the nodes in a breadth first search order
		return "";
	}
	
	//pre-order depth-first-search traversal
	public String dfs() {
		return "";
	}
	
	public static void main(String[] arg) {
		System.out.println("hi");
		BinaryTree tree = new BinaryTree();
		tree.add(new Node(4));
		tree.add(new Node(3));
		tree.add(new Node(2));
		tree.print();
		
		
	}
}


class Node {
	private int data;
	public Node left, right;
	
	public Node(int t) {
		data = t;
		left = null;
		right = null;
	}
	
	public int data() {
		return data;
	}
	
	public void setData(int t) {
		data = t;
	}
}
