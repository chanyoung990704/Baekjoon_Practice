import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static char[][] map;
    static Monster[][] monsters;
    static Item[][] items;
    static String moves;

    static int startY, startX, y, x;
    static int turn = 0;

    static int level=1;
    static int maxHp = 20, hp = 20;
    static int baseAtk =2, baseDef = 2;
    static int weapon = 0, armor = 0;
    static int exp = 0;

    static Set<String> acc = new HashSet<>();

    static boolean win = false;
    static boolean dead = false;
    static String deathReason = "";

    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    static class Monster {
        String name;
        int atk, def, maxHp, hp, exp;
        boolean boss;

        Monster(String name, int atk, int def, int maxHp, int exp, boolean boss) {
            this.name = name;
            this.atk = atk;
            this.def = def;
            this.maxHp = maxHp;
            this.hp = maxHp;
            this.exp = exp;
            this.boss = boss;
        }
    }

    static class Item {
        char type;      // W, A, O
        int value;      // W, A
        String accName; // O
    }

    public static void main(String[] args) throws IOException {
        input();
        simulate();
        printResult();
        System.out.print(sb);
    }

    private static void printResult() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!dead && i == y && j == x) {
                    sb.append('@');
                }else{
                    sb.append(map[i][j]);
                }
            }
            sb.append("\n");
        }

        sb.append("Passed Turns : ").append(turn).append('\n');
        sb.append("LV : ").append(level).append('\n');
        sb.append("HP : ").append(Math.max(0, hp)).append('/').append(maxHp).append('\n');
        sb.append("ATT : ").append(baseAtk).append('+').append(weapon).append('\n');
        sb.append("DEF : ").append(baseDef).append('+').append(armor).append('\n');
        sb.append("EXP : ").append(exp).append('/').append(level * 5).append('\n');

        if (win) {
            sb.append("YOU WIN!");
        } else if (dead) {
            sb.append("YOU HAVE BEEN KILLED BY ").append(deathReason).append("..");
        } else {
            sb.append("Press any key to continue.");
        }
    }

    private static void simulate() {
        for (int i = 0; i < moves.length(); i++) {
            if (win || dead) {
                break;
            }

            move(moves.charAt(i));
            processCell();
            turn++;
        }
    }

    private static void processCell() {
        char cell = map[y][x];

        if (cell == 'B') {
            // 아이템
            openBox();
        } else if (cell == '^') {
            // 덤불
            stepTrap();
        } else if (cell == '&' || cell == 'M') {
            // 전투
            battle(monsters[y][x]);
        }
    }

    private static void battle(Monster monster) {
        boolean firstTurn = true;

        if (monster.boss && has("HU")) {
            hp = maxHp;
        }

        while (true) {
            int playerDamage = getPlayerDamage(firstTurn);
            monster.hp -= playerDamage;

            if (monster.hp <= 0) {
                winBattle(monster);
                return;
            }

            if (!(firstTurn && monster.boss && has("HU"))) {
                int monsterDamage = Math.max(1, monster.atk - getPlayerDef());
                hp -= monsterDamage;
            }

            if (hp <= 0) {
                if (!revive(monster)) {
                    dead = true;
                    deathReason = monster.name;
                }
                return;
            }

            firstTurn = false;
        }
    }

    private static int getPlayerDef() {
        return baseDef + armor;
    }

    private static void winBattle(Monster monster) {
        map[y][x] = '.';

        if (has("HR")) {
            hp = Math.min(maxHp, hp + 3);
        }

        int gainedExp = monster.exp;
        if (has("EX")) {
            gainedExp = (gainedExp * 12) / 10;
        }

        exp += gainedExp;
        levelUp();

        if (monster.boss) {
            win = true;
        }
    }

    private static void levelUp() {
        if (exp >= level * 5) {
            level++;
            exp = 0;
            maxHp += 5;
            hp = maxHp;
            baseAtk += 2;
            baseDef += 2;
        }
    }

    private static int getPlayerDamage(boolean firstTurn) {
        int atk = getPlayerAtk();
        if (firstTurn && has("CO")) {
            atk *= has("DX") ? 3 : 2;
        }
        return Math.max(1, atk - monsters[y][x].def);
    }

    private static int getPlayerAtk() {
        return baseAtk + weapon;
    }

    private static void stepTrap() {
        hp -= has("DX") ? 1 : 5;
        if (hp <= 0) {
            if (!revive(null)) {
                dead = true;
                deathReason = "SPIKE TRAP";
            }
        }
    }

    private static boolean revive(Monster monster) {
        if (!has("RE")) {
            return false;
        }

        acc.remove("RE");
        y = startY;
        x = startX;
        hp = maxHp;

        if (monster != null) {
            monster.hp = monster.maxHp;
        }
        return true;
    }

    private static boolean has(String name) {
        return acc.contains(name);
    }

    private static void openBox() {
        Item item = items[y][x];
        if (item.type == 'W') {
            weapon = item.value;
        } else if (item.type == 'A') {
            armor = item.value;
        }else{
            if (acc.size() < 4 && !acc.contains(item.accName)) {
                acc.add(item.accName);
            }
        }
        map[y][x] = '.';
    }

    private static void move(char cmd) {
        int ny = y;
        int nx = x;

        if (cmd == 'U') ny--;
        else if (cmd == 'D') ny++;
        else if (cmd == 'L') nx--;
        else if (cmd == 'R') nx++;

        // 범위 확인
        if (!inRange(ny, nx) || map[ny][nx] == '#') {
            return;
        }

        y = ny;
        x = nx;
    }

    private static boolean inRange(int ny, int nx) {
        return ny >= 0 && ny < N && nx >= 0 && nx < M;
    }

    private static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int monsterCnt = 0, itemCnt = 0;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '@') {
                    // 주인공 시작점
                    startY = y = i;
                    startX = x = j;
                    map[i][j] = '.';
                } else if (map[i][j] == '&' || map[i][j] == 'M') {
                    // 몬스터
                    monsterCnt++;
                } else if (map[i][j] == 'B') {
                    // 아이템
                    itemCnt++;
                }
            }
        }

        moves = br.readLine();

        monsters = new Monster[N][M];
        for (int i = 0; i < monsterCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            String name = st.nextToken();
            int atk = Integer.parseInt(st.nextToken());
            int def = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());
            int exp = Integer.parseInt(st.nextToken());

            monsters[r][c] = new Monster(name, atk, def, hp, exp, map[r][c] == 'M');
        }

        items = new Item[N][M];
        for (int i = 0; i < itemCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            Item item = new Item();
            item.type = st.nextToken().charAt(0);
            if (item.type == 'O') {
                item.accName = st.nextToken();
            } else {
                item.value = Integer.parseInt(st.nextToken());
            }
            items[r][c] = item;
        }
    }

}