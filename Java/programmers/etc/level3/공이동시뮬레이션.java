package CodeTest.Java.programmers.etc.level3;

public class 공이동시뮬레이션 {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long sr=x, sc=y, er=x, ec=y;

		for(int i=queries.length-1 ; i>=0 ; i--) {
			int command=queries[i][0], dx=queries[i][1];
			
			if(command==0) {
				if(sc>0) sc += dx;
				ec = Math.min(m-1, ec+dx);
			} 
            else if(command==1) {
				if(ec<m-1) ec -= dx;
				sc = Math.max(0, sc-dx);
			} 
            else if(command==2) {
				if(sr>0) sr += dx;
				er = Math.min(n-1, er+dx);
			} 
            else {
				if(er<n-1) er -= dx;
				sr = Math.max(0, sr-dx);
			}
			if(sr>=n || er<0 || sc>=m || ec<0) return 0;	
		}
		return (er-sr+1)*(ec-sc+1);
    }
}
