import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static List<Point> teachers;
    static List<Point> blanks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<List<Character>> adj = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) adj.add(Arrays.stream(br.readLine().split(" "))
                                                   .map(s -> s.charAt(0))
                                                   .collect(Collectors.toList()));

        teachers = new ArrayList<>();
        blanks = new ArrayList<>();
        for(int i = 0 ; i < N ; i++)
            for(int j = 0 ; j < N ; j++){
                if(adj.get(i).get(j) == 'T') teachers.add(new Point(i, j));
                else if(adj.get(i).get(j) == 'X') blanks.add(new Point(i, j));
            }

        boolean ok = isPossible(adj);
        if(ok) System.out.println("YES");
        else System.out.println("NO");
        br.close();
    }

    static boolean isPossible(List<List<Character>> adj) {
        return combination(0, new ArrayList<>(), adj);
    }

    static boolean combination(int idx, List<Point> cur, List<List<Character>> adj) {
        if(cur.size() == 3){
            return check(adj);
        }

        for(int i = idx ; i < blanks.size() ; i++){
            Point p = blanks.get(i);
            adj.get(p.y).set(p.x, 'O');
            cur.add(p);
            if(combination(i + 1, cur, adj)) return true;
            cur.remove(cur.size() - 1);
            adj.get(p.y).set(p.x, 'X');
        }
        return false;
    }

    static boolean check(List<List<Character>> adj) {
        for(Point t : teachers) {
            if(isSearch(t, adj)){
                return false;
            }
        }
        return true;
    }

    static boolean isSearch(Point cur, List<List<Character>> adj) {
        // 동쪽 탐색
        int idx = 1;
        while(cur.x + idx < adj.size()) {
            if(adj.get(cur.y).get(cur.x + idx) == 'O') break;
            if(adj.get(cur.y).get(cur.x + idx) == 'S') return true;
            idx++;
        }

        // 서쪽 탐색
        idx = 1;
        while(cur.x - idx >= 0) {
            if(adj.get(cur.y).get(cur.x - idx) == 'O') break;
            if(adj.get(cur.y).get(cur.x - idx) == 'S') return true;
            idx++;
        }

        // 남쪽 탐색
        idx = 1;
        while(cur.y + idx < adj.size()) {
            if(adj.get(cur.y + idx).get(cur.x) == 'O') break;
            if(adj.get(cur.y + idx).get(cur.x) == 'S') return true;
            idx++;
        }

        // 북쪽 탐색
        idx = 1;
        while(cur.y - idx >= 0) {
            if(adj.get(cur.y - idx).get(cur.x) == 'O') break;
            if(adj.get(cur.y - idx).get(cur.x) == 'S') return true;
            idx++;
        }        

        return false;
    }

    static class Point{
        int y;
        int x;

        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}