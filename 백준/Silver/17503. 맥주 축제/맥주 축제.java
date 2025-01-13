import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    static class Info{
        int v;
        int c;
        Info(int v, int c){
            this.v = v;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> NMK = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NMK.get(0);
        int M = NMK.get(1);
        int K = NMK.get(2);

        List<Info> list = new ArrayList<>();
        for(int i = 0 ; i < K ; i++){
            List<Integer> cur = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());
            list.add(new Info(cur.get(0), cur.get(1)));           
        }

        // N개를 선택할 수 없는 경우 체크
        if(K < N) {
            System.out.println(-1);
            return;
        }

        long lo = 0;
        long hi = Integer.MAX_VALUE;
        long ret = -1;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            int[] res = getResult(list, mid, N);
            int cnt = res[0];
            int val = res[1];
            
            if(cnt == N && val >= M){
                ret = mid;
                hi = mid -1;
            }else{
                lo = mid + 1;
            }
        }

        System.out.println(ret);
    }

    static int[] getResult(List<Info> list, long m, int N){
        // 도수 레벨이 m 이하인 맥주들을 선호도 내림차순으로 정렬
        List<Info> available = new ArrayList<>();
        for(Info l : list){
            if(l.c <= m){
                available.add(l);
            }
        }
        
        if(available.size() < N) return new int[]{0, 0};
        
        // 선호도 내림차순 정렬
        Collections.sort(available, (a, b) -> b.v - a.v);
        
        // 상위 N개의 선호도 합 계산
        int val = 0;
        for(int i = 0; i < N; i++){
            val += available.get(i).v;
        }

        return new int[]{N, val};
    }
}
