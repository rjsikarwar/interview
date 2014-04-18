package edu.nyu.zhaohui.amazon;

public class MergeTwoSortedList{
  //recursion
  public ListNode<Integer> merge(ListNode<Integer> node1, ListNode<Integer> node2){
    if(node1 == null){
      return node2;
    }
    if(node2 == null){
      return node1;
    }
    
    if(node1.val < node2.val){
      node1.next = merge(node1.next, node2);
      return node1;
    }else{
      node2.next = merge(node1, node2.next);
      return node2;
    }
  }
  
  //iteration
  public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    ListNode<Integer> head = new ListNode<Integer>(Integer.MIN_VALUE);
    ListNode<Integer> prev = head;
    while(l1 != null && l2 != null){
        if(l1.val < l2.val){
            prev.next = l1;
            prev = l1;
            l1 = l1.next;
        }else{
            prev.next = l2;
            prev = l2;
            l2 = l2.next;
        }
    }
    if(l1 != null){
        prev.next = l1;
    }
    if(l2 != null){
        prev.next = l2;
    }
    return head.next;
}
}
