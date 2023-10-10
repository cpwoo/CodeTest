import sys
sys.setrecursionlimit(10**6)

class Node:
    def __init__(self, id, x, y):
        self.id = id
        self.x = x
        self.y = y
        self.left = None
        self.right = None

    def __lt__(self, other):
        if (self.y == other.y):
            return self.x < other.x
        return self.y > other.y

def addNode(parent, child):
    if child.x < parent.x:
        if parent.left is None:
            parent.left = child
        else:
            addNode(parent.left, child)
    else:
        if parent.right is None:
            parent.right = child
        else:
            addNode(parent.right, child)

def preorder(ans, node):
    if node == None: return
    ans.append(node.id)
    preorder(ans, node.left)
    preorder(ans, node.right)

def postorder(ans, node):
    if node == None: return
    postorder(ans, node.left)
    postorder(ans, node.right)
    ans.append(node.id)

def solution(nodeinfo):
    size = len(nodeinfo)
    node_lst = []
    for i in range(size):
        node_lst.append(Node(i+1, nodeinfo[i][0], nodeinfo[i][1]))

    node_lst.sort()
    root = node_lst[0]
    for i in range(1, size):
        addNode(root, node_lst[i])

    answer = [[], []]
    preorder(answer[0], root)
    postorder(answer[1], root)
    return answer


nodeinfo = [[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]
print(solution(nodeinfo)) # [[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
