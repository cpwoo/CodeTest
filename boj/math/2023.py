import sys
input = lambda: sys.stdin.readline().rstrip()

# 메모리 제한이 4MB 임을 유의할 것 (int 4KB 이므로 1e6 까지만 허용)

def check(num):
    for i in range(2, int(num**0.5)+1):
        if int(num)%i == 0:
            return False
    return True

def dfs(num):
    if len(str(num)) == n:
        print(num)
    else:
        for i in range(10):
            tmp = num*10+i

            if check(tmp) == True:
                dfs(tmp)

n = int(input())

# 한 자리수일 때 2, 3, 5, 7이 소수
dfs(2); dfs(3); dfs(5); dfs(7)
