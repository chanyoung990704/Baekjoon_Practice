import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> outDegree = new ArrayList<>();
        int[] inDegree = new int[N+1];
        int[] value =  new int[N+1];

        for (int i = 0; i <= N; i++) {
            outDegree.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0 ; j < input.length - 1 ; j++) {
                if(j == 0){
                    value[i+1] = input[j];
                    continue;
                }
                inDegree[i+1]++;
                outDegree.get(input[j]).add(i+1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N+1];

        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0){
                q.offer(i);
                result[i] = value[i];
            }
        }

        while (!q.isEmpty()){
            int cur = q.poll();
            for(int next :  outDegree.get(cur)){
                inDegree[next]--;
                result[next] = Math.max(result[next], value[next] + result[cur]);
                if(inDegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
