package ctci.chapter09;

/**
* Implement the "paint fill" function that one might see on many image editing programs.
* That is , given a screen (represented by two-dimensional array of colors), a point,
* and a new color, fill in the surrounding area until the color changes form the original color
*/

public class PaintFill{
  public enum Color{
    BLACK, WHITE, RED, YELLOW, GREEN,;
  }

  public static boolean fillPaint(Color[][] image, int x, int y, Color newColor){
    if(x >= 0 && x < image[0].length && y >= 0 && y < image.length){
      return fillPaint(image, x, y, image[y][x], newColor);
    }else{
      return false;
    }
  }

  public static boolean fillPaint(Color[][] image, int x, int y, Color oldColor, Color newColor){
    if(x < 0 || x >= image[0].length || y < 0 || y >= image.length){
      return false;
    }
    if(image[y][x] == oldColor){
      image[y][x] = newColor;
      fillPaint(image, x - 1, y, oldColor, newColor);
      fillPaint(image, x + 1, y, oldColor, newColor);
      fillPaint(image, x, y - 1, oldColor, newColor);
      fillPaint(image, x, y + 1, oldColor, newColor);
    }
    return true;
  }
}