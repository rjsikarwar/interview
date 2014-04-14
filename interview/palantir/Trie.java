

public class Trie{
   static TreeNode createTrie(){
     return new TreeNode(null);
   }

   static void insert(TreeNode root, String word){
     int offset = 'a';
     int l = word.length();
     char[] letters = word.toCharArray();
     TreeNode currNode = root;
     for(int i = 0; i < l; i++){
       if(currNode.links[letters[i] - offset] == null){
         currNode.links[letters[i] - offset] = new TreeNode(letters[i]);
       }
       currNode = currNode.links[letters[i] - offset];
     }
     currNode.fullWords = true;
   }

   static boolean find(TreeNode root, String word){
     int offset = 'a';
     int l = word.length();
     char[] letters = word.toCharArray();
     TreeNode currNode = root;
     for(int i = 0; i < l; i++){
       currNode = currNode.links[letters[i] - offset];
       if(currNode == null){
         return false;
       }
     }
     if(!currNode.fullWords){
       return false;
     }
     return true;
   }
}
