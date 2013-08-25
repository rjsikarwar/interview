package ctci.chapter08.4thedition;

/**
* Write a method to generate the nth Fibonacci number
* Both Recursive and Iterative way used
*/

public class Fibonacci{

  // Recursive
  public static int fibonacciRecursive(int n){
    if(n < 0){
      throw new IllegalArgumentException("Argument cannot be negative: " + n);
    }
    if(n == 0){
      return 0;
    }
    if(n == 1){
      return 1;
    }
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
  } 

  // First Attempt: This method has a bug, will outOfIndex if n = 0;
  public static int fibonacciIterative_old(int n){
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

  // THis method is not an effient, since 
  //we do not need to use array to save all the data
  public static int fibonacciIterative_again(int n){
    if(n < 0){
      throw new IllegalArgumentException("Argument cannot be negative: " + n);
    }

    if(n == 0){
      return 0;
    }
    int[] resultSet = new int[n];
    for(int i = 0; i < n; i++){
      if(i == 0 || i == 1){
        resultSet[i] = 1;
      }else{
        resultSet[i] = resultSet[i - 1] + resultSet[i - 2];
      }
    }
    return resultSet[n - 1];
  }

  // Iterative
  public static int fibonacciIterative(int n){
    if(n < 0){
      throw new IllegalArgumentException("Argument cannot be negative: " + n);
    }

    if(n == 0){
      return 0;
    }
    
    int a = 1, b = 1;
    int c = 0;
    for(int i = 3; i <=n; i++){
      c = a + b;
      a = b;
      b = c;
    }
    return b;

  }

  public static void main(String[] args){
    System.out.println(fibonacciRecursive(0));
    //System.out.println(fibonacciIterative_old(0));
    System.out.println(fibonacciIterative_again(0));
    System.out.println(fibonacciIterative(0));
  }
}