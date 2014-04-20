
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * Given an array and an integer k, find the maximum for each and 
 * every contiguous subarray of size k
 *
 */
public class MaximumOfK{
  static List<Integer> maximumOfK(int[] array, int k){
    List<Integer> ret = new ArrayList<Integer>();
    Comparator<Integer> comparator = new Comparator<Integer>(){
      public int compare(Integer i1, Integer i2){
        return i2 - i1;
      }
    };
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, comparator);
    for(int i = 0; i < array.length; i++){
      if(i < k){
        heap.offer(array[i]);
      }else{
        ret.add(heap.peek());
        heap.remove(array[i - k]);
        heap.offer(array[i]);
      }
    }
    ret.add(heap.peek());
    return ret;
  }

  //more efficient way use a double-ended queue
  static List<Integer> maximumDequeue(int[] array, int k){


  }


  public static void main(String[] args){
    int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    List<Integer> ret1 = maximumOfK(a, 3);
    for(int i : ret1){
      System.out.print( i + " ");
    }
    System.out.println();
    
    int[] b = new int[]{9, 2, 3, 8, 5, 3, 7, 3, 9};
    ret1 = maximumOfK(b, 2);
    for(int i : ret1){
      System.out.print( i + " ");
    }
    System.out.println();
  }
}
