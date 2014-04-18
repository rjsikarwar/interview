package edu.nyu.zhaohui.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CalculateStudentScore {
  private static final int K = 5;
  public Map<Integer, Double> calculateScore(List<StudentResult> results){
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for(StudentResult result: results){
      if(!map.containsKey(result.getStudentId())){
        List<Integer> scores = new ArrayList<Integer>();
        scores.add(result.getTestScore());
        map.put(result.getStudentId(), scores);
      }else{
        map.get(result.getStudentId()).add(result.getTestScore());
      }
    }
    Map<Integer, Double> result = new HashMap<Integer, Double>();
    for(Integer id : map.keySet()){
      List<Integer> scoreList = map.get(id);
      double average = calculateAverage(scoreList);
      result.put(id, average);
    }
    return result;
  }
  
  private double calculateAverage(List<Integer> scores){
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    for(Integer score : scores){
      if(heap.size() < K){
        heap.offer(score);
      }else{
        if(heap.peek() < score){
          heap.poll();
          heap.offer(score);
        }
      }
    }
    double total = 0;
    int num = heap.size();
    for(Integer one : heap){
      total += one;
    }
    return total / num;
  }
  
  public static void main(String[] args){
    List<StudentResult> list = new ArrayList<StudentResult>();
    list.add(new StudentResult(1, "", 100));
    list.add(new StudentResult(2, "", 100));
    list.add(new StudentResult(2, "", 100));
    list.add(new StudentResult(1, "", 98));
    list.add(new StudentResult(1, "", 97));
    list.add(new StudentResult(1, "", 99));
    list.add(new StudentResult(1, "", 96));
    list.add(new StudentResult(1, "", 95));
    list.add(new StudentResult(1, "", 90));
    CalculateStudentScore instance = new CalculateStudentScore();
    Map<Integer, Double> results = instance.calculateScore(list);
    for(Integer key : results.keySet()){
      System.out.println("ID: " + key + " Score: " + results.get(key));
    }
    
  }
}
