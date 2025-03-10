

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사진틀의 개수
        int R = Integer.parseInt(br.readLine()); // 총 추천 횟수

        int[] recommends = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 추천 순서

        Map<Integer, Candidate> candidates = new HashMap<>(); // 학생번호, 후보정보

        for(int i = 0; i < recommends.length; i++) {
            int studentId = recommends[i]; // 현재 추천받은 학생

            // 이미 사진이 게시된 학생인 경우
            if(candidates.containsKey(studentId)) {
                Candidate candidate = candidates.get(studentId);
                candidate.recommendCount++; // 추천 횟수만 증가
                continue;
            }

            // 사진틀에 여유가 있는 경우
            if(candidates.size() < N) {
                candidates.put(studentId, new Candidate(1, i)); // 새 후보 등록
                continue;
            }

            // 사진틀이 꽉 찬 경우, 제거할 후보 선정
            int minRecommendCount = Integer.MAX_VALUE;
            int oldestTime = Integer.MAX_VALUE;
            int removeId = -1;

            for(Map.Entry<Integer, Candidate> entry : candidates.entrySet()) {
                Candidate candidate = entry.getValue();
                
                // 추천 횟수가 가장 적은 후보 찾기
                if(candidate.recommendCount < minRecommendCount) {
                    minRecommendCount = candidate.recommendCount;
                    oldestTime = candidate.time;
                    removeId = entry.getKey();
                } 
                // 추천 횟수가 같다면 가장 오래된 후보 찾기
                else if(candidate.recommendCount == minRecommendCount && candidate.time < oldestTime) {
                    oldestTime = candidate.time;
                    removeId = entry.getKey();
                }
            }

            // 가장 적은 추천을 받은(또는 가장 오래된) 후보 제거
            candidates.remove(removeId);
            // 새 후보 등록
            candidates.put(studentId, new Candidate(1, i));
        }

        // 최종 후보들을 오름차순으로 정렬하여 출력
        List<Integer> result = new ArrayList<>(candidates.keySet());
        Collections.sort(result);
        
        StringBuilder sb = new StringBuilder();
        for(int id : result) {
            sb.append(id).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }

    // 후보 정보를 저장하는 클래스
    static class Candidate {
        int recommendCount; // 추천 횟수
        int time; // 사진이 게시된 시간(순서)

        public Candidate(int recommendCount, int time) {
            this.recommendCount = recommendCount;
            this.time = time;
        }
    }
}
