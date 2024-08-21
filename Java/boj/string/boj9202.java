package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj9202 {
    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean terminal;

        public TrieNode() {}

        void insert(String word) {
            TrieNode trieNode = this;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                trieNode.childNode.putIfAbsent(c, new TrieNode());
                trieNode = trieNode.childNode.get(c);
                if(i == word.length()-1) {
                    trieNode.terminal = true;
                }
            }
        }

        boolean isInitWord(char init) {
            TrieNode trieNode = this;
            for(char c : trieNode.childNode.keySet()) {
                if(init == c) return true;
            }
            return false;
        }
        
        boolean contains(String word, boolean flag) {
            if(word.length() > 8) return false;
            TrieNode trieNode = this;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = trieNode.childNode.get(c);
                if(node == null) return false;
                trieNode = node;
            }
            return (flag) ? trieNode.terminal : true;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static final int[] dx = {0,1,1,1,0,-1,-1,-1};
    private static final int[] dy = {1,1,0,-1,-1,-1,0,1};

    private static TrieNode trie;
    private static char[][] map;
    private static Set<String> rs;
    private static boolean[][] chk;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int w = Integer.parseInt(br.readLine());
        
        trie = new TrieNode();
        for(int i=0; i<w; i++) {
            trie.insert(br.readLine());
        }
        br.readLine();

        int b = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int t=0; t<b; t++) {
            map = new char[4][4];
            for(int i=0; i<4; i++) map[i] = br.readLine().toCharArray();

            rs = new HashSet<>();
            chk = new boolean[4][4];
            for(int i=0; i<4; i++) for(int j=0; j<4; j++) {
                if(trie.isInitWord(map[i][j])) {
                    chk[i][j] = true;
                    search(j, i, ""+map[i][j]);
                    chk[i][j] = false;
                }
            }

            List<String> rl = new ArrayList<>(rs);
            Collections.sort(rl);

            int cnt = 0, maxLen = 0, idx = 0;
            for(int i=0; i<rl.size(); i++) {
                int len = rl.get(i).length();
                if(maxLen < len) {
                    idx = i;
                    maxLen = len;
                }
                cnt += getScore(len);
            }

            sb.append(cnt).append(' ').append(rl.get(idx)).append(' ').append(rl.size()).append('\n');
            
            if(t != b-1) br.readLine();
        }

        bw.write(sb.toString());
    }

    private static void search(int x, int y, String str) {
        if(trie.contains(str, true)) rs.add(str);

        for(int d=0; d<8; d++) {
            int nx = x+dx[d], ny = y+dy[d];

            if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
            if(chk[ny][nx]) continue;

            String nxt = str+map[ny][nx];
            if(trie.contains(nxt, false)) {
                chk[ny][nx] = true;
                search(nx, ny, nxt);
                chk[ny][nx] = false;
            }
        }
    }

    private static int getScore(int len) {
        if(len <= 2) return 0;
        else if(len <= 4) return 1;
        else if(len == 5) return 2;
        else if(len == 6) return 3;
        else if(len == 7) return 5;
        else if(len == 8) return 11;
        return 0;
    }

}
