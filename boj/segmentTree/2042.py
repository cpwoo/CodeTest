import sys
input = lambda: sys.stdin.readline().rstrip()

# 트리 생성
def init(start, end, node):
    # start와 end가 같으면 리프노드
    if start == end:
        tree[node] = nList[start]
        return tree[node]
    
    # 현재 노드 = 왼쪽 아래 노드 + 오른쪽 아래 노드
    mid = (start+end)//2
    tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1)
    return tree[node]

# 트리 값 찾기
def summit(start, end, node, left, right):
    # 찾으려는 범위가 start~end 범위보다 큰 경우
    if left > end or right < start:
        return 0
    
    # 찾으려는 범위가 트리 노드안에 구현되어 있을 경우
    if left <= start and end <= right:
        return tree[node]

    # 현재 노드 = 왼쪽 아래 노드 + 오른쪽 아래 노드
    mid = (start+end)//2
    return summit(start, mid, node*2, left, right) + summit(mid+1, end, node*2+1, left, right)

# 트리 값 변경
def update(start, end, node, idx, diff):
    # 변경하려는 범위가 초과될 경우
    if idx < start or idx > end:
        return

    tree[node] += diff

    # 리프노드까지 바꿔줬으면 재귀함수 종료
    if start == end:
        return
    
    # 내가 관여하고 있는 노드들을 찾아서 변경 -> 재귀함수로 구현
    mid = (start+end)//2
    update(start, mid, node*2, idx, diff)
    update(mid+1, end, node*2+1, idx, diff)


n, m, k = map(int, input().split())
nList = [int(input()) for _ in range(n)]
tree = [0] * (4*n)
init(0, n-1, 1)

for _ in range(m+k):
    cmd = list(map(int, input().split()))

    if cmd[0] == 1:
        cmd[1] -= 1
        diff = cmd[2] - nList[cmd[1]]
        nList[cmd[1]] = cmd[2]
        update(0, n-1, 1, cmd[1], diff)

    elif cmd[0] == 2:
        print(summit(0, n-1, 1, cmd[1]-1, cmd[2]-1))
