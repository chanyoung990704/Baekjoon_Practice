import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        
        List<Integer> rck = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());

        int r = rck.get(0);
        int c = rck.get(1);
        int k = rck.get(2);

        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arr.add(
                Arrays.stream(br.readLine().split(" "))
                    .map(Integer::valueOf).collect(Collectors.toList())
            );
        }

        int time = 0;
        while (time <= 100) {
            // 배열 범위 확인 후 값 비교
            if (r - 1 < arr.size() && c - 1 < arr.get(0).size() && arr.get(r - 1).get(c - 1) == k) {
                System.out.println(time);
                return;
            }

            int row = arr.size();
            int col = arr.get(0).size();

            // R연산
            if (row >= col) {
                int maxLen = 0;
                for (int i = 0; i < row; i++) {
                    List<Integer> curRow = arr.get(i);
                    int[] cnt = new int[101]; // 숫자 카운트 배열
                    for (int n : curRow) {
                        if (n > 0) cnt[n]++; // 0은 카운트하지 않음
                    }

                    // 숫자와 빈도를 정렬
                    curRow = curRow.stream()
                        .filter(cur -> cur > 0)
                        .distinct()
                        .sorted(Comparator.comparing((Integer cur) -> cnt[cur]).thenComparing(cur -> cur))
                        .collect(Collectors.toList());

                    List<Integer> newRow = new ArrayList<>();
                    for (int n : curRow) {
                        newRow.add(n);
                        newRow.add(cnt[n]);
                    }
                    arr.set(i, newRow);
                    maxLen = Math.max(maxLen, newRow.size());
                }

                // 각 행의 길이를 맞추기 위해 0 추가
                for (int i = 0; i < row; i++) {
                    List<Integer> curRow = arr.get(i);
                    while (curRow.size() < maxLen) {
                        curRow.add(0);
                    }
                }
            } 
            // C연산
            else {
                int maxLen = 0;
                List<List<Integer>> cols = new ArrayList<>();
                for (int i = 0; i < col; i++) {
                    List<Integer> curCol = new ArrayList<>();
                    for (int j = 0; j < row; j++) {
                        curCol.add(arr.get(j).get(i));
                    }

                    int[] cnt = new int[101]; // 숫자 카운트 배열
                    for (int n : curCol) {
                        if (n > 0) cnt[n]++;
                    }

                    // 숫자와 빈도를 정렬
                    curCol = curCol.stream()
                        .filter(cur -> cur > 0)
                        .distinct()
                        .sorted(Comparator.comparing((Integer cur) -> cnt[cur]).thenComparing(cur -> cur))
                        .collect(Collectors.toList());

                    List<Integer> newCol = new ArrayList<>();
                    for (int n : curCol) {
                        newCol.add(n);
                        newCol.add(cnt[n]);
                    }
                    cols.add(newCol);
                    maxLen = Math.max(maxLen, newCol.size());
                }

                // 각 열의 길이를 맞추기 위해 0 추가
                for (List<Integer> colList : cols) {
                    while (colList.size() < maxLen) {
                        colList.add(0);
                    }
                }

                // 새로운 배열로 변환
                List<List<Integer>> newArr = new ArrayList<>();
                for (int i = 0; i < maxLen; i++) {
                    List<Integer> newRow = new ArrayList<>();
                    for (int j = 0; j < cols.size(); j++) {
                        newRow.add(cols.get(j).get(i));
                    }
                    newArr.add(newRow);
                }
                arr = newArr;
            }

            time++;
        }

        System.out.println(time >= 100 ? -1 : time);
    }
}
