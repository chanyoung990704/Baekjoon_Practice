import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        int N = input[0];   int C = input[1];

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) list.add(Integer.valueOf(br.readLine()));

        list.sort(Comparator.naturalOrder());

        int lo = 1;
        int hi = list.get(N - 1) - list.get(0);
        int ret = -1;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(isPossible(list, mid, C)){
                ret = mid;
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }

        System.out.println(ret);
        br.close();
    }

    static boolean isPossible(List<Integer> list, int mid, int C){
        int cur = list.get(0);
        int cnt = 1;
        for(int i = 0 ; i < list.size() ; i++){
            int next = list.get(i);
            if(next >= cur + mid){
                cur = next;
                cnt++;
            }
        }
        if(cnt >= C) return true;
        
        return false;
    }

}