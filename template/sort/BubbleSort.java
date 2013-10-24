import java.util.Arrays;

public class BubbleSort{
  private static int[] array;

  public static void bubbleSort(){
    int len = array.length;
    for(int i = len - 1; i >= 0; i--){
      for(int j = 0; j < i; j++){
        if(array[j] > array[j + 1]){
          swap(j, j + 1);
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
    bubbleSort();
    System.out.println(Arrays.toString(array));
  }
}
