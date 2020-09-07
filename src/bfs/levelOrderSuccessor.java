package bfs;

/*
 * https://www.educative.io/courses/grokking-the-coding-interview/7nO4VmA74Lr
 * 
 * Given a binary tree and a node, 
 * find the level order successor of the given node in the tree. 
 * The level order successor is the node that appears right after the given node 
 * in the level order traversal.

Example 1:

1 -> (2,3) -> (2's children: 4 and 5, 3 is leaf node)

 Given Node: 3
 Level Order Successor: 4
 
 Example 2:
 
 12 -> (7,1) -> (7's child: 9, 1's children: 10 and 5)
 
 Given Node: 9
 Level Order Successor: 10
 
 Example 3:
 
 12 -> (7,1) -> (7's child: 9, 1's children: 10 and 5)
 
 Given Node: 12
 Level Order Successor: 7
 
 */

import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class levelOrderSuccessor {
  public static TreeNode findSuccessor(TreeNode root, int key) {
	  
	  if (root == null) {
		  return null;
	  }
	  
	  Queue<TreeNode> q = new LinkedList<TreeNode>();
	  q.add(root);
	  
	  boolean isFound = false;
	  
	  while (!q.isEmpty()) {
		  
		  
		  int queueSize = q.size();
		  for (int i = 0; i < queueSize; i++) {
			  
			  TreeNode temp = q.poll();
			  
			  if (isFound == true) {
				  return temp;
			  }
			  
			  else if (temp.val == key && isFound == false) {
				  isFound = true;
			  }
			 
			  if (temp.left != null) {
				  q.offer(temp.left);
			  }
		  
			  if (temp.right != null) {
				  q.offer(temp.right);
			  }
		  
		  }

	  }
		  return null;    
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    TreeNode result = levelOrderSuccessor.findSuccessor(root, 12);
    if (result != null)
      System.out.println(result.val + " ");
    result = levelOrderSuccessor.findSuccessor(root, 9);
    if (result != null)
      System.out.println(result.val + " ");
  }
}

