import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T =  Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int[] AB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int A = AB[0];
            int B =  AB[1];

            Queue<Node> q = new LinkedList<>();
            Set<Integer> set = new HashSet<>();

            q.offer(new Node(A,""));
            set.add(A);

            while (!q.isEmpty()) {
                Node cur = q.poll();
                // 찾은 경우
                if (cur.n == B) {
                    System.out.println(cur.op);
                    break;
                }

                // D
                if (!set.contains(cur.getD())) {
                    set.add(cur.getD());
                    q.offer(new Node(cur.getD(),cur.op + "D"));
                }
                // S
                if (!set.contains(cur.getS())) {
                    set.add(cur.getS());
                    q.offer(new Node(cur.getS(),cur.op + "S"));
                }
                // L
                if (!set.contains(cur.getL())) {
                    set.add(cur.getL());
                    q.offer(new Node(cur.getL(),cur.op + "L"));
                }

                // R
                if(!set.contains(cur.getR())) {
                    set.add(cur.getR());
                    q.offer(new Node(cur.getR(),cur.op + "R"));
                }
            }

        }
    }

    static class Node {
        int n;
        String op;

        public Node(int n, String op) {
            this.n = n;
            this.op = op;
        }

        public int getR() {
            return (n % 10 * 1000) + n / 10;
        }
        public int getL() {
            return n / 1000 + (n % 1000 * 10);
        }

        public int getD() {
            return 2 * n > 9999 ? 2 * n % 10000 : 2 * n;
        }

        public int getS() {
            return n == 0 ? 9999 : n - 1;
        }

    }
}
