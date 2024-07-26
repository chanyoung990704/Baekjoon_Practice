import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 두 글자씩 끊어서 다중집합 만들기
        List<String> list1 = makeSet(str1);
        List<String> list2 = makeSet(str2);
        
        // 교집합과 합집합 계산
        int intersection = 0;
        int union = list1.size() + list2.size();
        
        for (String s : list1) {
            if (list2.remove(s)) {
                intersection++;
                union--;
            }
        }
        
        // 자카드 유사도 계산
        double jaccard = (union == 0) ? 1 : (double) intersection / union;
        
        return (int) (jaccard * 65536);
    }
    
    private List<String> makeSet(String str) {
        List<String> list = new ArrayList<>();
        str = str.toLowerCase();
        
        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);
            
            if (Character.isLetter(first) && Character.isLetter(second)) {
                list.add("" + first + second);
            }
        }
        
        return list;
    }
}