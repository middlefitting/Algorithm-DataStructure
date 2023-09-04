answer = []
N = int(input())
price = int(input())
answer.append(price)
if N >= 5:
    answer.append(max(price - 500, 0))
if N >= 10:
    answer.append((price // 10) * 9)
if N >= 15:
    answer.append(max(price - 2000, 0))
if N >= 20:
    answer.append((price // 100) * 75)
print(min(answer))