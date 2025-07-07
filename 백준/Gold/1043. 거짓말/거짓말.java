import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];

        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 진실을 아는 사람
        Set<Integer> trueSet = IntStream.range(1, arr1.length).map(i -> arr1[i]).boxed().collect(Collectors.toSet());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(Arrays.copyOfRange(tmp, 1, tmp.length));
        }

        if(M == 0){
            System.out.println(M);
            return;
        }

        Set<Integer> groupSet = new HashSet<>();

        while (true){
            boolean flag = false;
            int listIndex = 0;

            for(int[] arr : list){
                boolean check = false;
                for(int n : arr) {
                    if(trueSet.contains(n)){
                        check = true;
                        groupSet.add(listIndex++);
                        break;
                    }
                }
                if(check){
                    for(int n : arr){
                        if(!trueSet.contains(n)){
                            trueSet.add(n);
                            flag = true;
                        }
                    }
                }
            }

            if(!flag){
                break;
            }
        }

        System.out.println(M - groupSet.size());

    }
}
