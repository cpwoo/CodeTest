import java.util.Scanner;

public class SWEA1206 {
    static int N;
    static int[] building;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        
		int T = 10;

		for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();
            building = new int[N];
            for (int i=0; i<N; i++) {
                building[i] = sc.nextInt();
            }
            
            int cnt = 0;
            for (int i=2; i<N-2; i++) {
                int _max = Math.max(Math.max(building[i-2], building[i-1]), Math.max(building[i+1], building[i+2]));
                if (building[i] > _max) {
                    cnt += building[i]-_max;
                }
            }
            
            System.out.println("#" + tc + " " + cnt);
		}

	}
}
