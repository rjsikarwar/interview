package ctci.chapter09;

import java.util.Set;
import java.util.HashSet;

/*
* Implement an algorithm to print all valid(ie. properly opened and closed) 
* combinations of n-pairs of parentheses
*/
public class Parentheses{
  public Set<String> allParentheses(int num){
    Set<String> results = new HashSet<String>();
    if(num == 0){
      results.add("");
    }
    // remove the situation which could get from the following condition 
    /*else if(num == 1){
      results.add("()");
    }*/
    else{
      Set<String> former = allParentheses(num - 1);
      for(String single:former){
        for(int i = 0; i < single.length(); i++){
          if(single.charAt(i) == '('){
            results.add(parentheseFromIndex(single, i));
          }
        }
        results.add("()" + single);
      }
    }
    return results;
  }

  private String parentheseFromIndex(String str, int index){
    StringBuilder sb = new StringBuilder();
    sb.append(str.substring(0, index + 1));
    sb.append("()");
    sb.append(str.substring(index + 1));
    return sb.toString();
  }

  public static void main(String[] args){
    Parentheses pr = new Parentheses();
    Set<String> results = pr.allParentheses(2);
    for(String result:results){
      System.out.println(result);
    }
  }
}