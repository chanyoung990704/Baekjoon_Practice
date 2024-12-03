import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        int arr1_len = arr1.length;
        int arr2_len = arr2.length;
        
        int firstVal = comparingArr(arr1_len, arr2_len);
        if(firstVal != 0) return firstVal;
        
        int arr1_sum = Arrays.stream(arr1).sum();    
        int arr2_sum = Arrays.stream(arr2).sum();

        return comparingArr(arr1_sum, arr2_sum);
    }
    
    int comparingArr(int arr1, int arr2){
        if(arr1 > arr2) return 1;
        else if(arr1 < arr2) return -1;
        return 0;
    }
}