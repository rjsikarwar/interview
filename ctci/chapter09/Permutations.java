package ctci.chapter09;

import java.util.List;
import java.util.ArrayList;

/**
* Write a method to compute all permutations of a string
*/
public class Permutations{

  // Own solution
  public static List<String> getAllPermutations(String str){
    if(str == null){
      return null;
    }
    return getAllPermutations(str, 0);
  }

  public static List<String> getAllPermutations(String str, int index){
    int len = str.length();
    if(index > len || index < 0){
      return null;
    }

    List<String> result = new ArrayList<String>();
    if(index == len){
      result.add("");
    }else{
      List<String> cache = getAllPermutations(str, index + 1);
      for(String single:cache){
        result.addAll(getPermutationsWithChar(single, str.charAt(index)));
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

  // Solutions from the book
  public static ArrayList<String> getPerms(String str){
    if(str == null){
      return null;
    }
    ArrayList<String> results = new ArrayList<String>();
    if(str.length() == 0){
      results.add("");
      return results;
    }

    char first = str.charAt(0);
    ArrayList<String> remain = getPerms(str.substring(1));

    for(String word:remain){
      for(int j = 0; j <= word.length(); j++){
        results.add(insertCharAt(word, first, j));
      }
    }
    return results;
  }

  public static String insertCharAt(String word, char c, int index){
    String start = word.substring(0, index);
    String end = word.substring(index);
    return start + c + end;
  }
  

  public static void main(String[] args){
    String str = "ab";
    System.out.println("TEST Substring: " + str.substring(0));
    List<String> results = getAllPermutations(str);
    for(String result:results){
      System.out.println(result);
    }
    System.out.println("another method:");

    results = getPerms(str);
    for(String result:results){
      System.out.println(result);
    }

  }
}