import sys
input = lambda: sys.stdin.readline().rstrip()

def cal(x, ans, point):
    while x > 0:
        ans[x%10] += point
        x //= 10


ans = [0]*10

end = int(input())

point = 1
start = 1

while start <= end:
    while end % 10 != 9:
        cal(end, ans, point)
        end -= 1
    
    if end < start:
        break

    while start % 10 != 0:
        cal(start, ans, point)
        start += 1
    
    start //= 10
    end //= 10

    for i in range(10):
        ans[i] += (end-start+1)*point
    point *= 10

print(*ans)
