package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj19585 {
    static class TrieNode {
        TrieNode[] childNode = new TrieNode[26];
        boolean terminal;

        public TrieNode() {}

        void insert(String str) {
            TrieNode trieNode = this;
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                int index = c-'a';

                if(trieNode.childNode[index] == null) {
                    trieNode.childNode[index] = new TrieNode();
                }
                trieNode = trieNode.childNode[index];
            }
            trieNode.terminal = true;
        }

        boolean search(String str) {
            TrieNode trieNode = this;
            for(int i=0; i<str.length(); i++) {
                if(trieNode.terminal && set.contains(str.substring(i))) return true;
                
                char c = str.charAt(i);
                int index = c-'a';
                
                if(trieNode.childNode[index] == null) break;
                trieNode = trieNode.childNode[index];
            }
            return false;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static TrieNode trie;
    private static Set<String> set;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        trie = new TrieNode();
        for(int i=0; i<C; i++) trie.insert(br.readLine());

        set = new HashSet<>();
        for(int i=0; i<N; i++) set.add(br.readLine());

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(tc-- > 0) {
            String q = br.readLine();
            sb.append(trie.search(q) ? "Yes\n" : "No\n");
        }

        bw.write(sb.toString());
    }

}
