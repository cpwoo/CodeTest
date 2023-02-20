import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import permutations

def shuffle(card1, card2, card3):
    if len(card2) > 1:
        return shuffle(card2[:len(card2)//2] + card1, card2[len(card2)//2:], card3)
    else:
        card = card2 + card1 + card3
        return card
    
n = int(input())
correct_cards = list(map(int, input().split()))
answer = []
orders = list(range(1, 10)) + list(range(1, 10))

for perm in permutations(orders, 2):
    if 2 ** max(perm) >= n: continue
    cards = list(range(1, n+1))
    for k in perm:
        card1 = []
        card2 = cards[n-(2**k):]
        card3 = cards[:n-(2**k)]
        cards = shuffle(card1, card2, card3)
        
    if cards == correct_cards:
        answer = perm
        break

print(' '.join(map(str, answer)))
