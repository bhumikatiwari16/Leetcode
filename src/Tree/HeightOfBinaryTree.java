package Tree;

public class HeightOfBinaryTree {

	public static void main(String[] args) {
		
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(12);
		root.left.left = new Node(6);
		root.left.right = new Node(9);
		root.left.left.left = new Node(5);
		root.left.left.right = new Node(7);
		root.right.left = new Node(11);
		root.right.right = new Node(14);
		
		System.out.println(findHeight(root));

	}
	
	static int findHeight(Node n) {
		
		if (n == null) {
			return 0;
		}
		
		int maxLeft = findHeight(n.left);
		int maxRight = findHeight(n.right);
		
		return Math.max(maxLeft, maxRight) + 1;
		
	}

}
