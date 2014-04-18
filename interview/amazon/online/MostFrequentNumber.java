package edu.nyu.zhaohui.amazon;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentNumber {
  public static int mostFrequent(int[] array){
    if(null == array || 0 == array.length){
      throw new IllegalArgumentException();
    }
    int ret = 0;
    int freq = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int num : array){
      if(!map.containsKey(num)){
        map.put(num, 1);
      }else{
        int oldFreq = map.get(num);
        map.put(num, oldFreq + 1);
        if(oldFreq + 1 > freq){
          freq = oldFreq + 1;
          ret = num;
        }
      }
    }
    return ret;
  }
  
  public static void main(String[] args){
    int[] array = new int[]{1, 3, -4, 0, 9, 0, -4, 3, -4, 10000, -398};
    System.out.println(mostFrequent(array));
  }
}
