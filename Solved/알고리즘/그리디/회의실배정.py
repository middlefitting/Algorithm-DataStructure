N = int(input())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))
arr.sort(key=lambda x: (x[1], x[0]), reverse=True)
time = 0
answer = 0
while arr:
    start, end = arr.pop()
    if start < time:
        continue
    else:
        answer += 1
        time = end
print(answer)
