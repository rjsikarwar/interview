package ctci.chapter09;

import java.util.ArrayList;

/**
* Write a method to return all subsets of a set
*/
public class SubSet{

  // Recursion method
  public ArrayList<ArrayList<Integer>> getAllSubSetsRecursion(ArrayList<Integer> set){
    int size = set.size();
    return getAllSubSetsRecursion(set, size - 1);
  }

  public ArrayList<ArrayList<Integer>> getAllSubSetsRecursion(ArrayList<Integer> set, int index){
    
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    if(index <= 0){
      results.add(new ArrayList<Integer>());
    }else{
      ArrayList<ArrayList<Integer>> tmp = getAllSubSetsRecursion(set, index - 1);
      results.addAll(tmp);
      for(ArrayList<Integer> curr:tmp){
        ArrayList<Integer> cache = curr;
        cache.add(set.get(index));
        results.add(cache);
      }
    }
    return results;

  }


  // Combinatorics Method
  public ArrayList<ArrayList<Integer>> getAllSubSets(ArrayList<Integer> set){
    int num = set.size();
    int compator = 1 << num;

    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
    for(int i = 0; i < compator; i++){
      ArrayList<Integer> current = getSubSetFromCompator(set, i, num);
      result.add(current);
    }
    return result;
  }

  public ArrayList<Integer> getSubSetFromCompator(ArrayList<Integer> set, int compator, int num){
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(int i = 0; i < num; i++){
      if((compator & (1<<i)) != 0){
        result.add(set.get(i));
      }
    }
    return result;
  }

  public static void main(String[] args){
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(1);
    test.add(2);
    test.add(3);
    SubSet ss = new SubSet();
    ArrayList<ArrayList<Integer>> results = ss.getAllSubSetsRecursion(test);
    for(ArrayList<Integer> result:results){
      for(int i = 0; i < result.size(); i++){
        System.out.print(result.get(i));
      }
      System.out.println();
    }
  }
}