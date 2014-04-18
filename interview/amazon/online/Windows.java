package edu.nyu.zhaohui.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Windows {
  public static List<Integer> calculateWindowsSums(List<Integer> list, int windowSize){
    if(null == list){
      throw new IllegalArgumentException("list should not be null");
    }
    List<Integer> ret = new ArrayList<Integer>();
    if(list.size() == 0 || windowSize <= 0){
      return ret;
    }
    int total = 0;
    for(int i = 0; i < list.size(); i++){
      if(i < windowSize){
        total += list.get(i);
      }else{
        ret.add(total);
        total -= list.get(i - windowSize);
        total += list.get(i);
      }
    }
    ret.add(total);
    return ret;
  }
  
  public static void main(String[] args){
    Integer[] one = new Integer[]{4, 2, 73, 11, -5};
    List<Integer> input = new ArrayList<Integer>(Arrays.asList(one));
    List<Integer> ret = calculateWindowsSums(input, 2);
    List<Integer> ret2 = calculateWindowsSums(input, 3);
    for(Integer i : ret){
      System.out.print(i + " ");
    }
    for(Integer i : ret2){
      System.out.print(i + " ");
    }
  }
}
