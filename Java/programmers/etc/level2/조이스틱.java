package CodeTest.Java.programmers.etc.level2;

public class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int _min = name.length()-1;
        
        int nxt = 0;
        
        for (int idx=0; idx<name.length(); idx++) {
            char c = name.charAt(idx);
            answer += Math.min(c-'A', 'Z'-c+1);
            nxt = idx+1;
            while (nxt < name.length() && name.charAt(nxt) == 'A') {
                nxt++;
            }
            _min = Math.min(_min, Math.min(2*idx+name.length()-nxt, idx+2*(name.length()-nxt)));
        }
        answer += _min;

        return answer;
    }
}
