def solution(phone_book):
    phone_book = sorted(phone_book, key=len)
    s = set()
    for p in phone_book:
        for i in range(1, len(p)):
            if p[:i] in s:
                return False
        s.add(p)
    return True


phone_book = ["119", "97674223", "1195524421"]
print(solution(phone_book)) # False

phone_book = ["123","456","789"]
print(solution(phone_book)) # True

phone_book = ["12","123","1235","567","88"]
print(solution(phone_book)) # False
