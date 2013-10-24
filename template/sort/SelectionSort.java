import java.util.Arrays;
public class SelectionSort{
  public static int[] array;
  public static void selectionSort(){
    int len = array.length;
    for(int i = 0; i < len - 1; i++){
      int minIndex = minIndex(i);
      swap(i, minIndex);
    }
  }

  public static int minIndex(int beginIndex){
    int min = beginIndex;
    for(int i = beginIndex; i < array.length; i++){
      if(array[i] < array[min]){
        min = i;
      }
    }
    return min;
  }

  public static void swap(int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void main(String[] args){
    array = new int[]{2,4,7,3,1,7,4,5,0,6};
    selectionSort();
    System.out.println(Arrays.toString(array));
  }
}
