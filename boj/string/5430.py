import sys
input = lambda: sys.stdin.readline().rstrip()

# 뒤집는 건 시간이 많이 걸린다. 이를 대체한 풀이

for _ in range(int(input())):
    p = input()
    n = int(input())
    arr = input()[1:-1].split(',')
    p = p.replace('RR','')
    
    r = 0
    f, b = 0, 0
    
    for i in p:
        if i == 'R':
            r += 1
        elif i == 'D':
            if r % 2 == 0:
                f += 1
            else:
                b += 1
    
    if f + b <= n:
        arr = arr[f:n-b]
        if r % 2 == 1:
            print('['+','.join(arr[::-1])+']')
        else:
            print('['+','.join(arr)+']')
    else:
        print('error')
