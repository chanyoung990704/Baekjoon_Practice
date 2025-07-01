import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
            list.get(i).add(arr[i]);
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        int idx = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && list.get(i).size() < list.get(j).size() + 1) {
                    list.set(i, new ArrayList<>(list.get(j)));
                    list.get(i).add(arr[i]);
                    if(list.get(idx).size() < list.get(i).size()){
                        idx = i;
                    }
                }
            }
        }

        System.out.println(list.get(idx).size());
        System.out.println(list.get(idx).stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }
}
