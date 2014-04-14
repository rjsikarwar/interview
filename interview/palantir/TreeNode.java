

public class TreeNode{
  char letter;
  TreeNode[] links;
  boolean fullWords;

  TreeNode(char l){
    this.letter = l;
    this.links = new TreeNode[26];
    this.fullWords = false;
  }
}
