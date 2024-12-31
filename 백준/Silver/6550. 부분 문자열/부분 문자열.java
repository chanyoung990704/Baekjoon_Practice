import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력을 반복적으로 처리
        while (sc.hasNext()) {
            String s = sc.next(); // 첫 번째 문자열 (부분 문자열 확인 대상)
            String t = sc.next(); // 두 번째 문자열 (전체 문자열)

            if (isSubsequence(s, t)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        sc.close();
    }

    // 부분 문자열인지 확인하는 메서드
    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0, tIndex = 0;

        // 두 문자열을 순회하며 부분 문자열인지 확인
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++; // s의 현재 문자가 t에서 매치되었으면 sIndex 증가
            }
            tIndex++; // tIndex는 항상 증가
        }

        // sIndex가 s의 길이와 같다면 s는 t의 부분 문자열
        return sIndex == s.length();
    }
}
