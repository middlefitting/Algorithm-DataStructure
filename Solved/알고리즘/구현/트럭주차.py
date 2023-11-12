A, B, C = map(int, input().split())
B *= 2
C *= 3
price = [0, A, B, C]
arr = [0] * 100
for _ in range(3):
    s, e = map(int, input().split())
    for i in range(s, e):
        arr[i] += 1
answer = 0
for i in arr:
    answer += price[i]
print(answer)