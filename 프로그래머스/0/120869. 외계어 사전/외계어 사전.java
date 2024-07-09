import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
        
        Arrays.sort(spell);
        String n_spell = String.join("", spell);
        
        for(var s : dic) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String n_dic = new String(chars);
            if(n_spell.equals(n_dic))
                return 1;
        }
        return 2;
    }
    
    
}