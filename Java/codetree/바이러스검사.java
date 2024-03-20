import java.io.*;
import java.util.*;

public class 바이러스검사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] customers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            customers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int master = Integer.parseInt(st.nextToken());
        int slave = Integer.parseInt(st.nextToken());

        long ret = 0;
        for (int i=0; i<n; i++) {
            customers[i] -= master;
            ret++;
            if (customers[i] > 0) {
                if (customers[i]%slave == 0) ret += customers[i]/slave;
                else ret += customers[i]/slave + 1;
            }
        }

        System.out.println(ret);
    }
}
