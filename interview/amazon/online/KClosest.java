package edu.nyu.zhaohui.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosest {
  private final static int K = 5;
  public List<Point> findKClosest(List<Point> points){
    PriorityQueue<Point> heap = new PriorityQueue<Point>();
    for(Point point : points){
      if(heap.size() < K){
        heap.add(point);
      }else{
        if(heap.peek().compareTo(point) < 0){
          heap.poll();
          heap.offer(point);
        }
      }
    }
    return new ArrayList<Point>(heap);
  }
}
