package edu.nyu.zhaohui.amazon;

public class Point implements Comparable<Point>{
  private double x;
  private double y;
  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }
  public double getX() {
    return x;
  }
  public void setX(double x) {
    this.x = x;
  }
  public double getY() {
    return y;
  }
  public void setY(double y) {
    this.y = y;
  }
  
  /**
   * implement compareTo method
   * if nearer to original, value is larger
   */
  @Override
  public int compareTo(Point that) {
    double discSquare = x * x + y * y;
    double discSquareThat = that.getX() * that.getX() + that.getY() * that.getY();
    return Double.valueOf(discSquareThat).compareTo(discSquare);
  }
  
  @Override
  public String toString() {
    return "Point [x=" + x + ", y=" + y + "]";
  }
}
