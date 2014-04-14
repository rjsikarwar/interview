import java.util.Set;
import java.util.HashSet;
import java.util.BinarySearchTree;

public class Duplicate{
  private class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v){
      this.val = v;
    }
    
    boolean static addAndCheck(TreeNode root, TreeNode node, int range){
      if(node == null){
        return true;
      }
      if(root == null){
        root = node;
        return true;
      }
      int diff = Math.abs(node.val - this.val);
      if(diff < range){
        return false;
      }
      if(node.val < root.val){
        return addAndCheck(root.left, node, range);  
      }else{
        return addAndCheck(root.right, node, range);
      }
    }
  }
  public static boolean checkDuplicate(int[] input){
    Set set = new HashSet<Integer>();
    for(int one : input){
      if(set.contains(one)){
        return true;
      }else{
        set.add(one);
      }
    }
    return false;
  }

  public static boolean checkDuplicateWithKIndices(int[] input, int k){
    Set<Integer> set = new HashSet<Integer>();
    for(int i = 0; i < input.length; i++){
      if(i >= k){
        set.remove(input[i - k]);
      }
      if(set.contains(input[i])){
        return true;
      }else{
        set.add(input[i]);
      }
    }
    return false;
  }

  public static boolean checkDupWithKIndLRange(int[] input, int k, int l){
    Set<Integer> set = new HashSet<Integer>();
    TreeNode root;
    for(int i = 0; i < input.length; i++){
      if(root == null){
        root = new TreeNode(input[i]);
      }
    }

  }


}
