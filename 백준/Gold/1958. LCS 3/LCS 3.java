import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();
        
        // DP
        int[][][] dp = new int[str1.length()+1][str2.length()+1][str3.length()+1];
        for(int i = 1 ; i <= str1.length() ; i++){
            for(int j = 1 ; j <= str2.length() ; j++){
                for(int k = 1 ; k <= str3.length() ; k++){
                    // 같은 경우
                    if(str1.charAt(i-1) == str2.charAt(j-1) && str2.charAt(j-1) == 
                      str3.charAt(k-1)){
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    }
                    else{
                        dp[i][j][k] = Math.max(dp[i-1][j][k], 
                                              Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }
        
        // LCS 출력
        System.out.println(dp[str1.length()][str2.length()][str3.length()]);
                
        br.close(); // 스트림 닫기
    }
}