package CodeTest.Java.programmers.etc.level1;

public class 이상한문자만들기 {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        String[] arr = s.split("");

        for (String a : arr) {
            cnt = a.equals(" ") ? 0 : cnt+1;
            answer += cnt%2 == 0 ? a.toLowerCase() : a.toUpperCase();
        }
        
        return answer;
    }
}
