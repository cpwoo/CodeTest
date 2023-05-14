import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

def preorder(istart, iend, pstart, pend):
    if istart > iend or pstart > pend:
        return
    
    root = postorder[pend]
    print(root, end=' ')
    
    left_cnt = inorderIndices[root] - istart
    right_cnt = iend - inorderIndices[root]
    
    preorder(istart, inorderIndices[root]-1, pstart, pstart+left_cnt-1)
    preorder(inorderIndices[root]+1, iend, pend-right_cnt, pend-1)


n = int(input())
inorder = list(map(int, input().split()))
postorder = list(map(int, input().split()))
inorderIndices = [-1]*(n+1)
for i in range(n):
    inorderIndices[inorder[i]] = i
    
preorder(0, n-1, 0, n-1)
