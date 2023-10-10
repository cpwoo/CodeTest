import sys
input = lambda: sys.stdin.readline().rstrip()

def postorder(preorder, inorder):
    if not inorder: return
    node = preorder.pop(0)
    idx = inorder.index(node)
    postorder(preorder, inorder[:idx])
    postorder(preorder, inorder[idx+1:])
    print(node, end=" ")
    
for _ in range(int(input())):
    n = int(input())
    preorder = list(map(int, input().split()))
    inorder = list(map(int, input().split()))
    postorder(preorder, inorder)
    print()
