import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class SquareGoodNode {

  public static void main(String[] args) throws Exception{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Node> nodeList = new ArrayList<Node>();
        int totalNumber = Integer.parseInt(br.readLine());
        for(int i=0; i<totalNumber; i++){
          nodeList.add(new Node());
        }
        for(int i=0; i<totalNumber; i++){
          nodeList.get(i).next = nodeList.get(Integer.parseInt(br.readLine())-1);
        }
      System.out.println(minChangeToGood(nodeList));
  }
  public static int minChangeToGood(ArrayList<Node> list){
    HashSet<Node> set = new HashSet<Node>();
    Node node1 = list.get(0);
    int count = 0;
    for(int i=0; i<list.size(); i++){
      Node node = list.get(i);
      if(set.contains(node)){
        continue;
      }else{
        HashSet<Node> subset = new HashSet<Node>();
        while(!subset.contains(node)){
          subset.add(node);
          node = node.next;
        }
        if(!subset.contains(node1)) count++;
        set.addAll(subset);
      }
    }
    return count;
  }
}
