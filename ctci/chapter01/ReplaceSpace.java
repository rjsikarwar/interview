package ctci.chapter01;

import java.util.Arrays;

/**
* Write a method to replace all spaces in a string with ‘%20’
*
*/
public class ReplaceSpace{
  public String replaceSpace(String str){
    StringBuilder sb = new StringBuilder();
    char[] array = str.toCharArray();
    boolean spaceFlag = false;
    for(int i = 0; i < array.length; i++){
      if(array[i] == ' '){
        if(!spaceFlag){
          sb.append("%20");
        }
        spaceFlag = true;
      }else{
        sb.append(array[i]);
        spaceFlag = false;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args){
    ReplaceSpace rs = new ReplaceSpace();
    String str = "a bcd ee  ad#";
    System.out.println(rs.replaceSpace(str));
  }
}