

/**
 * Given a set of numbers, find the length of the longest arithmetic progression(LAP) in it
 * 1) all the numbers in LAP should be continuous
 * Example:
 *    {1, 2, 3, 5, 4}
 *    output = 3
 *    The lap is {1, 2, 3}
 *   
 * 2) what if we do not care about the position
 * Example:
 *    {1, 7, 10, 15, 27, 29}
 *    output = 3
 *    The longest arithmetic progression is {1, 15, 29}
 *
 */
public class LongestArithmeticProgression{
  public static int getLengthLAPContinues(int[] array){
    int len = array.length;
    if(null == array || 0 == len){
      return 0;
    }
    if(1 == len){
      return 1;
    }
    int ret = 2;
    int maxSofar = 2;
    int diff = 0;
    for(int i = 1; i < len; i++){
      int currDiff = array[i] - array[i - 1];
      if(currDiff == diff){
        maxSofar++;
      }else{
        ret = Math.max(ret, maxSofar);
        diff = currDiff;
        maxSofar = 2;
      }
    }
    ret = Math.max(ret, maxSofar);
    return ret;
  }

  public static int getLengthLAP(int[] array){
  
  }

  public static void main(String[] args){
    int[] array = new int[]{1, 2, 4, 6, 7, 8, 10};
    System.out.println(getLengthLAPContinues(array));

  }
}

