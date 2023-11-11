package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 브라이언의고민 {
    private static final String invalid = "invalid";

    public String solution(String sentence) {
        StringBuilder answer = new StringBuilder();
        Map<Character, List<Integer>> lowerCount = new LinkedHashMap<>();

        try {
            int size = sentence.length();

            for (int i=0; i<size; i++) {
                char c = sentence.charAt(i);

                if (Character.isLowerCase(c)) {
                    if (!lowerCount.containsKey(c)) {
                        lowerCount.put(c, new ArrayList<>());
                    }
                    lowerCount.get(c).add(i);
                }
            }

            int stringIdx = 0;
            int startChar, endChar;
            int lastStartChar = -1, lastEndChar = -1;
            int startWord = 0, endWord = 0;
            int lastStartWord = -1, lastEndWord = -1;
            int cnt, distance;
            int rule = 0;

            List<Integer> tmp;

            for (char c : lowerCount.keySet()) {
                tmp = lowerCount.get(c);
                cnt = tmp.size();
                startChar = tmp.get(0);
                endChar = tmp.get(cnt-1);

                if (cnt == 1 || cnt >= 3) {
                    for (int i=1; i<cnt; i++) {
                        if (tmp.get(i)-tmp.get(i-1) != 2) return invalid;
                    }
                    rule = 1;
                }

                else if (cnt == 2) {
                    distance = endChar-startChar;

                    if (distance == 2 && (endChar < lastEndChar && startChar > lastStartChar)) {
                        rule = 1;
                    } else if (distance >= 2) {
                        rule = 2;
                    } else {
                        return invalid;
                    }
                }

                if (rule == 1) {
                    startWord = startChar-1;
                    endWord = endChar+1;

                    if (lastStartWord < startWord && lastEndWord > endWord) {
                        if (startChar-lastStartChar == 2 && lastEndChar-endChar == 2) continue;
                        else return invalid;
                    }
                }

                else if (rule == 2) {
                    startWord = startChar;
                    endWord = endChar;
                    
                    if (lastStartWord < startWord && lastEndWord > endWord) return invalid;
                }

                if (lastEndWord >= startWord) return invalid;

                if (stringIdx < startWord) {
                    answer.append(makeWord(sentence, stringIdx, startWord-1));
                    answer.append(" ");
                }
                answer.append(makeWord(sentence, startWord, endWord));
                answer.append(" ");
                lastStartWord = startWord;
                lastEndWord = endWord;
                lastStartChar = startChar;
                lastEndChar = endChar;
                stringIdx = endWord+1;
            }
            if (stringIdx < size) answer.append(makeWord(sentence, stringIdx, size-1));
        } 
        catch (Exception e) {
            return invalid;
        }

        return answer.toString().trim();
    }

    private static String makeWord(String sentence, int start, int end) {
        String word = sentence.substring(start, end+1);
        return word.replaceAll("[a-z]", "");
    }
}
