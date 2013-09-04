package others;

/**
* write an algorithm to calculate the edit distance between two strings str1 and str2,
* which is the number of insertation, deletion and modification to go from str1 to str2
* Also known as "Levenshtein Distance"
*/
public class EditDistance{

  // implemented using a m X n matrix
  public int getEditDistance(String str1, String str2){
    int len1 = str1.length();
    int len2 = str2.length();
    if(len1 == 0){
      return len2;
    }
    if(len2 == 0){
      return len1;
    }

    int[][] map = new int[len1 + 1][len2 + 1];
    for(int i = 0; i < len1 + 1; i++){
      map[i][0] = i;
    }
    for(int j = 0; j < len2 + 1; j++){
      map[0][j] = j;
    }

    for(int i = 1; i < len1 + 1; i++){
      for(int j = 1; j < len2 + 1; j++){
        if(str1.charAt(i - 1) == str2.charAt(j - 1)){
          map[i][j] =  map[i - 1][j - 1];
        }else{
          map[i][j] = min(map[i - 1][j] + 1, map[i][j - 1] + 1, map[i - 1][j - 1] + 1);
        }
      }
    }
    return map[len1][len2];
  }

  
  //implement using two rows

  public int getEditDistance_twoRows(String str1, String str2){
    if(str1.equals(str2)){
      return 0;
    }
    int len1 = str1.length();
    int len2 = str2.length();
    if(len1 == 0){
      return len2;
    }
    if(len2 == 0){
      return len1;
    }

    int[] array1 = new int[len2 + 1];
    int[] array2 = new int[len2 + 1];

    for(int i = 0; i < len2 + 1; i++){
      array1[i] = i;
    }

    for(int i = 1; i < len1 + 1; i++){
      array2[0] = i;
      for(int j = 1; j < len2 + 1; j++){
        if(str1.charAt(i - 1) == str2.charAt(j - 1)){
          array2[j] = array1[j - 1];
        }else{
          array2[j] = min(array2[j - 1] + 1, array1[j] + 1, array1[j - 1] + 1);
        }
      }
      for(int j = 0; j < len2 + 1; j++){
        array1[j] = array2[j];
      }

    }
    return array2[len2];
  }

  private int min(int x, int y, int z){
    int result = x < y ? x : y;
    result = result < z ? result : z;
    return result;
  }

  public static void main(String[] args){
    EditDistance ed = new EditDistance();
    System.out.println(ed.getEditDistance_twoRows("Saturday", "Sunday"));
  }
}