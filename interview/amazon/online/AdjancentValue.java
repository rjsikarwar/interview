package edu.nyu.zhaohui.amazon;

import java.util.Arrays;

public class AdjancentValue {
  private class Combination implements Comparable<Combination>{
    public int index;
    public int value;
    public Combination(int ind, int val){
      this.index = ind;
      this.value = val;
    }
    
    @Override
    public int compareTo(Combination another) {
      return this.value - another.value;
    }
  }
  
  public int minumDistance(int[] array){
    int len = array.length;
    Combination[] comb = new Combination[len];
    for(int i = 0; i < len; i++){
      comb[i] = new Combination(i, array[i]);
    }
    Arrays.sort(comb);
    int ret = Integer.MAX_VALUE;
    int last = comb[0].index;
    boolean firstDifferent = false;
    for(int i = 1; i < len; i++){
      if(comb[i].value != comb[i - 1].value){
        ret = Math.min(ret, Math.abs(comb[i].index - comb[i - 1].index));
        last = comb[i].index - 1;
        firstDifferent = true;
      }else if(firstDifferent){
        ret = Math.min(ret, Math.abs(comb[i].index - last));
      }
    }
    last = comb[len - 1].index;
    firstDifferent = false;
    for(int i = len - 1; i > 0; i--){
      if(comb[i].value != comb[i - 1].value){
        ret = Math.min(ret, Math.abs(comb[i].index - comb[i - 1].index));
        last = comb[i].index;
        firstDifferent = true;
      }else if(firstDifferent){
        ret = Math.min(ret, Math.abs(comb[i].index - last));
      }
    }
    return ret;
  }
  
  public static void main(String[] args){
    int[] a = {0, 3, 3, 7, 5, 3, 11,1};
    int[] b = {1, 4, 7, 3, 3, 5, 6};
    AdjancentValue av = new AdjancentValue();
    System.out.println(av.minumDistance(a));
    System.out.println(av.minumDistance(b));
  }
}
