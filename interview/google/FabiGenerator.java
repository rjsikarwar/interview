import java.util.List;
import java.util.ArrayList;

/**
 * write an extended fabinacci generator class
 * if given k, j, we could have fab(n) = fab(n - k) + fab(n -j) 
 * also implements a next() method which could return the next fab number
 *
 */ 
public class FabiGenerator{
  private static List<Integer> cache;
  private int k; 
  private int j; 
  private int ind;

  public FabiGenerator(int k, int j){
    this.cache = new ArrayList<Integer>();
    this.k = k;
    this.j = j;
    this.ind = 0;
  }

  public int next(){
    if(ind == 0 || (ind < k && ind < j)){
      cache.add(1);
      ind++;
      return cache.get(ind - 1);
    }
    
    int ret = 0;
    if(ind >= k){
      ret += cache.get(ind - k);
    }
    if(ind >= j){
      ret += cache.get(ind - j);
    }
    cache.add(ret);
    ind++;
    return ret;
  }

  public static void main(String[] args){
    FabiGenerator fab = new FabiGenerator(1, 3);
    for(int i = 0; i < 20; i++){
      System.out.println(i + ": " + fab.next());
    }
  }
}
