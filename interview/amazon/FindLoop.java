package edu.nyu.zhaohui.amazon;

public class FindLoop<T> {
  
  public boolean hasLoop(ListNode<T> head){
    if(head == null){
      return false;
    }
    ListNode<T> fast = head;
    ListNode<T> slow = head;
    
    while(fast != null && fast.next == null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){
        return true;
      }
    }
    return false;
  }
}
