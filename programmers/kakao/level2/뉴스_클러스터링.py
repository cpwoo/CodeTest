import re

def solution(str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()
    str1 = re.sub("[^a-z]", " ", str1)
    str2 = re.sub("[^a-z]", " ", str2)
    
    arr1, arr2 = [], []
    for i in range(len(str1)-1):
        if str1[i] != " " and str1[i+1] != " ":
            arr1.append(str1[i]+str1[i+1])
    for i in range(len(str2)-1):
        if str2[i] != " " and str2[i+1] != " ":
            arr2.append(str2[i]+str2[i+1])
            
    s1, s2 = set(arr1), set(arr2)
    AND, OR = s1&s2, s1|s2
    
    AND_len = sum([min(arr1.count(i), arr2.count(i)) for i in AND])
    OR_len = sum([max(arr1.count(i), arr2.count(i)) for i in OR])
    
    return 65536 if OR_len == 0 else 65536*AND_len//OR_len


str1, str2 = "FRANCE", "french"
print(solution(str1, str2)) # 16384

str1, str2 = "handshake", "shake hands"
print(solution(str1, str2)) # 65536

str1, str2 = "aa1+aa2", "AAAA12"
print(solution(str1, str2)) # 43690

str1, str2 = "E=M*C^2", "e=m*c^2"
print(solution(str1, str2)) # 65536
