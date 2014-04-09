
/**
 *Write a function that takes a string with 0, 1, * characters, and 
 * returns a collection where *s are replaced with all possible values of 0, 1.
 * For example, “00*1*0” => {“001100”, “001110”, “000110”, “000100”}
 *
 */
import java.util.List;
import java.util.ArrayList;

public class ReplaceWithZeroOne{
  public static List<String> replaceZeroOne(String str){
    List<String> ret = new ArrayList<String>();
    if(null == str || 0 == str.length()){
      return ret;
    }
    String temp = "";
    helper(str, ret, temp);
    return ret;
  }

  private static void helper(String str, List<String> ret, String temp){
    int begin = temp.length();
    int len = str.length();
    int ind = begin;
    while(ind < len && str.charAt(ind) != '*'){
      ind++;
    }
    temp = temp + str.substring(begin, ind);
    if(ind >= len){
      ret.add(temp);
    }else{
      helper(str, ret, temp + "0");
      helper(str, ret, temp + "1");
    }
  }

  public static void main(String[] args){
    String str = "00*1*0";
    List<String> ret = replaceZeroOne(str);
    for(String one : ret){
      System.out.println(one);
    }
  }

}
