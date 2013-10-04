import java.io.*;
/*Babai is standing in the top left cell (1,1) of an N*M table. The table has N rows and M columns. Initially he is facing its right cell. He moves in the table in the following manner:

He moves one step forward
He turns to its right
If moving forward makes him exit the boundaries of the table, or causes him to reach a visited cell, he turns to its right.
He moves around the table and visits as many cells as he can. Your task is to find out the number of cells that he visits before he stops.

Here's a sample of Babai's steps on a 9x9 grid. The value at each cell denotes the step number.

1  2 55 54 51 50 47 46 45 
4  3 56 53 52 49 48 43 44 
5  6 57 58 79 78 77 42 41 
8  7 60 59 80 75 76 39 40 
9 10 61 62 81 74 73 38 37 
12 11 64 63 68 69 72 35 36 
13 14 65 66 67 70 71 34 33 
16 15 20 21 24 25 28 29 32 
17 18 19 22 23 26 27 30 31 
 
Input:
The input contains two integers N and M separated by a line. N and M are between 1 and 100.

Output:
Print a single integer which is the answer to the test-case

Sample input #00:
3
3

Sample output #00:
9

Sample input #01:
7
4

Sample output #01:
18
*/
public class SquareVisitedCells{
  public static int steps(int n, int m){
    if(m == 0 || n == 0){
      return 0;
    }
    if(m == 1 && n == 1){
      return 1;
    }

    if(n % 2 == 1){
      return 2 * n + steps(m - 2, n);
    }else{
      return 2 * n;
    }
  }
  public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    System.out.println(steps(n, m));

  }

}