/**
 * Triangle
 * By starting at the top of the triangle and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 27
 *       5
 *     9  6
 *   4   6  8
 * 0   7  1   5                     
 * resutl 5 + 9 + 6 + 7 = 27
 * Write a program in a language of your choice to find the maximum total from top to bottom
 *
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Triangle{
  private static int line = 100;
  private static int[][] triangle = new int[line][line];
  private static int[][] result = new int[line][line];
  private static void readFile(){
    BufferedReader br = null;
    String line;
    Scanner sc = null;
    try{
      br = new BufferedReader(new FileReader("triangle.txt"));
      int lineNo = 0;
      while((line = br.readLine()) != null){
        sc = new Scanner(line);
        int index = 0;
        while(sc.hasNextInt()){
          triangle[lineNo][index++] = sc.nextInt();
        }
        lineNo++;
      }
    }catch(IOException e){
      e.printStackTrace();
    }finally{
      try{
        if(br != null){
          br.close();
        }
      }catch(IOException ex){
        ex.printStackTrace();
      }
    }
  }
  
  private static int maxSum(){
    result[0][0] = triangle[0][0];
    int max = Integer.MIN_VALUE;
    for(int i = 1; i < line; i++){
      result[i][0] = result[i - 1][0] + triangle[i][0];
      for(int j = 1; j <= i; j++){
        result[i][j] = Math.max(result[i - 1][j - 1], result[i - 1][j]) + triangle[i][j];
        if(i == line - 1){
          max = Math.max(max, result[i][j]);
        }
      }
    }
    return max;
  }

  public static void main(String[] args){
    readFile();
    //System.out.println(Arrays.deepToString(triangle));
    System.out.println("___________________");
    int max = maxSum();
    System.out.println(max);
  }
}
