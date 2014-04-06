package edu.nyu.zhaohui.amazon;

public class ListNode<T> {
  T val;
  ListNode<T> next;
  
  public ListNode(T val){
    this.val = val;
  }

  public T getVal() {
    return val;
  }

  public void setVal(T val) {
    this.val = val;
  }

  public ListNode<T> getNext() {
    return next;
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
  }
  
  
}
