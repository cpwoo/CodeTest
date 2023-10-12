package CodeTest.Java.programmers.etc.level1;

public class 크기가작은부분문자열 {
    public int solution(String t, String p) {
        int answer = 0;
        int T = t.length(), P = p.length();
        long n = Long.parseLong(p);
        for (int i=0; i<=T-P; i++) {
            long tmp = Long.parseLong(t.substring(i, i+P));
            if (tmp <= n) answer++;
        }
        return answer;
    }
}
