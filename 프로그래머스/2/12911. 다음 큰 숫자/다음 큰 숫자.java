class Solution {
    public int solution(int n) {
        int countOnes = Integer.bitCount(n); // n의 1의 개수
        
        int nextNumber = n + 1;
        while (Integer.bitCount(nextNumber) != countOnes) {
            nextNumber++;
        }
        
        return nextNumber;
    }
}