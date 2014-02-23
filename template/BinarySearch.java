package template;


public class BinarySearch{
  public static boolean binarySearchRecursion(int[] array, int target){
    return binarySearchRecursion(array, target, 0, array.length - 1);
  }

  public static boolean binarySearchRecursion(int[] array, int target, int min, int max){
    if(min > max){
      return false;
    }
    int middle = (min + max) >>> 1;
    if(array[middle] ==  target){
      return true;
    }else if(array[middle] > target){
      return binarySearchRecursion(array, target, min, middle - 1);
    }else{
      return binarySearchRecursion(array, target, middle + 1, max);
    }
  }

  public static boolean binarySearchIteration(int[] array, int target){
    int min = 0;
    int max = array.length - 1;
    int middle = 0;
    while(min <= max){
      middle = (min + max) >>> 1;
      if(array[middle] == target){
        return true;
      }else if(array[middle] > target){
        max = middle - 1;
      }else{
        min = middle + 1;
      }
    }
    return false;
  }

  public static void main(String[] args){
    int[] array = new int[]{1,2,3,4,5,6,7,8};
    System.out.println(binarySearchRecursion(array, 6));
    System.out.println(binarySearchIteration(array, 6));
    System.out.println(binarySearchRecursion(array, 0));
    System.out.println(binarySearchIteration(array, 9));

  }

}
