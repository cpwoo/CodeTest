package CodeTest.Java.programmers.kakao.level4;

import java.util.*;

class Trie {
    Map<Integer, Integer> lenMap = new HashMap<>();
    Trie[] child = new Trie[26];

    void insert(String st) {
        Trie node = this;
        int len = st.length();
        lenMap.put(len, lenMap.getOrDefault(len, 0)+1);

        for (char ch : st.toCharArray()) {
            int idx = ch-'a';
            if (node.child[idx] == null) node.child[idx] = new Trie();

            node = node.child[idx];
            node.lenMap.put(len, node.lenMap.getOrDefault(len, 0)+1);
        }
    }

    int find(String st, int i) {
        if (st.charAt(i) == '?') return lenMap.getOrDefault(st.length(), 0);

        int idx = st.charAt(i)-'a';
        return child[idx] == null ? 0 : child[idx].find(st, i+1);
    }
}

public class 가사검색 {
    public int[] solution(String[] words, String[] queries) {
        Trie front = new Trie(), back = new Trie();

        for (String word : words) {
            front.insert(word);
            back.insert(reverse(word));
        }

        int[] answer = new int[queries.length];

        for (int i=0; i<queries.length; i++) {
            String query = queries[i];
            if (query.charAt(0) != '?') answer[i] = front.find(query, 0);
            else answer[i] = back.find(reverse(query), 0);
        }

        return answer;
    }

    private static String reverse(String st) {
        return new StringBuilder(st).reverse().toString();
    }
}
