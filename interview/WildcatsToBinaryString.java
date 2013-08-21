package interview;

/**
* Given a string pattern of 0s, 1s, and ?s (wildcards), 
* generate all 0-1 strings that match this pattern. 
* e.g. 1?00?101 -> [10000101, 10001101, 11000101, 11001101]. 
* You can generate the strings in any order that suits you. 
*/
public class WildcatsToBinaryString{
  public void wildCatsToBinary(String str){
    wildCatsToBinary(str, 0);
  }

  public void wildCatsToBinary(String str, int index){
    if(str == null || str.length() == 0){
      return;
    }
    while(index < str.length() && str.charAt(index) != '?'){
      index++;
    }

    if(index >= str.length()){
      System.out.println(str);
    }
    char[] charArray = str.toCharArray();
    charArray[index] = 0;
    String str1 = Arrays.toString(charArray);
    wildCatsToBinary(str1, index + 1);
    charArray[index] = 1;
    String str2 = Arrays.toString(charArray);
    
  }

  public static void main(String[] args){

  }
}