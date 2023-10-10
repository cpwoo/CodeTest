import sys
input = lambda: sys.stdin.readline().rstrip()

# 소용돌이 출력하면 arr 을 만들어 주는 것에서 멈췄겠지만, 예쁘게 출력하기 위해 그 다음 과정까지 거친다.
# 최댓값을 찾아주고, 그 값의 자리수에 맞춰서 공백을 추가하여 간격을 맞춰준다.

def get_value(x, y):
    idx = max(abs(x), abs(y))
    before_base = (2*(idx-1)+1)**2
    base = (2*idx+1)**2
    dx, dy = idx-x, idx-y

    if x >= y:
        return base-dx-dy
    else:
        return before_base+dx+dy
    

r1, c1, r2, c2 = map(int, input().split())

arr = []
for i in range(r1, r2+1):
    tmp = []
    for j in range(c1, c2+1):
        tmp.append(get_value(i, j))
    arr.append(tmp)

_max = 0
for i in range(r2-r1+1):
    for j in range(c2-c1+1):
        _max = max(_max, arr[i][j])

for i in range(r2-r1+1):
    for j in range(c2-c1+1):
        sub = len(str(_max)) - len(str(arr[i][j]))
        if sub > 0:
            print(' ' * sub, end='')
        print(arr[i][j], end=' ')
    print()
