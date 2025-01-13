import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        String input = br.readLine();
        int redCnt = 0;
        int blueCnt = 0;

        for (char c : input.toCharArray()) {
            if (c == 'R') {
                redCnt++;
            }
            if (c == 'B') {
                blueCnt++;
            }
        }

        int min = Integer.MAX_VALUE;
        int r = 0;
        int b = 0;
        int idx;

        // RED RIGHT
        idx = N - 1;
        while (idx >= 0 && input.charAt(idx) == 'R') { // idx >= 0 체크 추가
            idx--;
            r++;
        }
        min = Math.min(min, redCnt - r);

        // RED LEFT
        idx = 0;
        r = 0;
        while (idx < N && input.charAt(idx) == 'R') { // idx < N 체크 추가
            idx++;
            r++;            
        }
        min = Math.min(min, redCnt - r);

        // BLUE RIGHT
        idx = N - 1;
        while (idx >= 0 && input.charAt(idx) == 'B') { // idx >= 0 체크 추가
            idx--;
            b++;
        }
        min = Math.min(min, blueCnt - b);

        // BLUE LEFT
        idx = 0;
        b = 0;
        while (idx < N && input.charAt(idx) == 'B') { // idx < N 체크 추가
            idx++;
            b++;
        }

        min = Math.min(min, blueCnt - b);
      
        System.out.println(min);
    } 
}
