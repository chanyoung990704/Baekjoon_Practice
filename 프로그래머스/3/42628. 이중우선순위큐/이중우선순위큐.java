import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int num = Integer.parseInt(parts[1]);
            
            if (command.equals("I")) {
                maxHeap.offer(num);
                minHeap.offer(num);
            } else if (!maxHeap.isEmpty()) {
                if (num == 1) {
                    minHeap.remove(maxHeap.poll());
                } else {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        if (maxHeap.isEmpty()) return new int[]{0, 0};
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}