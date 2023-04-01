def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        tmp = bin(arr1[i]|arr2[i])[2:]
        tmp = tmp.zfill(n)
        tmp = tmp.replace("1", "#").replace("0", " ")
        answer.append(tmp)

    return answer

n = 5
arr1 = [9, 20, 28, 18, 11]
arr2 = [30, 1, 21, 17, 28]
print(solution(n, arr1, arr2))
# ["#####","# # #", "### #", "# ##", "#####"]

n = 6
arr1 = [46, 33, 33 ,22, 31, 50]
arr2 = [27 ,56, 19, 14, 14, 10]
print(solution(n, arr1, arr2))
# ["######", "### #", "## ##", " #### ", " #####", "### # "]
