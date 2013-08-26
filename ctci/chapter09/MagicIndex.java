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

  public static int findMagicIndex_RecursionFollowUp(int[] array){
    int len = array.length;
    findMagicIndex_RecursionFollowUp(array, 0, len - 1);
  }

  public static int findMagicIndex_RecursionFollowUp(int[] array, int minIndex, int maxIndex){
    if(minIndex > maxIndex || minIndex < 0 || maxIndex >= array.length){
      return -1;
    }
    int middleIndex = (minIndex + maxIndex) >>> 1;
    if(array[middleIndex] == middleIndex){
      return middleIndex;
    }
    int result = -1;
    
    int tmpIndex = Math.max(middleIndex + 1, array[middleIndex]);
    result = findMagicIndex_RecursionFollowUp(array, tmpIndex, maxIndex);
    if(result >= 0){
      return result;
    }

    int tmpIndex = Math.min(middleIndex - 1, array[middleIndex]);
    return findMagicIndex_RecursionFollowUp(array, minIndex, tmpIndex);
    
  }

  public static void main(String[] args){
    int[] array = new int[]{1,2,3,5,8,9};
    System.out.print(findMagicIndex(array));
  }
}