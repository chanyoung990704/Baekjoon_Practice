import java.util.*;
import java.util.stream.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        
        Arrays.sort(A);
        Arrays.sort(B);
                
        int len = A.length;
        int ans = 0;

        for(int i = 0 ; i < len ; i++){
            ans += A[i] * B[len - i - 1];
        }


        
        return ans;
    }
}