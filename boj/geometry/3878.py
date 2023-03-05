import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)

# cvxh 생성 함수
def convex_hull(points, n):
    points = sorted(points)
    if len(points) <= 1:
        return points
    lower, upper = [], []
    for i in range(n):
        j = n-1-i
        while len(lower) >= 2 and ccw(lower[-2], lower[-1], points[i]) <= 0:
            lower.pop()
        lower.append(points[i])
        while len(upper) >= 2 and ccw(upper[-2], upper[-1], points[j]) <= 0:
            upper.pop()
        upper.append(points[j])
    return lower[:-1] + upper[:-1]

# 선 교차 여부 확인
def cross_check(line1, line2):
    p1, p2, p3, p4 = line1[0], line1[1], line2[0], line2[1]
    a1, a2 = ccw(p1, p2, p3), ccw(p1, p2, p4)
    a3, a4 = ccw(p3, p4, p1), ccw(p3, p4, p2)
    ans = 0
    if a1*a2 <= 0 and a3*a4 <= 0:
        if a1*a2 == 0 and a3*a4 == 0:
            if min(p1[0], p2[0]) <= max(p3[0], p4[0]) and min(p1[1], p2[1]) <= max(p3[1], p4[1]) \
            and min(p3[0], p4[0]) <= max(p1[0], p2[0]) and min(p3[1], p4[1]) <= max(p1[1], p2[1]):
                ans = 1
        else:
            ans = 1
    return ans


for _ in range(int(input())):
    b, w = map(int, input().split())
    black = [list(map(int, input().split())) for _ in range(b)]
    white = [list(map(int, input().split())) for _ in range(w)]

    cvxh_black = convex_hull(black, b)
    cvxh_white = convex_hull(white, w)

    # 어차피 cvxh 만 사용하기 때문에 int b, int w 갱신
    b, w = len(cvxh_black), len(cvxh_white)

    # 개수가 3개 미만인 경우에는 미리 처리
    if b < 3 and w < 3:
        if cross_check([cvxh_black[0], cvxh_black[1%b]], [cvxh_white[0], cvxh_white[1%w]]):
            print("NO")
        else:
            print("YES")
        continue

    # 선이 교차하지 않은 경우 뿐만 아니라 cvxh 안에 cvxh 가 들어가는 경우도 False 처리 해야 한다.
    ccw1_count = [0, 0]
    ccw2_count = [0, 0]
    
    flag = True
    for i in range(b):
        line1 = [cvxh_black[i], cvxh_black[(i+1)%b]]
        for j in range(w):
            ccw1 = ccw(cvxh_black[i], cvxh_white[j], cvxh_white[(j+1)%w])
            ccw2 = ccw(cvxh_white[j], cvxh_black[i], cvxh_black[(i+1)%b])
            
            if ccw1 > 0: ccw1_count[0] += 1
            elif ccw1 < 0: ccw1_count[1] += 1
            if ccw2 > 0: ccw2_count[0] += 1
            elif ccw2 < 0: ccw2_count[1] += 1

            line2 = [cvxh_white[j], cvxh_white[(j+1)%w]]
            if cross_check(line1, line2):
                flag = False
                break
        
        if not flag: break
    
    if max(ccw1_count) == b*w or max(ccw2_count) == b*w: flag = False

    print("YES" if flag else "NO")
