import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();
        
        // Count occurrences of digits in X and Y
        for (char c : X.toCharArray()) {
            xMap.put(c, xMap.getOrDefault(c, 0) + 1);
        }
        for (char c : Y.toCharArray()) {
            yMap.put(c, yMap.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder result = new StringBuilder();
        
        // Find common digits and create the largest number
        for (char digit = '9'; digit >= '0'; digit--) {
            int commonCount = Math.min(xMap.getOrDefault(digit, 0), yMap.getOrDefault(digit, 0));
            result.append(String.valueOf(digit).repeat(commonCount));
        }
        
        if (result.length() == 0) {
            return "-1";
        }
        
        if (result.charAt(0) == '0') {
            return "0";
        }
        
        return result.toString();
    }
}