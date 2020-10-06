package com.opensource.dada.ds.trie;

import java.util.*;

public class BoggleBoard {
    public static void main(String[] args) {
        String[] words = {
                "this",
                "is",
                "not",
                "a",
                "simple",
                "boggle",
                "board",
                "test",
                "REPEATED",
                "NOTRE-PEATED"
        };

        char[][] board= {
                {'t','h','i','s','i','s','a'},//this row has "this" and "is"
                {'s','i','m','p','l','e','x'},//this row has "simple"
                {'b','x','x','x','x','e','b'},//this has "boggle"'s starting char 'b' and last char 'e'
                {'x','o','g','g','l','x','o'},//this has "boggle"'s middle part 'oggl'
                {'x','x','x','D','T','r','a'},
                {'R','E','P','E','A','d','x'},
                {'t','h','i','s','i','s','a'},
                {'x','x','x','x','x','x','x'},
                {'N','O','T','R','E','-','P'},
                {'x','x','D','E','T','A','E'}
        };
        System.out.println("Result:"+boggleBoard(board, words));
    }
    //Complexity Time: O(nm*(8^s) + w) where n is height and m is width of board, w is no. of words
    static Set<String> boggleBoard(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.add(word);
        }
        Map<String, Boolean> finalWords = new HashMap<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                explore(board, i, j, trie.getRoot(), finalWords, visited);
            }
        }
        return finalWords.keySet();
    }

    private static void explore(char[][] board, int i, int j, Map trieNode,
                                Map<String, Boolean> finalWords, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }

        char letter = board[i][j];
        if (!trieNode.containsKey(letter)) {
            return;
        }
        visited[i][j] = true;
        trieNode = (Map) trieNode.get(letter);
        if (trieNode.containsKey('*')) {
            finalWords.put((String) trieNode.get('*'), true);
        }
        List<int[]> neighbors = getNeighbors(board, i, j);
        for (int[] neighbor: neighbors) {
            explore(board, neighbor[0], neighbor[1], trieNode, finalWords,visited);
        }
        visited[i][j] = false;
    }

    static List<int[]> getNeighbors(char[][] board, int i, int j) {
        List<int[]> neighbors = new ArrayList<>();

        if (i > 0 && j > 0) {
            neighbors.add(new int[]{i - 1, j - 1});
        }
        if (i > 0 && j < board[0].length -1) {
            neighbors.add(new int[]{i - 1, j +1});
        }
        if (i < board.length -1 && j < board[0].length -1) {
            neighbors.add(new int[]{i + 1, j + 1});
        }
        if (i < board.length -1 && j > 0) {
            neighbors.add(new int[]{i + 1, j - 1});
        }
        if (i > 0) {
            neighbors.add(new int[]{i - 1, j});
        }
        if (i < board.length -1) {
            neighbors.add(new int[]{i + 1, j});
        }
        if (j > 0) {
            neighbors.add(new int[]{i, j -1 });
        }
        if (j < board[0].length -1) {
            neighbors.add(new int[]{i, j + 1});
        }

        return neighbors;
    }
}
