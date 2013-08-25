package ctci.chapter09;

public class RunUpStair{
  public int waysToRunUp(int stairSteps){
    if(stairSteps < 0){
      throw new IllegalArgumentException();
    }
    if(stairSteps == 0){
      return 0;
    }

    int[] cache = new int[stairSteps];
    for(int i = 0; i < stairSteps; i++){
      if(i == 0){
        cache[i] = 1;
      }else if( i == 1){
        cache[i] = 1 + cache[0];
      }else if(i == 2){
        cache[i] = cache[0] + cache[1] + 1;
      }else{
        cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
      }
    }
    return cache[stairSteps - 1];
  }

  public static void main(String[] args){
    RunUpStair ru = new RunUpStair();
    System.out.println(ru.waysToRunUp(0));
    System.out.println(ru.waysToRunUp(1));
    System.out.println(ru.waysToRunUp(2));
    System.out.println(ru.waysToRunUp(3));
    System.out.println(ru.waysToRunUp(4));
  }
}