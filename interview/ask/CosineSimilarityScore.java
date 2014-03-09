import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashMap;

/**
* This class simulates the process of Cosine Similarity Score of two queries
* Input file as parameters of the class, please run this program use:
* java CosineSimilarityScore file1 file2
* I assume the cosine similarity score calculated like the following:
* If there is multiple scores under one ID, just add them together;
* If there is ID1 in query1 but not in query2, use value 0 instead;
* Then calculate the score using Euclidean dot product formula listed in Wikipedia
*/
public class CosineSimilarityScore{
  private static class Query{
    public String name;
    public HashMap<String, Integer> scores;
    public Query(String n, HashMap<String, Integer> s){
      name = n;
      scores = s;
    }
  }
  
  private static Query query1;
  private static Query query2;

  private static String readFile(String inputName) throws IOException {
    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();
    try {
      String line;
      br = new BufferedReader(new FileReader(inputName));
      while((line = br.readLine()) != null){
        sb.append(line);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } finally {
      if (br != null) {
        br.close();
      }
    }
    return sb.toString();
  }

  private static Query parseString(String str){
    String[] temp = str.split("\\t");
    String name = temp[0];
    String other = temp[1];
    String[] values = other.split(",");
    int num = Integer.parseInt(values[0]);
    HashMap<String, Integer> scores = new HashMap<String, Integer>();
    for(int i = 0; i < num; i++){
      String key = values[2 * i + 1];
      int score = Integer.parseInt(values[2 * i + 2]);
      if(scores.containsKey(key)){
        scores.put(key, scores.get(key) + score);
      }else{
        scores.put(key, score);
      }
    }
    return new Query(name, scores);
  }

  private static double calCosine(){
    int dotMul = 0;
    int a = 0;
    int b = 0;
    for(String k : query1.scores.keySet()){
      if(query2.scores.containsKey(k)){
        dotMul += query1.scores.get(k) * query2.scores.get(k);
        a += query1.scores.get(k) * query1.scores.get(k);
        b += query2.scores.get(k) * query2.scores.get(k);
        query2.scores.remove(k);
      }else{
        a += query1.scores.get(k) * query1.scores.get(k);
      }
      
    }
    for(String k: query2.scores.keySet()){
      b += query2.scores.get(k) * query2.scores.get(k);
    }
    double ret = (double)dotMul / (Math.sqrt(a) * Math.sqrt(b));
    // System.out.println(ret);
    return ret;
  }

  public static void main(String[] args) throws IOException{
    String str1 = readFile(args[0]);
    String str2 = readFile(args[1]);
    query1 = parseString(str1);
    query2 = parseString(str2);
    double cosine = calCosine();
    System.out.println(query1.name + "\t" + query2.name + "\t" + cosine);
  }

}