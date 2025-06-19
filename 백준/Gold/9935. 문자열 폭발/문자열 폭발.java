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
            
            // 스택 크기가 패턴 길이보다 크거나 같을 때만 확인
            if (stack.size() >= p.length()) {
                boolean needPop = true;  // ← 조건문 안으로 이동
                
                for(int i = 0 ; i < p.length() ; i++){
                    if(stack.get(stack.size() - p.length() + i) != p.charAt(i)){
                        needPop = false;
                        break;  // ← 조기 종료로 성능 개선
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
        } else {
            StringBuilder result = new StringBuilder();
            for(char ch : stack) {
                result.append(ch);
            }
            System.out.println(result.toString());
        }
    }
}
