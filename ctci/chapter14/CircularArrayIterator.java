package ctci.chapter14;

public class CircularArrayIterator<T> implements Iterator<T>{
  private CircularArray array;
  private int index;

  public CircularArrayIterator(CircularArray array){
    this.array = array;
    this.index = array.getHead();
  }

  @Override
  public boolean hasNext(){
    int indexBeforeHead = array.getHead() == 0 ? array.length - 1 : array.getHead() - 1;
    return index != indexBeforeHead;
  }

  @Override
  public T next(){
    if(hasNext){
      return array[index++];
    }else{
      return null;
    }
  }

  @Override
  public void remove(){
    throw new UnsupportedOperationException();
  }

}