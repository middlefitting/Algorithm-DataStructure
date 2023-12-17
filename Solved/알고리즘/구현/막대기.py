N = int(input())
arr = []
for _ in range(N):
    arr.append(int(input()))

m = 0
answer = 0
for i in range(N):
    temp = N - 1 - i
    if arr[temp] > m:
        m = arr[temp]
        answer += 1
print(answer)
