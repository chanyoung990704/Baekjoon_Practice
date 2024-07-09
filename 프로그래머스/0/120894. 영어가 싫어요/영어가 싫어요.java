class Solution {
    public long solution(String numbers) {
        
    String[] alphabets = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0 ; i < alphabets.length ; i++)
            numbers = numbers.replaceAll(alphabets[i], String.valueOf(i));
        
        
        return Long.valueOf(numbers);
            
    }
}