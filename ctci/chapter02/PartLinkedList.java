package ctci.chapter02;

import java.util.Iterator;
import template.LinkedList;
import template.ListNode;

public class PartLinkedList{
  public static LinkedList<Integer> partLinkedList(LinkedList<Integer> list, int value){
    ListNode<Integer> slowCursor = list.getHead();
    ListNode<Integer> quickCursor = list.getHead();
    if(quickCursor == null){
      return null;
    }
    while(quickCursor.getNext() != null){
      if(quickCursor.getNext().getValue() < value){
        ListNode<Integer> tmpNode = new ListNode<Integer>(quickCursor.getNext().getValue());
        quickCursor.setNext(quickCursor.getNext().getNext());
        tmpNode.setNext(list.getHead());
        list.setHead(tmpNode); 
      }
      quickCursor = quickCursor.getNext();
    }
    return list;
  }

  public static void main(String[] args){
    LinkedList<Integer> list = new LinkedList<Integer>();
    //list.add(5);
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

    LinkedList<Integer> newList = partLinkedList(list, 5);
    it = newList.iterator();
    while(it.hasNext()){
      System.out.println(it.next());
    }

  }
}