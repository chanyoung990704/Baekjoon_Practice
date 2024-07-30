import java.util.*;
import java.util.stream.*;

class Solution {
    
    class File {
        String head;
        String number;
        String tail;
        int idx;
        
        File(String h, String n, String t, int i) {
            head = h;
            number = n;
            tail = t;
            idx = i;
        }
        
        String getHead() {
            return head.toLowerCase();
        }
        int getNumber() {
            return Integer.valueOf(number); 
        }
        int getIdx() {
            return idx;
        }
        
        String getFull() {
            return head + number + tail;
        }
    }
    
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for(int i = 0; i < files.length; i++) {
            File file = createFile(files[i], i);
            list.add(file);
        }
        
        return list.stream()
            .sorted(Comparator.comparing(File::getHead)
                   .thenComparing(Comparator.comparing(File::getNumber))
                   .thenComparing(Comparator.comparing(File::getIdx)))
            .map(File::getFull)
            .toArray(String[]::new);
    }
    
    public File createFile(String s, int i) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        
        int idx = 0;
        // HEAD
        while (idx < s.length() && !Character.isDigit(s.charAt(idx))) {
            head.append(s.charAt(idx++));
        }
        
        // NUMBER
        while (idx < s.length() && Character.isDigit(s.charAt(idx)) && number.length() < 5) {
            number.append(s.charAt(idx++));
        }
        
        // TAIL
        while (idx < s.length()) {
            tail.append(s.charAt(idx++));
        }
        
        return new File(head.toString(), number.toString(), tail.toString(), i);
    }
}