import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
    
        List<Integer> NM = Arrays.stream(br.readLine().split(" "))
        .map(Integer::valueOf).collect(Collectors.toList());

        int N = NM.get(0);
        int M = NM.get(1);

        Deque<Integer> dodo = new ArrayDeque<>(); // 도도 덱
        Deque<Integer> su = new ArrayDeque<>(); // 수연 덱

        for(int i = 0 ; i < N ; i++){
            List<Integer> c = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf).collect(Collectors.toList());            
            dodo.offerLast(c.get(0));
            su.offerLast(c.get(1));
        }


        int cnt = 0;
        Deque<Integer> doGround = new ArrayDeque<>(); // 도도 그라운드
        Deque<Integer> suGround = new ArrayDeque<>(); // 수연 그라운드
        while (cnt < M) {
            cnt++;

            // 종료 조건
            if(dodo.isEmpty()){
                System.out.println("su");
                return;
            }
            if(su.isEmpty()){
                System.out.println("do");
                return;
            }

            // 카드 놓기
            if(cnt % 2 == 1){
                doGround.offerLast(dodo.pollLast());
            }
            else{
                suGround.offerLast(su.pollLast());
            }

            // 종료 조건
            if(dodo.isEmpty()){
                System.out.println("su");
                return;
            }
            if(su.isEmpty()){
                System.out.println("do");
                return;
            }            
            
            // 종치기
            if((!doGround.isEmpty() && doGround.peekLast() == 5) || 
            (!suGround.isEmpty() && suGround.peekLast() == 5)){
                // 도도가 종쳤음
                while (!suGround.isEmpty()) {
                    dodo.offerFirst(suGround.pollFirst());
                }
                while (!doGround.isEmpty()) {
                    dodo.offerFirst(doGround.pollFirst());
                }
                continue;
            }

            if(!doGround.isEmpty() && !suGround.isEmpty()){
                int d = doGround.peekLast();
                int s = suGround.peekLast();
                if(d + s == 5){
                    // 수연이 종쳤음
                    while (!doGround.isEmpty()) {
                        su.offerFirst(doGround.pollFirst());
                    }
                    while (!suGround.isEmpty()) {
                        su.offerFirst(suGround.pollFirst());
                    }
                }
            }
        }

        if(dodo.size() > su.size()){
            System.out.println("do");
        }else if(dodo.size() < su.size()){
            System.out.println("su");
        }else{
            System.out.println("dosu");
        }

    }
}


