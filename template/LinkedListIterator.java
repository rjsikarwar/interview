package template;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T>{

  private LinkedList<T> list;
  private ListNode<T> cursor;

  public LinkedListIterator(LinkedList<T> list){
    this.list = list;
    cursor = list.getHead();
  }

  @Override
  public boolean hasNext(){
    return cursor != null;
  }

  @Override
  public T next(){
    if(!hasNext()){
      throw new NoSuchElementException();
    }else{
      T result = cursor.getValue();
      cursor = cursor.getNext();
      return result;
    }
  }

  @Override
  public void remove(){
    throw new UnsupportedOperationException();
  }

}