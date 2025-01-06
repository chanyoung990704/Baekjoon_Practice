import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크로아티아 알파벳 배열 - z= 로 수정
        String[] crotic = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String str = br.readLine(); // 입력 단어

        for (String s : crotic) {
            str = str.replace(s, "*");    // 크로아티아 알파벳을 한 문자로 치환
        }

        System.out.println(str.length());
    }
}
