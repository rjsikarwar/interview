package edu.nyu.zhaohui.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection {
  public List<Integer> intersec(List<Integer> list1, List<Integer> list2){
    if(list1 == null || list2 == null){
      return null;
    }
    List<Integer> ret = new ArrayList<Integer>();
    if(list1.size() == 0 || list2.size() == 0){
      return ret;
    }
    
    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    for(int i : list1){
      map.put(i, false);
    }
    for(int j : list2){
      if(map.containsKey(j)){
        map.put(j, true);
      }
    }
    for(int one : map.keySet()){
      if(map.get(one)){
        ret.add(one);
      }
    }
    return ret;
  }
  
  public static void main(String[] args){
    Integer[] array1 = new Integer[]{4, 2, 73, 11, 9};
    Integer[] array2 = new Integer[]{-5, 73, -1, 9, 9, 4, 7};
    Intersection intersection = new Intersection();
    List<Integer> ret = intersection.intersec(Arrays.asList(array1), Arrays.asList(array2));
    System.out.println(ret.toString());
  }
}
