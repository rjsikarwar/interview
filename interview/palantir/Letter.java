import java.util.Random;
import java.util.Arrays;

public class Letter implements Comparable<Letter>{
  static Random random = new Random();
  int length;
  int width;
  public Letter(int l, int w){
    this.length = l;
    this.width = w;
  }

  // @Overwrite
  public int compareTo(Letter another){
    return this.length - another.length;
  }

  public static int maxLongestLetters(Letter[] letters){
    Arrays.sort(letters);
    int maxLength = 0;
    int len = letters.length;
    int[] dp = new int[len];
    for(int i = 0; i < len; i++){
      dp[i] = 1;
      for(int j = 0; j < i; j++){
        if(letters[i].width > letters[j].width){
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLength = Math.max(maxLength, dp[i]);
    }
    return maxLength;
  }


  public static void main(String[] args){
    Letter[] array = new Letter[8];
    for(int i = 0; i < 8; i++){
      array[i] = new Letter(random.nextInt(10), random.nextInt(10));
      System.out.println("[" + array[i].length + ", " + array[i].width + "]");
    }

    // System.out.println(Arrays.deepToString(array));
    System.out.println(maxLongestLetters(array));
  }
}
