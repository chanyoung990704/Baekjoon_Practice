import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] nums;
    static int[] ret;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        ret = new int[N];
        Arrays.fill(ret, -1);

        // 스택
        Stack<int[]> stack = new Stack<>(); // 인덱스, 값

        // 전체 돌면서
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 스택에서 뺄 경우가 생긴다면 즉 현재 값이 큰 값이라면
            while (!stack.isEmpty() && stack.peek()[1] < num) {
                // pop하고 저장
                int[] del = stack.pop();
                ret[del[0]] = num;
            }
            stack.add(new int[]{i, num});
        }

        System.out.println(Arrays.stream(ret).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}