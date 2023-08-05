N = int(input())
arr = list(map(int, input().split()))
answer = 0
temp = 0
for i in range(N):
    if not arr[i]:
        temp = 0
    if arr[i]:
        temp += 1
        answer += temp
print(answer)
