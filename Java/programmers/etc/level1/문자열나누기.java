package CodeTest.Java.programmers.etc.level1;

public class 문자열나누기 {
    public int solution(String st) {
        int answer = 0;
        int pro = 0, con = 0;
        String prev = "1";
        
        for (String s : st.split("")) {
            if (prev.equals("1")) {
                prev = s;
                pro++;
                answer++;
            } else if (prev.equals(s)) {
                pro++;
            } else {
                con++;
            }
            
            if (pro == con) {
                prev = "1";
                pro = 0; 
                con = 0;
            }
        }
                
        return answer;
    }
}
