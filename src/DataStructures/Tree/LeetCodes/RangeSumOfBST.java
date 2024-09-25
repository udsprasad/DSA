package DataStructures.Tree.LeetCodes;

import java.util.ArrayList;
import java.util.List;

/*https://leetcode.com/problems/range-sum-of-bst/description/?envType=problem-list-v2&envId=binary-search-tree&difficulty=EASY*/
public class RangeSumOfBST {
    static TreeNode root;

    // solution method
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int sum =0;

        if (low<=root.val && high>= root.val) {
            sum+= root.val;
        }

        if (low < root.val){
            sum+= rangeSumBST(root.left,low,high);
        }

        if(root.val < high){
            sum+= rangeSumBST(root.right,low,high);
        }

        return sum;
    }


    public static void main(String[] args){
        int[] values = {10,5,15,3,7,18};
        int low = 7, high = 15;

        for(int i : values){
           root = insertHelper(root, i);
        }

        display(root);

        System.out.println(rangeSumBST(root,low,high));
    }

    private static TreeNode insertHelper(TreeNode root, int i) {

        if(root == null){
            TreeNode node = new TreeNode(i);
            root = node;
        } else if (root.val > i){
            root.left = insertHelper(root.left,i);
        } else if (root.val < i) {
            root.right = insertHelper(root.right,i);
        }
        return root;
    }

    public static void display(TreeNode root){
        displayHelper(root);
    }

    private static void displayHelper(TreeNode root) {
        if(root != null){
            displayHelper(root.left);
            System.out.println(root.val);
            displayHelper(root.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
