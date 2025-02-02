import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());
        
        // 동전의 단위 (센트)
        int[] coins = {25, 10, 5, 1};  // Quarter, Dime, Nickel, Penny
        
        while(T-- > 0) {
            int C = Integer.parseInt(br.readLine());  // 거스름돈 금액 (센트)
            
            // 각 동전 단위별로 필요한 개수 계산
            for(int coin : coins) {
                sb.append(C / coin).append(" ");  // 필요한 동전 개수
                C %= coin;  // 남은 금액 계산
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
