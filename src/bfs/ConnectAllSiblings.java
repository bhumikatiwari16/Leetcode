package bfs;

/*
 * https://www.educative.io/courses/grokking-the-coding-interview/qVxy1qop77p

Connect All Level Order Siblings (medium) #
Given a binary tree, connect each node with its level order successor. 
The last node of each level should point to the first node of the next level.

ExAMPLE:

		1
	2		3
4	5		6	7
		
		1->2->3->4->5->6->7->NULL
 * 
 */


import java.util.*;

class TreeNode1 {
  int val;
  TreeNode1 left;
  TreeNode1 right;
  TreeNode1 next;

  TreeNode1(int x) {
    val = x;
    left = right = next = null;
  }
};

class ConnectAllSiblings {
  public static void connect(TreeNode1 root) {
    
	  Queue<TreeNode1> q = new LinkedList();
	  q.offer(root);
	  
	  TreeNode1 prev = null;
	  
	  while (!q.isEmpty()) {
		  
		  int queueSize = q.size();
		  
		  for(int i = 0; i < queueSize; i++) {
			  
			  TreeNode1 cur = q.poll();
			  
			  
			  if(prev == null) {
				  prev = cur;
			  }
			  
			  else {
				  prev.next = cur;
				  prev = cur;
			  }
			  
			  /*
			  
			  if (prev != null) {
				  prev.next = cur;
			  }
			  
			  prev = cur;
			  */
			  
			  if (cur.left != null) {
				  q.offer(cur.left);
			  }
			  
			  if (cur.right != null) {
				  q.offer(cur.right);
			  }
			  
		  }
		  
		  
	  }

  }

  public static void main(String[] args) {
    TreeNode1 root = new TreeNode1(12);
    root.left = new TreeNode1(7);
    root.right = new TreeNode1(1);
    root.left.left = new TreeNode1(9);
    root.right.left = new TreeNode1(10);
    root.right.right = new TreeNode1(5);
    ConnectAllSiblings.connect(root);

    // level order traversal using 'next' pointer
    TreeNode1 current = root;
    System.out.println("Traversal using 'next' pointer: ");
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}