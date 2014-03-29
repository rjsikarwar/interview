public class BinarySearch{
  public static boolean binarySearch(int[] array, int target){
    int len = array.length;
    int min = 0;
    int max = len - 1;
    while(min <= max){
      int mid = (min + max) >> 1;
      if(array[mid] == target){
        return true;
      }else if(array[mid] > target){
        max = mid - 1;
      }else{
        min = mid + 1;
      }
    }
    return false;
  }
}