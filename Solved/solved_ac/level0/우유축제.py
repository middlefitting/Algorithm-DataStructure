N = int(input())
arr = list(map(int, input().split()))
lotate = [1, 2, 0]
temp = 0
answer = 0
for i in range(N):
    if arr[i] == temp:
        answer += 1
        temp = lotate[temp]
print(answer)