
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
  public static void merge(int begin, int middle, ind end){
    int [] temp = new int[array.length];
    int i = begin;
    int j = middle + 1;
    while(i <= middle && j <== end){
      if(array[i] > array[j]){
        swap(i, j);
      }
    }
  }
  public static void main(String[] args){
    
  }
}