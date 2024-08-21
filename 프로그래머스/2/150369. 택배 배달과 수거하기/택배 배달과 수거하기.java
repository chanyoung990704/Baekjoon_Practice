import java.util.*;

class Solution {
    class Place {
        int idx;
        int cnt;
        Place(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
        int getIdx() {return idx;}
    }
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        PriorityQueue<Place> deliverPQ = new PriorityQueue<>(Comparator.comparing(Place::getIdx).reversed());
        PriorityQueue<Place> pickupPQ = new PriorityQueue<>(Comparator.comparing(Place::getIdx).reversed());
        
        for(int i = 0; i < n; i++) {
            if (deliveries[i] > 0) deliverPQ.offer(new Place(i + 1, deliveries[i]));
            if (pickups[i] > 0) pickupPQ.offer(new Place(i + 1, pickups[i]));
        }
        
        long result = 0;
        
        while(!deliverPQ.isEmpty() || !pickupPQ.isEmpty()) {
            int maxDistance = 0;
            int deliverCap = cap;
            int pickupCap = cap;
            
            while(!deliverPQ.isEmpty() && deliverCap > 0) {
                Place p = deliverPQ.poll();
                maxDistance = Math.max(maxDistance, p.idx);
                if(p.cnt > deliverCap) {
                    deliverPQ.offer(new Place(p.idx, p.cnt - deliverCap));
                    deliverCap = 0;
                } else {
                    deliverCap -= p.cnt;
                }
            }
            
            while(!pickupPQ.isEmpty() && pickupCap > 0) {
                Place p = pickupPQ.poll();
                maxDistance = Math.max(maxDistance, p.idx);
                if(p.cnt > pickupCap) {
                    pickupPQ.offer(new Place(p.idx, p.cnt - pickupCap));
                    pickupCap = 0;
                } else {
                    pickupCap -= p.cnt;
                }
            }
            
            if(maxDistance > 0) {
                result += 2L * maxDistance;
            }
        }
        
        return result;
    }
}