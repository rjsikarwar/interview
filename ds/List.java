public class List<T>{
  public  ListNode<T> reverseRecursive(ListNode<T> node){
    if(node == null){
      return null;
    }
    if(node.next == null){
      return node;
    }
    ListNode<T> second = node.next;
    node.next = null;
    ListNode<T> after = reverseRecursive(second);
    second.next = node;
    return after;
  }

  public ListNode<T> reverseIterative(ListNode<T> node){
    if(node == null){
      return null;
    }
    ListNode<T> prev = null;
    ListNode<T> curr = node;
    ListNode<T> next = null;
    while(curr != null){
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  private void print(ListNode<T> node){
    ListNode<T> tmp = node;
    while(tmp != null){
      System.out.println(tmp.value);
      tmp = tmp.next;
    }
  }

  public static void main(String[] args){
    ListNode<Integer> node = new ListNode<Integer>(1);
    node.next = new ListNode<Integer>(2);
    node.next.next = new ListNode<Integer>(3);
    List<Integer> list = new List<Integer>();
    ListNode<Integer> after = list.reverseRecursive(node);

    list.print(after); 

    ListNode<Integer> another = list.reverseIterative(after);
    list.print(another);
  }
  
}
