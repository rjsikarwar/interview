/**
 * For Mr Zhu, this class has the method to convert a string to the specific format
 * As well as the case provided I also add some more test cases in order to make this program
 * to handle some special cases like no quotes, all numbers in quotes or long white space; 
 * The method works fine with these cases as well
 * 
 * @author zhaohui
 */
public class FormatFile{
  /**
   * This method will format the input string to the required output format
   * I assume all the input (parameter str) is valid, which is that string contains only
   * numbers, double quotes and white space; If not we can easily handle if by throw an 
   * InvalidParameterException when meeting other characters in the string
   * For simplicity I just ignored this situation.
   */
  public static String format(String str){
    if(null == str || 0 == str.length()){
      return str;
    }
    str = str.trim();
    // System.out.println("TRIM: " + str);
    int len = str.length();
    boolean flag = false;
    StringBuilder sb = new StringBuilder();
    int begin = -1;
    for(int j = 0; j < len; j++){
      //duplicate white space, keep looping
      if(str.charAt(j) == ' ' && !flag && j - begin == 1){
        begin = j;
        continue;
      }
      //first meet quotes, keep looping
      if(str.charAt(j) == '\"' && !flag){
        flag = true;
        begin = j;
        continue;
      }
      //meet numbers, keep looping without changing begin
      if(str.charAt(j) >= '0' && str.charAt(j) <= '9' && j < len - 1){
        continue;
      }
      //white space in quotes, keep looping without changing begin
      if(str.charAt(j) == ' ' && flag){
        continue;
      }

      //meet quotes for second time, set flag to false
      if(str.charAt(j) == '\"' && flag){
        flag = false;
      }
      
      //add tokens before to stringbuilder
      sb.append('\"');
      //deal with the situation of last element with no comma
      if(j == len - 1){
        if(str.charAt(j) >= '0' && str.charAt(j) <= '9'){
          sb.append(str.substring(begin + 1, j + 1));
        }else{
          sb.append(str.substring(begin + 1, j));
        }
        sb.append("\"");
      }else{
        sb.append(str.substring(begin + 1, j));
        sb.append("\",");
      }
      begin = j;
    }
    return sb.toString();
  }

  public static void main(String[] args){
    String str = "12 \"23 4\" 456 78 \"2 35\"";
    System.out.println("INPUT:  " + str);
    System.out.println("OUTPUT: " + format(str));
    String str2 = "12 1   34 5 6      ";
    System.out.println("INPUT:  " + str2);
    System.out.println("OUTPUT: " + format(str2));
    String str3 = "\"12      4\" 3 554 \"1\" \" 2 562 98 \" 56";
    System.out.println("INPUT:  " + str3);
    System.out.println("OUTPUT: " + format(str3));
    String str4 = "\" 1 \"\" 2 \"\" 3 \"";
    System.out.println("INPUT:  " + str4);
    System.out.println("OUTPUT: " + format(str4));
  }
}
