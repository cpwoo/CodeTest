import sys
input = lambda: sys.stdin.readline().rstrip()

INF = int(1e9)

def update(pos, val, node, start, end):
    if end < pos or pos < start:
        return tree[node]
    if start == end:
        tree[node] = val
        return tree[node]
    mid = (start+end)>>1
    tree[node] = min(update(pos, val, node*2, start, mid), update(pos, val, node*2+1, mid+1, end))
    return tree[node]

def query(left, right, node, start, end):
    if end < left or right < start: return INF
    if left <= start and end <= right: return tree[node]
    mid = (start+end)>>1
    return min(query(left, right, node*2, start, mid), query(left, right, node*2+1, mid+1, end))


n = int(input())
student = [[0, 0, 0] for _ in range(n+1)]
tree = [0]*(4*n)

x = list(map(int, input().split()))
y = list(map(int, input().split()))
z = list(map(int, input().split()))

for i in range(n):
    student[x[i]][0] = i+1
    student[y[i]][1] = i+1
    student[z[i]][2] = i+1

student.sort() # 시험 A 는 정렬되었으므로 B, C 만 비교하면 된다.

# Tree 의 모든 원소 INF 로 초기화
for i in range(1, n+1):
    update(i, INF, 1, 1, n)

# Tree 의 [1~B-1] 구간의 최솟값 > C ?
# 비교 후 현재 학생의 B 자리에 C 저장
res = 0
for i in range(1, n+1):
    if query(1, student[i][1], 1, 1, n) > student[i][2]: res += 1
    update(student[i][1], student[i][2], 1, 1, n)

print(res)
