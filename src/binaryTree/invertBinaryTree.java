package binaryTree;

public class invertBinaryTree {


	/*
	 * LeetCode 226
	 * https://leetcode.com/problems/invert-binary-tree/
	 * 
	 *   Invert a binary tree.
	 *   Input:

			     4
			   /   \
			  2     7
			 / \   / \
			1   3 6   9
	 * 
	 * Output:

			     4
			   /   \
			  7     2
			 / \   / \
			9   6 3   1
	 * 
	 */
	
	
	// solved using recursion
	
	public TreeNode invertTree(TreeNode root) {
        
		if (root == null) {
			return root;
		}
		
		TreeNode tempLeft = invertTree(root.left);
		TreeNode tempRight = invertTree(root.right);
	
		root.left = tempRight;
		root.right = tempLeft;
		
		return root;
	
}
