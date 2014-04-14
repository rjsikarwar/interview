
import java.util.Random;

public class ShortestPath{
  boolean[][] matrix;
  Random random;
  public ShortestPath(int len, int wid){
    this.matrix = new boolean[len][wid];
    this.random = new Random();
  }

  public void generateMatrix(){
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[0].length; j++){
        int rand = random.nextInt(5);
        if(rand > 0){
          matrix[i][j] = true;
        }else{
          matrix[i][j] = false;
        }
      }
    }
  }

  /**
   * This solution suppose can only move left or down
   */ 
  public int shortestPath(int x, int y){
    if(x >= matrix[0].length || x >= matrix.length){
      throw new IllegalArgumentException();
    }

    int[][] dp = new int[y][x];
    for(int i = 0; i < y; i++){
      for(int j = 0; j < x; j++){
        if(!matrix[i][j]){
          dp[i][j] = 0;
          continue;
        }
        if(i == 0 && j == 0){
          dp[i][j] = 0;
        }else if(i == 0){
          dp[i][j] = matrix[i][j - 1] ? dp[i][j - 1] + 1 : 0;
        }else if(j == 0){
          dp[i][j] = matrix[i - 1][j] ? dp[i - 1][j] + 1 : 0;
        }else{
          int temp = Integer.MAX_VALUE;
          if(matrix[i - 1][j]){
            temp = Math.min(temp, dp[i - 1][j]);
          }
          if(matrix[i][j - 1]){
            temp = Math.min(temp, dp[i][j - 1]);
          }
          if(temp == 0){
            dp[i][j] = 0;
          }else{
            dp[i][j] = temp + 1;
          }
        }
      }
    }
    return dp[y - 1][x - 1];
  }

  public static void main(String[] args){
    ShortestPath sp = new ShortestPath(5, 6);
    sp.generateMatrix();
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 6; j++){
        System.out.print(sp.matrix[i][j] +  " ");
      }
      System.out.println();
    }

    System.out.println("Path to 3, 3 = " + sp.shortestPath(3, 3));
  }
}
