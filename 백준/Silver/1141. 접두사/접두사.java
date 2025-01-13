import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            list.add(br.readLine());
        }

        list = list.stream().distinct().collect(Collectors.toList());
        
        int cnt = list.size();

        for(int i = 0 ; i < list.size() ; i++){
            String cur = list.get(i);
            for(int j = 0 ; j < list.size() ; j++){
                if(i == j){
                    continue;
                }
                String opposite = list.get(j);
                if(opposite.startsWith(cur)){
                    cnt--;
                    break;
                }
            }
        }

        System.out.println(cnt);
    } 
}
