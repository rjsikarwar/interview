package ctci.chapter09;

import java.util.List;
import java.util.ArrayList;

/**
* Write a method to compute all permutations of a string
*/
public class Permutations{
  public static List<String> getAllPermutations(String str){
    return getAllPermutations(str, 0);
  }

  public static List<String> getAllPermutations(String str, int index){
    int len = str.length();
    if(index >= len || index < 0){
      return null;
    }

    char[] array = str.toCharArray();
    List<String> result = new ArrayList<String>();
    if(index == len - 1){
      result.add(String.valueOf((array[len - 1])));
    }else{
      List<String> cache = getAllPermutations(str, index + 1);
      for(String single:cache){
        result.addAll(getPermutationsWithChar(single, array[index]));
      }
    }
    return result;
  }

  public static List<String> getPermutationsWithChar(String str, char c){
    
    List<String> result = new ArrayList<String>();
    result.add(String.valueOf(c) + str);
    for(int i = 1; i <= str.length(); i++){
      StringBuilder sb = new StringBuilder();
      String part1 = str.substring(0, i);
      String part2 = str.substring(i);
      sb.append(part1);
      sb.append(c);
      sb.append(part2);
      result.add(sb.toString());
    }
    return result;
  }

  public static void main(String[] args){
    String str = "abc";
    List<String> results = getAllPermutations(str);
    for(String result:results){
      System.out.println(result);
    }
  }
}