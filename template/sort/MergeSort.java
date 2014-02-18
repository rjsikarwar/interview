import java.util.Arrays;

public class MergeSort{
  private static int[] array;
  public static void mergeSort(){
    mergeSort(0, array.length - 1);
  }

  public static void mergeSort(int begin, int end){
    if(begin == end){
      return;
    }
    int middle = (begin + end) / 2;
    mergeSort(begin, middle);
    mergeSort(middle + 1, end);
    merge(begin, middle, end);
  }
  public static void merge(int begin, int middle, int end){
    int [] temp = new int[array.length];
    int i = begin;
    int j = middle + 1;
    int k = begin;
    while(i <= middle && j <= end){
      if(array[i] > array[j]){
        temp[k++] = array[j++];
      }else{
        temp[k++] = array[i++];
      }
    }
    while(i<=middle){
      temp[k++] = array[i++];
    }
    while(j <= end){
      temp[k++] = array[j++];
    }
    System.out.println(Arrays.toString(temp));
    for(int m = begin; m <=end; m++){
      array[m] = temp[m];
    }
  }
  public static void main(String[] args){
    array = new int[]{2, 3, 1, 7, 3, 0, -5, 9, 4};
    System.out.println(Arrays.toString(array));
    mergeSort();
    System.out.println(Arrays.toString(array));
  }
}
