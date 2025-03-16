

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class TrieNode {
        Map<String, TrieNode> children;

        TrieNode() {
            this.children = new TreeMap<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        TrieNode root = new TrieNode();

        for (int i = 0; i < n; i++) {

            String[] input = br.readLine().split(" ");
            int k = Integer.valueOf(input[0]);

            List<String> foods = new ArrayList<>();
            for (int j = 1; j < input.length; j++) {
                foods.add(input[j]);
            }
            insertIntoTrie(root, foods);
        }

        printTrie(root, 0);

    }

    private static void printTrie(TrieNode root, int depth) {
        for (Map.Entry<String, TrieNode> entry : root.children.entrySet()) {
            for (int i = 0; i < depth; i++) {
                System.out.print("--");
            }
            System.out.println(entry.getKey());

            printTrie(entry.getValue(), depth + 1);
        }
    }

    private static void insertIntoTrie(TrieNode root, List<String> foods) {
        TrieNode current = root;

        for (String food : foods) {
            if(!current.children.containsKey(food)) {
                current.children.put(food, new TrieNode());
            }
            current = current.children.get(food);
        }
    }
}
