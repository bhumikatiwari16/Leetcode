package dfs;

import java.util.*;

class TreeNode2 {
  int val;
  TreeNode2 left;
  TreeNode2 right;

  TreeNode2(int x) {
    val = x;
  }
};

class SumOfPathNumbers {
  public static int findSumOfPathNumbers(TreeNode2 root) {
	  
	// check if root == null, return -1
	  if (root == null) {
		  return 0;
	  }
	  
	  List<Integer> l = new ArrayList();
	  int res = 0;
	 
	// increment sum by root
	 
	  int op = helper(root, res);
	  
	 return op;
	
	 
  }
  
  public static int helper (TreeNode2 root, int res) {
	  
	  if (root == null) {
		  
		  return 0;
		  
	  }
	  
	  if (root.left != null) {
		 
		  res += helper(root.left, res);
		  
	  }
	  
	  if (root.right != null) {
		  
		  res += helper(root.right, res);
		  
	  }
	  
	  return res;
	  
	  
  }

  public static void main(String[] args) {
    TreeNode2 root = new TreeNode2(1);
    root.left = new TreeNode2(0);
    root.right = new TreeNode2(1);
    root.left.left = new TreeNode2(1);
    root.right.left = new TreeNode2(6);
    root.right.right = new TreeNode2(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}

