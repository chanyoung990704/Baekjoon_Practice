class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        boolean newWord = true;
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                newWord = true;
                result.append(c);
            } else if (newWord) {
                result.append(Character.toUpperCase(c));
                newWord = false;
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        
        return result.toString();
    }
}