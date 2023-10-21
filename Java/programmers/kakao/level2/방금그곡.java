package CodeTest.Java.programmers.kakao.level2;

public class 방금그곡 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int time = 0;
        
        m = sharpToLower(m);

        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            int t = calc(info[0], info[1]);
            
            if (t > time) {
                info[3] = sharpToLower(info[3]);
                StringBuffer sb = new StringBuffer();
                for (int i=0; i<t; i++) {
                    sb.append(info[3].charAt(i%(info[3].length())));
                }
                if (sb.toString().indexOf(m) >= 0) {
                    answer = info[2];
                    time = t;
                }
            }
        }

        return answer;
    }

    private static String sharpToLower(String tmp) {
        return tmp.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a");
    }

    private static int calc(String a, String b) {
        String[] sa = a.split(":");
        int ta = Integer.parseInt(sa[0])*60 + Integer.parseInt(sa[1]);

        String[] sb = b.split(":");
        int tb = Integer.parseInt(sb[0])*60 + Integer.parseInt(sb[1]);

        return tb-ta;
    }
}
