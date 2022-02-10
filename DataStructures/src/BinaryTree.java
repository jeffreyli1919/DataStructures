import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	static Node root;
	private int size;
	ArrayList<Node> nodes;
	static String dBuilder;
	
	public BinaryTree() {
		size = 0;
		root = null;
		nodes = new ArrayList<Node>();
		dBuilder = "";
	}
	
	public int size() {
		return size;
	}
	
	public Node addRecursive(Node current, int data) {
		if (current == null) {
			return new Node(data);
		}
		
		if (data < current.data()) {
			current.left = addRecursive(current.left, data);
		} else if (data >= current.data()) {
			current.right = addRecursive(current.right, data);
		}
		
		
		return current;
	}
	
	public void add(Node n) {
		nodes.add(n);
		root = addRecursive(root, n.data());
		
	}
	
	public void print() {
		//print all the elements - no specifics on how for the time being
		for (int i = 0; i < nodes.size(); i++) {
			System.out.println(nodes.get(i).data()+ " ");
		}
		
	}
	
	public String bfs() {
		//return a string representation of the nodes in a breadth first search order
		if (root == null) {
			return "";
		}
		String builder = "";
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		
		while (nodes.size() > 0) {
			Node node = nodes.remove();
			builder = builder + " " + node.data(); 
			if (node.left != null) {
				nodes.add(node.left);
			}
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
		return builder;
	}
	
	//pre-order depth-first-search traversal
	public String dfs(String str) {
		String builder = "";
		preOrderTraverse(root);
		
		return builder;
	}
	
	public void preOrderTraverse(Node n) {
		if (n != null) {
			System.out.print(" " + n.data());
			dBuilder += " " + n.data();
			preOrderTraverse(n.left);
			preOrderTraverse(n.right);
		}
	}
	
	public static void main(String[] arg) {
		System.out.println("hi");
		BinaryTree tree = new BinaryTree();
		tree.add(new Node(6));
		tree.add(new Node(4));
		tree.add(new Node(5));
		tree.add(new Node(8));
		tree.add(new Node(3));
		tree.add(new Node(7));
		tree.add(new Node(9));
		tree.print();
		System.out.println(tree.bfs());
		tree.preOrderTraverse(root);
		System.out.println();
		System.out.println(dBuilder);
		
		
		
		
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




/*
if (size == 0) {
	root = n;
	size++;
}
Node curr = root;
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

if (n.data() >= curr.data()) {
	while (curr.right != null) {
		if (n.data() >= curr.data()) {
			curr = curr.right;
		} else if (n.data() < curr.data()) {
			curr = curr.left;
		}
	}
}
*/
