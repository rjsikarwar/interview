

public class WiredOrderPrint{
  public static void print(int[] array){
    int len = array.length;
    boolean smallThanLater = true;
    for(int i = 1; i < len; i++){
      if(smallThanLater){
        if(array[i - 1] > array[i]){
          change(array, i - 1, i);
        }
      }else{
        if(array[i - 1] < array[i]){
          change(array, i - 1, i);
        }
      }
      smallThanLater = smallThanLater ? false : true;
    }
    for(int i = 0; i < len; i++){
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }
  private static void change(int[] array, int x, int y){
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }
  public static void main(String[] args){
    int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    print(a);

    int[] b = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
    print(b);

    int[] c = new int[]{5, 2, 8, 4, 6, 2, 9, 3, 5};
    print(c);

    int[] d = new int[]{ 3, 6, 3, 1, 9, 6, 8, 2, 5, 6, 4, 2, 1};
    print(d);
  }
}
