package ctci.chapter08;

/**
* Write a method to generate the nth Fibonacci number
*/

public class Fibonacci{
  public static int fibonacci(int n){
    int[] result = new int[n];
    for(int i = 0; i < n; i++){
      if(i == 0 || i == 1){
        result[i] = 1;
      }else{
        result[i] = result[i - 1] + result[i - 2];
      }
    }
    return result[n - 1];
  }

  public static void main(String[] args){
    System.out.println(fibonacci(9));
  }
}