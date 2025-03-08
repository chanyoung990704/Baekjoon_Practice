import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        
        // A와 B 배열의 모든 원소 쌍의 합을 저장
        int[] AB = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx++] = A[i] + B[j];
            }
        }
        
        // C와 D 배열의 모든 원소 쌍의 합을 저장
        int[] CD = new int[n * n];
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                CD[idx++] = C[i] + D[j];
            }
        }
        
        // AB 배열 정렬
        Arrays.sort(AB);
        
        long count = 0;
        
        // CD 배열의 각 원소에 대해, 그 값의 음수가 AB 배열에 몇 개 있는지 찾음
        for (int i = 0; i < CD.length; i++) {
            // AB 배열에서 -CD[i]가 처음 나타나는 위치(lowerBound)
            int lowerBound = lowerBound(AB, -CD[i]);
            
            // AB 배열에서 -CD[i]가 마지막으로 나타나는 다음 위치(upperBound)
            int upperBound = upperBound(AB, -CD[i]);
            
            // -CD[i]의 개수는 upperBound - lowerBound
            count += (upperBound - lowerBound);
        }
        
        System.out.println(count);
    }
    
    // 이진 탐색으로 target이 처음으로 나타나는 위치를 찾는 메서드
    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    // 이진 탐색으로 target이 마지막으로 나타나는 다음 위치를 찾는 메서드
    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
