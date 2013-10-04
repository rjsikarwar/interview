import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.BufferedReader;

/**
* Every day, Square merchants customize and use items to run their business. Items are anything a business sells:
* from haircuts to a cup of coffee. Using aggregated data, mechants can ask quesitons like 
* "what are my most popular items?"
* 
* The input is from STDIN and output to STDOUT. The first line of input is the number of total items purchased
* (required if you're writing in C or the like). Each line after that has the name of the item purchased
*
* For example, receiving
* 6
* coffee
* coffee
* coffee
* muffin
* muffin
* banana
* Your output should be:
* coffee
* muffin
* banana
*
* Return the top 3 items purchased. If there are ties, sort alphabeticallya and only return 3
*/

public class SquareTopItems {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        String[] input = new String[len];
        for(int i = 0; i < len; i++){
          input[i] = br.readLine();
        }
        List<List<String>> cashList = new ArrayList<List<String>>();
        for(int i = 0; i < len; i++){
          cashList.add(new ArrayList<String>());
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i= 0; i < len; i++){
          if(map.containsKey(input[i])){
            map.put(input[i], map.get(input[i]) + 1);
          }else{
            map.put(input[i], 1);
          }
        }

        for(String str:map.keySet()){
          int freq = map.get(str);
          cashList.get(freq).add(str);
        }

        int flag = 0;
        for(int i = cashList.size() - 1; i >= 0; i--){
          List<String> result = cashList.get(i);
          Collections.sort(result);
          for(int j = 0; j < result.size(); j++){
            if(flag >=3){
              return;
            }
            System.out.println(result.get(j) + " ");
            flag++;
          }

        }


    }
}