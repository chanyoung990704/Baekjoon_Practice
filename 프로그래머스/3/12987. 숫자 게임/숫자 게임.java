import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        // A와 B를 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int count = 0;
        int bIndex = B.length - 1;
        
        // A의 끝에서부터 순회
        for (int i = A.length - 1; i >= 0; i--) {
            // B의 현재 원소가 A의 현재 원소보다 크면 매칭
            if (B[bIndex] > A[i]) {
                count++;
                bIndex--;
            }

        }
        
        return count;
    }
}