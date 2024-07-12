class Solution {
    public int solution(String[] babbling) {
        String[] possibleSounds = {"aya", "ye", "woo", "ma"};
        int count = 0;
        
        for (String word : babbling) {
            if (canPronounce(word, possibleSounds)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean canPronounce(String word, String[] possibleSounds) {
        StringBuilder sb = new StringBuilder(word);
        String lastSound = "";
        
        while (sb.length() > 0) {
            boolean found = false;
            for (String sound : possibleSounds) {
                if (sb.indexOf(sound) == 0 && !sound.equals(lastSound)) {
                    sb.delete(0, sound.length());
                    lastSound = sound;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        
        return true;
    }
}