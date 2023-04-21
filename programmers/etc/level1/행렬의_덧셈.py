def solution(A, B):
    return [[c+d for c,d in zip(a,b)] for a,b in zip(A,B)]


arr1, arr2 = [[1,2],[2,3]], [[3,4],[5,6]]
print(solution(arr1, arr2)) # [[4,6],[7,9]]

arr1, arr2 = [[1],[2]], [[3],[4]]
print(solution(arr1, arr2)) # [[4],[6]]
