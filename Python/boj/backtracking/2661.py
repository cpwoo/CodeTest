import sys
input = lambda: sys.stdin.readline().rstrip()

def check(num):
    for idx in range(1, len(num)//2 + 1):
        if num[-idx:] == num[-(idx*2):-idx]:
            return False
    return True

def dfs(num):
    if len(num) == N:
        print(num)
        exit()
        
    for i in '123':
        if check(num+str(i)):
            dfs(num+str(i))
    return

N = int(input())
dfs('1')
