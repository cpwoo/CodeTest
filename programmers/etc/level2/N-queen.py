def solution(n):

    col = [0]*n

    def check(x, y, n, col):
        for i in range(x):
            if y == col[i] or abs(y-col[i]) == x-i:
                return False
        return True

    def queen(x, n, col):
        if x == n:
            return 1
        cnt = 0
        for y in range(n):
            if check(x, y, n, col):
                col[x] = y
                cnt += queen(x+1, n, col)
        return cnt

    return queen(0, n, col)


n = 4
print(solution(n)) # 2
