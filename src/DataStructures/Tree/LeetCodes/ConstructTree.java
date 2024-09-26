package DataStructures.Tree.LeetCodes;

import java.util.ArrayList;
import java.util.HashMap;

/*https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/*/
public class ConstructTree {


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }

    private static TreeNode buildHelper(int[] inorder, int os, int oe, int[] postorder, int ps, int pe,HashMap<Integer, Integer> map) {
      if (os>oe ||  ps > pe) return null;
      if (ps==pe || os==oe) new TreeNode(postorder[pe]);
      int value = postorder[pe];
      TreeNode root = new TreeNode(value);
      int index = map.get(value);
      int numleft = index - os;
      root.left = buildHelper(inorder,os,index-1,postorder,ps, ps+numleft-1, map);
      root.right = buildHelper(inorder,index+1,oe,postorder,ps+numleft, pe-1, map);
      return root;
    }


    public static void main(String[] args){
        int[] inorder = {9,3,15,20,7},postorder ={9,15,7,20,3};
        System.out.println(buildTree(inorder, postorder));
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
