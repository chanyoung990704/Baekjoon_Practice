import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String letter) {
        Map<String, String> morseCode = new HashMap<>();
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        for(int i = 0 ; i < alphabet.length() ; i++)
            morseCode.put(morse[i], String.valueOf(alphabet.charAt(i)));
        
        
        return Arrays.stream(letter.split(" "))
            .map(i -> morseCode.get(i))
            .collect(Collectors.joining());
        

    }
}