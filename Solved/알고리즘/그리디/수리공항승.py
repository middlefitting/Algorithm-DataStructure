N, L = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

answer = 0
temp = 0

for i in arr:
    if i > temp:
        answer += 1
        temp = i - 0.5 + L

print(answer)
