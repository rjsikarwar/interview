package template;

import java.util.Iterator;

public class LinkedList<T>{
  private ListNode<T> head;

  public LinkedList(){
    this.head = null;
  }

  public boolean add(T item){
    ListNode<T> newNode = new ListNode<T>(item);
    if(this.head == null){
      this.head = newNode;
    }else{
      ListNode<T> currNode = this.head;
      while(currNode.getNext() != null){
        currNode = currNode.getNext();
      }
      currNode.setNext(newNode);
    }
    return true;
  }

  public T remove(){
    if(head == null){
      return null;
    }else{
      T result = head.getValue();
      head = head.getNext();
      return result;
    }
  }

  public ListNode<T> getHead(){
    return this.head;
  }

  public Iterator<T> iterator(){
    return new LinkedListIterator<T>(this);
  }

  public static void main(String[] args){
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    Iterator<Integer> it = list.iterator();

    while(it.hasNext()){
      System.out.println(it.next());
    }
  }

}