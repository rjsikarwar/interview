
/**
 * Given a two dimentional array of integers,
 * each column and row is sorted in this array,
 * try to find a target value, return true if found
 * otherwise return false
 * For example, we have
 * 1  3  5  8  9
 * 2  5  9  10 45
 * 6  10 11 56 60
 * 45 46 47 72 100
 * will return true if we want to find 45
 */
import java.util.Arrays;
public class SearchInSortedArray{
  public static boolean search(int[][] array, int target){
    if(array == null || array.length == 0 || array[0].length == 0){
      return false;
    }
    int m = 0;
    int n = array[0].length - 1;

    while(n >= 0 && m < array.length){
      if(array[m][n] == target){
        return true;
      }else if(array[m][n] > target){
        n--;
      }else{
        m++;
      }
    }
    return false;
  }
  
  public static void main(String[] args){
    int[][] array = new int[3][2];
    int tmp = 1;
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 2; j++){
        array[i][j] = tmp++;
      }
    }
    System.out.println(Arrays.deepToString(array));
    System.out.println("search 10: " + search(array, 10));
    System.out.println("search 5: " + search(array, 5));

  }
}
