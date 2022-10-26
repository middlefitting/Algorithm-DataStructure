from collections import deque

N = int(input())
card = deque([i for i in range(1, N + 1)])

while card:
    if len(card) == 1:
        break
    card.popleft()
    temp = card.popleft()
    card.append(temp)

print(card.popleft())
