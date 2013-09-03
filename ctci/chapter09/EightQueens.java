package ctci.chapter09;

import java.util.ArrayList;
import java.util.Arrays;

/**
* Write an algorithm to print all ways of arranging eight queens 
* on a 8, * chess board
*/
public class EightQueens{
  private static final int GRID_SIZE = 8;
  
  public static void placeQueens(int row, Integer[] colums, ArrayList<Integer[]> results){
    if(row == GRID_SIZE){
      results.add(colums.clone());
    }else{
      for(int colum = 0; colum < GRID_SIZE; colum++){
        if(isValid(colum, row, colums)){
          colums[row] = colum;
          placeQueens(row + 1, colums, results);
        }
      }
    }
  }

  public static boolean isValid(int colum, int row, Integer[] colums){
    for(int i = 0; i < row; i++){
      if(colums[i] == colum){
        return false;
      }
      int columDiff = Math.abs(colums[i] - colum);
      int rowDiff = Math.abs(i - row);
      if(columDiff == rowDiff){
        return false;
      }
    }
    return true;
  }
  public static ArrayList<Integer[]> getEightQueensPosition(){
    ArrayList<Integer[]> results = new ArrayList<Integer[]>();
    Integer[] test = new Integer[GRID_SIZE];
    System.out.println("TEST" + test[0]);
    placeQueens(0, test, results);
    return results;
  }
  public static void main(String[] args){
    ArrayList<Integer[]> results = getEightQueensPosition();
    int count = 0;
    for(Integer[] result:results){
      System.out.println(Arrays.toString(result));
      count++;
    }
    System.out.println(count);
    
  }
}