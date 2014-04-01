import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;


/**
 * Given a list of strings, structured as below:
 *
 * usr
 *  bin
 *    lib
 *    foo
 * home
 *    zhaohui
 *    tom
 *    punya
 *      docs
 * etc
 * 
 * Noticed that each level is derterminated by the number of tabs and name in each level is a sub level
 * of its nearest above name
 * 1) Think of a data structure to describe the structure of the above names
 * 2) Given a list of strings, how can you construct such data structure
 *
 */

public class FilePath{
  /**
   * Use a tree to represent this structure
   * Each tree node have a String value and a list of sub trees
   */
  public class TreeNode{
    String val;
    List<TreeNode> subs;
    public TreeNode(String v){
      this.val = v;
      this.subs = new ArrayList<TreeNode>();
    }

    public void addSub(TreeNode sub){
      this.subs.add(sub);
    }

    //gets and sets ignored
  }

  /*
   * First try:simple implementation, with each node add from the root of
   * the tree
   * Time complexity: O(nlogn) if the tree is balanced, O(n^2) worst case
   */
  public TreeNode parse(List<String> input){
    //use root to represent tree root
    TreeNode root = new TreeNode("root");
    for(String one:input){
      int len = one.length();
      int tabs = 0;
      String name = "";
      for(int i = 0; i < len; i++){
        if(one.charAt(i) == '\t'){
          tabs++;
        }else{
          name = one.substring(tabs, len);
          break;
        }
      }
     parseHelper(root, tabs, name);
    }
    return root;
  }

  public void parseHelper(TreeNode node, 
      int depth, String name){
    if(node == null || depth < 0){
      return;
    }
    TreeNode tmp = node;
    while(depth > 0){
      tmp = tmp.subs.get(tmp.subs.size() - 1);
    }
    tmp.subs.add(new TreeNode(name));
  }

  /* Second try: use a hashMap to save the curr node's parent
   * Time will be O(n), space will be O(n)
   */
  public TreeNode parse2(List<String> input){
    TreeNode root = new TreeNode("root");
    Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
    map.put(0, root);
    for(String one:input){
      int len = one.length();
      int tabs = 0;
      String name = "";
      for(int i = 0; i < len; i++){
        if(one.charAt(i) == '\t'){
          tabs++;
        }else{
          name = one.substring(tabs, len);
          break;
        }
      }
      TreeNode par = map.get(tabs);
      TreeNode curr = new TreeNode(name);
      par.subs.add(curr);
      map.put(tabs + 1, curr);
    }
    return root;
  }
  
  /*
   * Third try: use stack instead of map. 
   * The function of map in parse2 actually is like a stack
   * Time complexity: O(n) Space O(n) but will be more effcient than map
   */
  public TreeNode parse3(List<String> input){
    TreeNode root = new TreeNode("root");
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    int last = - 1;
    for(String one:input){
      int len = one.length();
      int tabs = 0;
      String name = "";
      for(int i = 0; i < len; i++){
        if(one.charAt(i) == '\t'){
          tabs++;
        }else{
          name = one.substring(tabs, len);
          break;
        }
      }
      int temp = tabs;
      while(temp <= last){
        stack.pop();
        temp--;
      }
      TreeNode par = stack.peek();
      TreeNode curr = new TreeNode(name);
      par.subs.add(curr);
      stack.push(curr);
      last = tabs;
    }
    return root;
  }
  public static void main(String[] args){
    
  }



}
