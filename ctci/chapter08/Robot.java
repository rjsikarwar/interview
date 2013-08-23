package ctci.chapter08;

/**
* Imagine a robot sitting on the upper left hand corner of an NxN grid
* The robot can only move in two directions: right and down 
* How many possible paths are there for the robot to move to the lower right corner?
*/
public class Robot{
  private static int n;
  public int easyPathCounter(){
    return easyPathCounter(0, 0);
  }

  public int easyPathCounter(int row, int col){
    int count = 0;
    if(row >= n - 1 && col >= n - 1){
      count = 0;
    }else if(row >= n - 1 || col >= n -1){
      count = 1;
    }else{
      count = easyPathCounter(row, col + 1) + easyPathCounter(row + 1, col);
    }
    return count;
  }

  public static void main(String[] args){
    n = 3;
    Robot r = new Robot();
    System.out.println(r.easyPathCounter());
  }
}