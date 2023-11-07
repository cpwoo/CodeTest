package CodeTest.Java.programmers.etc.level3;

public class IIO옮기기 {
    public String[] solution(String[] st) {
        String[] answer = new String[st.length];
        for (int i=0; i<st.length; i++) {
            answer[i] = f(st[i]);
        }
        return answer;
    }
    
    private static String f(String s) {
        StringBuilder ret = new StringBuilder();
        int I = 0, IIO = 0;

        for (char i : s.toCharArray()) {
            if (i == '1') I += 1;
            else if (I > 1) {
                I -= 2;
                IIO += 1;
            }
            else {
                if (I > 0) ret.append("10");
                else ret.append("0");
                I = 0;
            }
        }
        
        for (int i=0; i<IIO; i++) {
            ret.append("110");
        }

        for (int i=0; i<I; i++) {
            ret.append("1");
        }

        return ret.toString();
    }
}
