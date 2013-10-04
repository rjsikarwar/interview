import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.BufferedReader;

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