/**
 * Given a class of Box, which has attribute color which specifies the color 
 * of the box, including red (0), white (1), black (2); Given an array of
 * box and sort the boxes by all red boxes first, then white, then black
 */
public class SortBox{
  private class Box{
    int color;
    public Box(int c){
      this.color = c;
    }
  }

  public void sort(Box[] boxes){
    if(boxes == null || 0 == boxes.length){
      return;
    }
    int[] count = new int[3];
    for(int i = 0; i < boxes.length; i++){
      count[boxes[i].color]++;
    }
    count[1] += count[0];
    count[2] += count[1];
    
    Box[] newBoxes = new Box[boxes.length];
    for(int i = 0; i < boxes.length; i++){
      newBoxes[count[boxes[i].color]--] = boxes[i];
    }
    boxes = newBoxes;
  }
}
