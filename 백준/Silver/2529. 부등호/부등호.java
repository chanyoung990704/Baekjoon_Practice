import java.io.*;
import java.util.*;

public class Main {

    static String max = "0000000000";
    static String min = "9999999999";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int k = Integer.valueOf(br.readLine());
        String[] input = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();

        findMax(0, input, new BitSet(), new StringBuilder());
        System.out.println(max);
        System.out.println(min);
    }

    private static void findMax(int n, String[] input, BitSet bitSet, StringBuilder sb) {
        // basecase
        if(n == input.length + 1) {
            if(max.compareTo(sb.toString()) < 0) {
                max = sb.toString();
            }
            if(min.compareTo(sb.toString()) > 0) {
                min = sb.toString();
            }
            return;
        }

        // 처음일경우 모든 경우 초기화
        if (n == 0) {
            for (int i = 0; i <= 9; i++) {
                bitSet.set(i);
                sb.append(i);
                findMax(n+1, input, bitSet, sb);
                sb.deleteCharAt((sb.length()-1));
                bitSet.clear(i);
            }
        }
        else{
            int prev = sb.charAt(sb.length()-1) - '0';
            //부등호 확인
            if(input[n-1].equals("<")){
                // prev보다 큰 거 찾기
                for (int i = prev; i <= 9; i++) {
                    if(!bitSet.get(i)){
                        bitSet.set(i);
                        sb.append(i);
                        findMax(n+1, input, bitSet, sb);
                        sb.deleteCharAt((sb.length()-1));
                        bitSet.clear(i);
                    }
                }
            }
            else{
                for(int i = prev ; i >= 0 ; i--){
                    if(!bitSet.get(i)){
                        bitSet.set(i);
                        sb.append(i);
                        findMax(n+1, input, bitSet, sb);
                        sb.deleteCharAt((sb.length()-1));
                        bitSet.clear(i);
                    }
                }
            }
        }


    }
}
