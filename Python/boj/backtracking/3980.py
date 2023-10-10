import sys
input = lambda: sys.stdin.readline().rstrip()

def get_max(idx, total):
    global _max
    if idx == 11:
        _max = max(_max, total)
        return
    
    for j in range(11):
        if check[j]: continue
        if answer[idx][j] != 0:
            check[j] = 1
            get_max(idx+1, total+answer[idx][j])
            check[j] = 0


for _ in range(int(input())):
    answer = [list(map(int, input().split())) for _ in range(11)]
    check = [0] * 11
    _max = 0
    get_max(0, 0)
    
    print(_max)
