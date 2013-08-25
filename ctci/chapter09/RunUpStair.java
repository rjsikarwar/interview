package ctci.chapter09;

public class RunUpStair{
  // Bottom-Up
  public int waysToRunUp(int stairSteps){
    if(stairSteps < 0){
      throw new IllegalArgumentException();
    }

    int[] cache = new int[stairSteps + 1];
    for(int i = 0; i <= stairSteps; i++){
      if(i == 0){
        cache[i] = 1;
      }else if( i == 1){
        cache[i] = cache[0];
      }else if(i == 2){
        cache[i] = cache[0] + cache[1];
      }else{
        cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
      }
    }
    return cache[stairSteps];
  }

  // Top-down

  public int waysToRunUpTopDown(int stairSteps){
    int[] map = new int[stairSteps + 1];
    return waysToRunUpTopDown(stairSteps, map);
  }

  public int waysToRunUpTopDown(int stairSteps, int[] map){
    if(stairSteps < 0){
      return 0;
    }
    if(map[stairSteps] > 0){
      return map[stairSteps];
    }
    if(stairSteps == 0){
      map[stairSteps] = 1;
    }else{
      map[stairSteps] = waysToRunUpTopDown(stairSteps - 1, map) 
        + waysToRunUpTopDown(stairSteps - 2, map)
        + waysToRunUpTopDown(stairSteps - 3, map);
    }
    return map[stairSteps];
  }

  public static void main(String[] args){
    RunUpStair ru = new RunUpStair();
    int[] a = new int[1];
    System.out.println(a[0]);
    System.out.println(ru.waysToRunUpTopDown(0));
    System.out.println(ru.waysToRunUpTopDown(1));
    System.out.println(ru.waysToRunUpTopDown(2));
    System.out.println(ru.waysToRunUpTopDown(3));
    System.out.println(ru.waysToRunUpTopDown(4));
  }
}