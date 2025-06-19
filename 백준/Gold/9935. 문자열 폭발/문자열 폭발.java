import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String p = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
            if (stack.size() >= p.length()) {
                boolean needPop = true;
                for(int i = 0 ; i < p.length() ; i++){
                    if(stack.get(stack.size() - p.length() + i) != p.charAt(i)){
                        needPop = false;
                        break;
                    }
                }
                if(needPop){
                    for(int i = 0 ; i < p.length() ; i++){
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println("FRULA");
        }else {
            StringBuilder sb = new StringBuilder();
            for(char c : stack){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
