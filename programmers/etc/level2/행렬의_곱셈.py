def solution(arr1, arr2):
    n, m, r = len(arr1), len(arr1[0]), len(arr2[0])
    answer = [[0]*r for _ in range(n)]
    for i in range(n):
        for j in range(m):
            for k in range(r):
                answer[i][k] += arr1[i][j]*arr2[j][k]
    return answer


arr1, arr2 = [[1, 4], [3, 2], [4, 1]], [[3, 3], [3, 3]]
print(solution(arr1, arr2)) # [[15, 15], [15, 15], [15, 15]]

arr1, arr2 = [[2, 3, 2], [4, 2, 4], [3, 1, 4]], [[5, 4, 3], [2, 4, 1], [3, 1, 1]]
print(solution(arr1, arr2)) # [[22, 22, 11], [36, 28, 18], [29, 20, 14]]
