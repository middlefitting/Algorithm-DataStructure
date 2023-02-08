N, M = map(int, input().split())
arr = list(map(int, input().split()))
answer = []
for i in range(N):
    answer.append(arr[i])

answer.sort(reverse=True)
print(answer[M - 1])
