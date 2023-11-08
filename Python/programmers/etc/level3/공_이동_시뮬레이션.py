def solution(n, m, x, y, queries):
    sr, er, sc, ec = x, x, y, y
    queries = queries[::-1]
    for d, dx in queries:
        if d == 0:
            if sc > 0:
                sc += dx
            ec = min(m-1, ec+dx);
        elif d == 1:
            if ec < m-1:
                ec -= dx
            sc = max(0, sc-dx)
        elif d == 2:
            if sr > 0:
                sr += dx
            er = min(n-1, er+dx)
        else:
            if er < n-1:
                er -= dx
            sr = max(0, sr-dx)
        
        if sr>=n or er<0 or sc>=m or ec<0:
            return 0

    return (er-sr+1)*(ec-sc+1)
