import java.util.stream.IntStream;

class Solution {
    public int solution(int i, int j, int k) {
        String[] arr = IntStream.rangeClosed(i, j)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        
        int cnt = 0;
        for(String cur : arr) {
            for(char ch : cur.toCharArray()) {
                if(Character.getNumericValue(ch) == k) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
