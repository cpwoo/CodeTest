package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj5670 {
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

                if(i == word.length()-1) trieNode.terminal = true;
            }
        }

        int contains(String word) {
            TrieNode trieNode = this;
            int cnt = 0;
            
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = trieNode.childNode.get(c);

                if(i == 0) cnt++;
                else if(trieNode.terminal || trieNode.childNode.size() > 1) cnt++;
                
                trieNode = node;
            }
            
            return cnt;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        sb = new StringBuilder();

        String line;

        while((line = br.readLine()) != null) {
            try {
                int n = Integer.parseInt(line);
                List<String> lst = new ArrayList<>();
                TrieNode trie = new TrieNode();

                for(int i=0; i<n; i++) {
                    String str = br.readLine();
                    lst.add(str);
                    trie.insert(str);
                }

                double ret = 0;
                for(String str : lst) ret += trie.contains(str);
                sb.append(String.format("%.2f\n", ret/lst.size()));
            } 
            catch(Exception e) {
                break;
            }
        }

        bw.write(sb.toString());
    }

}
