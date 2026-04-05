package org.example.java.problems.binarytree;
/*

129. Sum Root to Leaf Numbers
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Solution : Use recursion, return int as sum of each branch, also take a param to capture the sum
1) if it's a leave root append the String value of root to the param and then convert it into int and return the value;
2) return sum of recursive method call of both root.left and root.right



 */
public class SumRootToLeafNumbers {
    static int sum = 0;
    public static void main(String args[]){
        TreeNode l3 = new TreeNode(2);
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        TreeNode r3 = new TreeNode(3, l2, r2);
        TreeNode root = new TreeNode(1,l3,r3);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
       return addNumberRecursion(root, "");

    }

    public static int addNumberRecursion(TreeNode root, String branchSum ){
        if(root == null) return 0;
        if(root.left == null &&  root.right == null) {
            return Integer.parseInt(branchSum + root.val);

        }
        return addNumberRecursion( root.left,  branchSum + root.val) +
                addNumberRecursion( root.right,  branchSum + root.val);

        }




   private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
