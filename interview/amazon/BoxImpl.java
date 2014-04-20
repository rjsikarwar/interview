
import java.util.Queue;
import java.util.LinkedList;
/**
 * 数据结构设计题，给你一个黑匣子，匣子里面有很多sorted的数，支持get()和next()函数，类似于pop()跟peek()的区别，
 * 都是取得最小数，不过一个删数一个不删数，叫你设计一个数据结构，除了这两个函数之外还要支持add(int)这个函数，你不能对黑匣子进行修改
 */ 
public class BoxImpl implements Box{

  private Box box;
  private int temp;
  private boolean isTempNull;
  public BoxImpl(Box box){
    this.box = box;
    this.temp = 0;
    this.isTempNull = true;
  }

  @Override
  public int get(){
    if(isTempNull){
      return box.get();
    }else{
      int curr = box.get();
      if(curr > temp){
        return temp;
      }else{
        return curr;
      }
    }
  }

  @Override
  public int next(){
    if(isTempNull){
      return box.next();
    }else{
      int curr = box.get();
      if(curr > temp){
        int ret = temp;
        temp = 0;
        isTempNull = true;
        return ret;
      }else{
        return box.next();
      }
    }
  }

  void add(int x){
    if(isTempNull){
      isTempNull = false;
      temp = box.next() + temp + x;
    }else{
      temp += x;
    }
  }

  public static void main(String[] args){
    final Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    queue.add(5);
    queue.add(7);
    Box box = new Box(){
      public int get(){
        return queue.peek();
      }
      public int next(){
        return queue.poll();
      }
    };
    BoxImpl addBox = new BoxImpl(box);
    System.out.println(addBox.get());
    System.out.println(addBox.next());
    addBox.add(4);
    System.out.println(addBox.next());
    System.out.println(addBox.next());
    System.out.println(addBox.next());
    System.out.println(addBox.next());
    System.out.println(addBox.next());
  }
}