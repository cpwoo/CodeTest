from collections import deque

def solution(rc, operations):
    N = len(rc)
    L_col = deque([rc[i][0] for i in range(N)])
    R_col = deque([rc[i][-1] for i in range(N)])
    rows = deque([deque(rc[i][1:-1]) for i in range(N)])
    
    for op in operations:
        if op == "ShiftRow":
            L_col.appendleft(L_col.pop())
            rows.appendleft(rows.pop())
            R_col.appendleft(R_col.pop())
        else:
            rows[0].appendleft(L_col.popleft())
            R_col.appendleft(rows[0].pop())
            rows[-1].append(R_col.pop())
            L_col.append(rows[-1].popleft())
    
    answer = []
    for i in range(N):
        answer.append([L_col[i]] + list(rows[i]) + [R_col[i]])
    
    return answer


rc = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
operations = ["Rotate", "ShiftRow"]
print(solution(rc, operations)) # [[8, 9, 6], [4, 1, 2], [7, 5, 3]]

rc = [[8, 6, 3], [3, 3, 7], [8, 4, 9]]
operations = ["Rotate", "ShiftRow", "ShiftRow"]
print(solution(rc, operations)) # [[8, 3, 3], [4, 9, 7], [3, 8, 6]]

rc = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
operations = ["ShiftRow", "Rotate", "ShiftRow", "Rotate"]
print(solution(rc, operations)) # [[1, 6, 7 ,8], [5, 9, 10, 4], [2, 3, 12, 11]]
