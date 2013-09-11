package ctci.chapter14;

public class CircularArray<T>{
  private T[] items;
  private int head;

  public CircularArray(int size){
    this.items = new T[size];
    this.head = 0;
  }

  private int convert(int index){
    while(index < 0){
      index += items.length;
    }
    return (head + index) % items.length;
  }

  public void rotate(int leftIndex){
    head = convert(leftIndex);
  }

  public T get(int index){
    if(index < 0 || index >= items.length){
      throw new IndexOutOfBoundsException(index);
    }
    return items[convert(index)];
  }

  public void set(T item, int index){
    items[convert(index)] = item;
  }

  public int getHead(){
    return this.head;
  }

  public Iterator<T> iterator(){
    return new CircularArrayIterator<T>(this);
  }
}