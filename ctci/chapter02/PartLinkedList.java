package ctci.chapter02;

import java.util.Iterator;
import template.LinkedList;
import template.ListNode;


/**
* Write code to partition a linkedlist around a value x,
* such that all nodes less than x come before all nodes greater than or equal to x
*/
public class PartLinkedList{
  // my own implementation, every time the value is less than the target, new a linked node
  // and set it as the head of the list. This implement have a overhead for memory use because
  // every time the value is less than target it need to locate memory for the new nood
  public static LinkedList<Integer> partLinkedList(LinkedList<Integer> list, int value){
    ListNode<Integer> before = list.getHead();
    if(before == null){
      return null;
    }
    ListNode<Integer> cursor = before.getNext();
    while(cursor!= null){
      ListNode<Integer> next = cursor.getNext();
      if(cursor.getValue() < value){
        ListNode<Integer> tmpNode = new ListNode<Integer>(cursor.getValue());
        before.setNext(cursor.getNext());
        tmpNode.setNext(list.getHead());
        list.setHead(tmpNode); 
      }else{
        before = cursor;
      }
      cursor = next;
    }
    return list;
  }

  // implementation of the ctci book, using two list to represent the smaller and larger value
  // and then merge them together
  public static ListNode<Integer> part(ListNode<Integer> node, int value){
    ListNode<Integer> before = null;
    ListNode<Integer> after = null;
    while(node != null){
      ListNode<Integer> next = node.getNext();
      if(node.getValue() < value){
        node.setNext(before);
        before = node;
      }else{
        node.setNext(after);
        after = node;
      }
      node = next;
    }

    if(before == null){
      return after;
    }else{
      ListNode<Integer> head = before;
      while(before.getNext() != null){
        before = before.getNext();
      }
      before.setNext(after);
      return head;
    }
  }

  public static void main(String[] args){
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(5);
    list.add(2);
    list.add(3);
    list.add(9);
    list.add(1);
    list.add(8);
    list.add(4);
    list.add(10);

    Iterator<Integer> it = list.iterator();

    while(it.hasNext()){
      System.out.println(it.next());
    }

    System.out.println("Own Implementation:");
    LinkedList<Integer> newList = partLinkedList(list, 5);
    it = newList.iterator();
    while(it.hasNext()){
      System.out.println(it.next());
    }

    System.out.println("Another Implementation:");
    ListNode<Integer> head = part(list.getHead(), 5);
    while(head != null){
      System.out.println(head.getValue());
      head = head.getNext();
    }

  }
}