/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int result=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }
    private long[] dfs(TreeNode node){
        if(node==null){
            return new long[]{0,0};
        }
        long[]left=dfs(node.left);
        long[]right=dfs(node.right);

        long sum=left[0]+right[0]+node.val;
        long count=left[1]+right[1]+1;

        if(sum/count==node.val){
            result++;
        }
        return new long[]{sum,count};
    }
}