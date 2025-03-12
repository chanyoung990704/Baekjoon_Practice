import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] snowballs = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snowballs[i] = Long.parseLong(st.nextToken());
        }
        
        // 모든 가능한 눈사람(두 눈덩이의 조합)을 저장할 리스트
        List<Snowman> snowmen = new ArrayList<>();
        
        // 가능한 모든 눈사람 조합 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && snowballs[i] >= snowballs[j]) {
                    // 아래 눈덩이(i)가 위 눈덩이(j)보다 크거나 같은 경우만 유효
                    snowmen.add(new Snowman(i, j, snowballs[i] + snowballs[j]));
                }
            }
        }
        
        // 눈사람의 키 기준으로 정렬
        Collections.sort(snowmen, Comparator.comparingLong(s -> s.height));
        
        long minDiff = Long.MAX_VALUE;
        
        // 투 포인터 
        for (int i = 0; i < snowmen.size() - 1; i++) {
            for (int j = i + 1; j < snowmen.size(); j++) {
                Snowman s1 = snowmen.get(i);
                Snowman s2 = snowmen.get(j);
                
                // 두 눈사람이 서로 다른 눈덩이로 만들어졌는지 확인
                if (s1.bottom != s2.bottom && s1.bottom != s2.top && 
                    s1.top != s2.bottom && s1.top != s2.top) {
                    
                    // 키 차이 계산 및 최소값 갱신
                    long diff = s2.height - s1.height;
                    minDiff = Math.min(minDiff, diff);
                    
                    // 최소 차이를 찾았으면 더 이상 검사할 필요 없음
                    break;
                }
            }
        }
        
        System.out.println(minDiff);
    }
    
    // 눈사람 클래스: 아래 눈덩이 인덱스, 위 눈덩이 인덱스, 전체 키를 저장
    static class Snowman {
        int bottom, top;
        long height;
        
        Snowman(int bottom, int top, long height) {
            this.bottom = bottom;
            this.top = top;
            this.height = height;
        }
    }
}
