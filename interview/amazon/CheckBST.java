package edu.nyu.zhaohui.amazon;

/**
 * 
 * binary-search-tree property:
 * Let x be a node in a binary search tree. If y is a node in the left subtree of x, 
 * then y:val <= x:val. If y is a node in the right subtree of x, then y:val >= x:val.
 * 
 * @author zhaohui
 */
public class CheckBST{
  
  /**
   * 
   * @param root
   * @return
   */
  public boolean isBST(TreeNode<Integer> root){
    if(root == null){
      return false;
    }
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  private boolean isBST(TreeNode<Integer> node, int min, int max){
    if(node == null){
      return true;
    }
    int val = node.getVal();
    if(val >= min && val <= max && 
        isBST(node.left, min, val) && isBST(node.right, val, max)){
      return true;
    }
    return false;
  }
}
