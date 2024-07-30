import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parking = new HashMap<>(); // 차량 번호 - 입차 시간
        Map<String, Integer> parkingTime = new TreeMap<>(); // 누적 주차 시간
        
        // 입출차 기록 처리
        for (String record : records) {
            String[] cur = record.split(" ");
            int time = getMinute(cur[0]);
            String carNum = cur[1];
            String status = cur[2];
            
            if (status.equals("IN")) {
                parking.put(carNum, time);
            } else if (status.equals("OUT")) {
                int m = time - parking.get(carNum);
                parkingTime.put(carNum, parkingTime.getOrDefault(carNum, 0) + m);
                parking.remove(carNum);
            }
        }
        
        // 아직 출차되지 않은 차량 처리
        for (Map.Entry<String, Integer> entry : parking.entrySet()) {
            String carNum = entry.getKey();
            int m = getMinute("23:59") - entry.getValue();
            parkingTime.put(carNum, parkingTime.getOrDefault(carNum, 0) + m);
        }
        
        // 차량 번호가 작은 순서대로 요금 계산
        return parkingTime.entrySet()
            .stream()
            .mapToInt(entry -> getPrice(entry.getValue(), fees))
            .toArray();
    }
    
    // 시간을 분 단위로 변환
    int getMinute(String t) {
        String[] hm = t.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
    
    // 주차 요금 계산
    int getPrice(int m, int[] fees) {
        if (m <= fees[0]) {
            return fees[1];
        }
        int extraTime = m - fees[0];
        int extraCharges = (int) Math.ceil((double) extraTime / fees[2]) * fees[3];
        return fees[1] + extraCharges;
    }
}