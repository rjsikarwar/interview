package interview;


public class QuestionMarkToBinay{
  private char[] strArray;
  public String questionMarkToBinay(String str){
    strArray = str.toCharArray();
    questionMarkToBinay(strArray, 0);
  }

  private questionMarkToBinay(char[] strArray, int index){
    if(strArray.length <= index){
      return "";
    }
    if(strArray[index] == '?'){
      return 
    }
  }
}