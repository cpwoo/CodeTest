package CodeTest.Java.programmers.etc.level2;

public class JadenCase문자열만들기 {
    public String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        
        boolean flag = true;

        for(String st : sp) {
            answer += flag ? st.toUpperCase() : st;
            flag = st.equals(" ") ? true : false;
        }

        return answer;
    }
}
