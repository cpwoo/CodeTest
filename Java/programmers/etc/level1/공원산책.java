package CodeTest.Java.programmers.etc.level1;

public class 공원산책 {
    public int[] solution(String[] park, String[] routes) {
        int N = park.length;
        int M = park[0].length();
        
        int x = 0;
        int y = 0;
        
        for (int i=0; i<N; i++) {
            if (park[i].contains("S")) {
                x = i;
                y = park[i].indexOf("S");
            }
        }
        
        for (String route : routes) {
            String d = route.split(" ")[0];
            int move = Integer.parseInt(route.split(" ")[1]);
            
            int nx = x;
            int ny = y;
            
            for (int i=0; i<move; i++) {
                switch(d) {
                    case "S" : nx++; break;
                    case "N" : nx--; break;
                    case "E" : ny++; break;
                    case "W" : ny--; break;
                }
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (park[nx].substring(ny, ny+1).equals("X")) break;
                
                    if (i == move-1) {
                        x = nx;
                        y = ny;
                    }
                }
            }
        }
        
        return new int[]{x, y};
    }
}
