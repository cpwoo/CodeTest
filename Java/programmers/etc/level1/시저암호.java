package CodeTest.Java.programmers.etc.level1;

public class 시저암호 {
    public String solution(String s, int n) {
        String answer = "";
        
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                ch = (char) ((ch-'a'+n)%26+'a');
            } else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch-'A'+n)%26+'A');
            }
            answer += ch;
        }
        
        return answer;
    }
}
