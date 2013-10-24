import java.util.Arrays;

public class InsertSort{
  private static int[] array;
  public static void insertSort(){
    for(int i = 1; i < array.length; i++){
      for(int j = 0; j < i; j++){
        if(array[j] > array[i]){
          int temp = array[i];
          for(int k = i; k > j; k--){
            array[k] = array[k - 1];
          }
          array[j] = temp;
          break;
        }
      }
    }
  }

  public static void insertSortSwap(){
    for(int i = 1; i < array.length; i++){
      for(int j = i; j > 0; j--){
        if(array[j] < array[j - 1]){
          swap(j, j - 1);
        }else{
          break;
        }
      }
    }
  }

  public static void swap(int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void main(String[] args){
    array = new int[]{2,4,7,3,1,7,4,5,0,6};
    insertSortSwap();
    System.out.println(Arrays.toString(array));
  }

}
