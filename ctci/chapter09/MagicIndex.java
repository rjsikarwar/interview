package ctci.chapter09;

/**
* A magic index in an array A[1...n-1] is defined to be an index
* such that A[i] = i. Given a sorted array of distinct integers, 
* write a method to find a magic index, if one exists, in array A
* FOLLOW UP
* What if the values are not distinct?
*/
public class MagicIndex{
  public static int findMagicIndex(int[] array){
    int len = array.length;
    int minIndex = 0;
    int maxIndex = len - 1;
    int middle = 0;
    while(minIndex < maxIndex){
      middle = (minIndex + maxIndex) >>> 1;
      if(array[middle] == middle){
        return middle;
      }else if(array[middle] < middle){
        minIndex = middle + 1;
      }else{
        maxIndex = middle - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args){
    int[] array = new int[]{1,2,3,5,8,9};
    System.out.print(findMagicIndex(array));
  }
}