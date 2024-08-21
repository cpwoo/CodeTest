package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj14725 {
    static class TrieNode {
        Map<String, TrieNode> childNode = new HashMap<>();

        public TrieNode() {}

        void insert(List<String> lst) {
            TrieNode trieNode = this;

            for(int i=0; i<lst.size(); i++) {
                trieNode.childNode.putIfAbsent(lst.get(i), new TrieNode());
                trieNode = trieNode.childNode.get(lst.get(i));
            }
        }

        void print(TrieNode cur, int depth) {
            TrieNode trieNode = cur;
            if(trieNode.childNode != null) {
                List<String> lst = new ArrayList<>(trieNode.childNode.keySet());
                Collections.sort(lst);
                for(String str : lst) {
                    for(int i=0; i<depth; i++) sb.append("--");
                    sb.append(str).append('\n');
                    print(trieNode.childNode.get(str), depth+1);
                }
            }
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        TrieNode trie = new TrieNode();
        sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            List<String> lst = new ArrayList<>();
            for(int j=0; j<k; j++) lst.add(st.nextToken());

            trie.insert(lst);
        }

        trie.print(trie, 0);

        bw.write(sb.toString());
    }

}
