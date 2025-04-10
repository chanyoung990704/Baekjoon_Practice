import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        // DP
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i = 1 ; i <= str1.length() ; i++){
            for(int j = 1 ; j <= str2.length() ; j++){
                // 같은 경우
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        // LCS 출력
        System.out.println(dp[str1.length()][str2.length()]);
        
        // 최장 문자열 찾기
        StringBuilder sb = new StringBuilder();
        int i = str1.length();
        int j = str2.length();
        
        while(i > 0 && j > 0){
            // 같은 경우
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        
        System.out.println(sb.reverse().toString());
        
        br.close(); // 스트림 닫기
    }
}