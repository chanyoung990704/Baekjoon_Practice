import java.util.stream.*;
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        return (int)IntStream.range(0, A.length)
            .map(i -> {
                return A[i] * B[B.length - 1 - i];
            })
            .sum();
    }
}