package edu.nyu.zhaohui.amazon;

public class NotifyCustomers {
  public static ListNode<Integer> notify(ListNode<Integer> head, int k){
    ListNode<Integer> fast = head;
    while(k > 0){
      fast = fast.next;
      k--;
    }
    ListNode<Integer> slow = head;
    while(fast != null){
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
  
  public static void main(String[] args){
    ListNode<Integer> node1 = new ListNode<Integer>(1);
    ListNode<Integer> node2 = new ListNode<Integer>(8);
    ListNode<Integer> node3 = new ListNode<Integer>(4);
    ListNode<Integer> node4 = new ListNode<Integer>(2);
    ListNode<Integer> node5 = new ListNode<Integer>(7);
    ListNode<Integer> node6 = new ListNode<Integer>(13);
    ListNode<Integer> node7 = new ListNode<Integer>(3);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    System.out.println(notify(node1, 2).val);
  }
}
