import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        // 넓이는 long으로
        int[] height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.valueOf(br.readLine());
        }

        long width = getWidth(height, 0, N - 1);
        System.out.println(width);
    }

    private static long getWidth(int[] height, int left, int right) {
        // 1칸인 경우
        if(left == right) {
            return height[left];
        }

        long ret = 0;
        int mid = left + (right - left) / 2;

        // 왼쪽 오른쪽 최대 넓이
        ret = Math.max(getWidth(height, left, mid), getWidth(height, mid + 1, right));

        // 중간 겹치는 부분 구하기
        int h = Math.min(height[mid], height[mid + 1]);
        ret = Math.max(ret, h * 2);

        int lo = mid;
        int hi = mid + 1;
        while (lo > left || hi < right) {
            // 왼쪽 높이가 더 높은 경우
            if (lo > left && ((hi == right) || (height[hi + 1] < height[lo - 1]))) {
                lo--;
                h = Math.min(h, height[lo]);
            } else {
                hi++;
                h = Math.min(h, height[hi]);
            }

            ret = Math.max(ret, (long) h * (hi - lo + 1));
        }

        return ret;
    }
}
