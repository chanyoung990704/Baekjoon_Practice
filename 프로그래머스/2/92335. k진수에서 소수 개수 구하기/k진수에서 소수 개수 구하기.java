import java.util.*;
import java.math.BigInteger;

class Solution {
    public int solution(int n, int k) {
        // n진법으로 바꾸기
        String[] arr = convertN(n, k).split("0");
        
        int ret = 0;
        for(String cur : arr){
            if(!cur.equals("") && isPrime(cur)){
                ret++;
            }
        }
        
        return ret;
    }
    
    public boolean isPrime(String numStr) {
        if (numStr.isEmpty()) return false;
        BigInteger num;
        try {
            num = new BigInteger(numStr);
        } catch (NumberFormatException e) {
            return false;
        }
        if (num.compareTo(BigInteger.ONE) <= 0) return false;
        if (num.equals(BigInteger.TWO)) return true;
        if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO)) return false;
        
        BigInteger sqrt = num.sqrt();
        for (BigInteger i = BigInteger.valueOf(3); i.compareTo(sqrt) <= 0; i = i.add(BigInteger.TWO)) {
            if (num.mod(i).equals(BigInteger.ZERO)) return false;
        }
        return true;
    }
    
    public String convertN(int n, int k){
        String ret = "";
        while(n != 0){
            String cur = String.valueOf(n % k);
            ret = cur + ret;
            n /= k;
        }
        return ret;
    }
}