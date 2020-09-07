package Tree;

public class RecursiveTraversal {

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
		
		System.out.println("Preorder traversal: ");
		preorderTraverse(root);
		
		System.out.println("Postorder traversal: ");
		postorderTraverse(root);
		
		System.out.println("Inorder traversal: ");
		inorderTraverse(root);
		
	}
	
	static void preorderTraverse(Node n) {
		
		if (n == null) {
			return;
		}
		
		System.out.println(n.val);
		
		preorderTraverse(n.left);
		preorderTraverse(n.right);
		
	}
	
	static void postorderTraverse(Node n) {
		
		if(n == null) {
			return;
		}
		
		postorderTraverse(n.left);
		postorderTraverse(n.right);
		
		System.out.println(n.val);
		
	}
	
	static void inorderTraverse(Node n) {
		
		if(n == null) {
			return;
		}
		
		inorderTraverse(n.left);
		
		System.out.println(n.val);
		
		inorderTraverse(n.right);
	}

}
