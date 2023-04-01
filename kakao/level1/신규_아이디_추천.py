import re

def solution(new_id):
    # 1단계
    new_id = new_id.lower()
    # 2단계
    new_id = re.sub("[^a-z0-9-_.]", "", new_id)
    # 3단계
    new_id = re.sub("\.+", ".", new_id)
    # 4단계
    new_id = re.sub("^[.]|[.]$", "", new_id)
    # 5단계 & 6단계
    new_id = "a" if not new_id else new_id[:15]
    new_id = re.sub("[.]$", "", new_id)
    # 7단계
    new_id = new_id if len(new_id) > 2 else new_id + "".join(new_id[-1] for _ in range(3-len(new_id)))

    return new_id


new_id = "...!@BaT#*..y.abcdefghijklm"
print(solution(new_id)) # "bat.y.abcdefghi"

new_id = "z-+.^."
print(solution(new_id)) # "z--"

new_id = "=.="
print(solution(new_id)) # "aaa"

new_id = "123_.def"
print(solution(new_id)) # "123_.def"

new_id = "abcdefghijklmn.p"
print(solution(new_id)) # "abcdefghijklmn"
