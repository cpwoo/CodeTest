import sys
input = lambda: sys.stdin.readline().rstrip()

# 연산값, 부호, 다음에 연산될 숫자, 몇번째 항, 현재까지 표현식
def dfs(total, sign, num, n, string):
    if (n == N):
        total += (sign*num)
        if total == 0:
            print(string)
    else:
        dfs(total         , sign, num*10+(n+1), n+1, string+' '+str(n+1))
        dfs(total+sign*num,    1,        (n+1), n+1, string+'+'+str(n+1))
        dfs(total+sign*num,   -1,        (n+1), n+1, string+'-'+str(n+1))

for _ in range(int(input())):
    N = int(input())
    dfs(0, 1, 1, 1, "1")
    print()
