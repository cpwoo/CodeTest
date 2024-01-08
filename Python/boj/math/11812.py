import sys
input = lambda: sys.stdin.readline().rstrip()

n, k, q = map(int, input().split())

for _ in range(q):
    x, y = map(int, input().split())
    
    if k == 1: 
        print(abs(x-y))
    else:
        cnt = 0
        # 둘이 같아질 때까지 큰 수 부모로 올리기
        while x != y:
            while x > y:
                cnt += 1
                x = (x+k-2)//k
            while y > x:
                cnt += 1
                y = (y+k-2)//k
        print(cnt)
