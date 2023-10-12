package CodeTest.Java.programmers.etc.level1;

public class 둘만의암호 {
    public String solution(String st, String skip, int index) {
        String answer = "";
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        for (String i : skip.split("")) {
            alpha = alpha.replaceAll(i, "");
        }

        int n = alpha.length();
        for (String s : st.split("")) {
            int p = (alpha.indexOf(s)+index)%n;
            answer += alpha.substring(p, p+1);
        }
 
        return answer;
    }
}
