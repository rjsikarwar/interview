package edu.nyu.zhaohui.amazon;

public class StudentResult {
  int studentId;
  String data;
  int testScore;
  
  public StudentResult(int id, String data, int score){
    this.studentId = id;
    this.data = data;
    this.testScore = score;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public int getTestScore() {
    return testScore;
  }

  public void setTestScore(int testScore) {
    this.testScore = testScore;
  }
  
  
}
