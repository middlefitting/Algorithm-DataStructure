N, K = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(int(input()))
arr.sort(reverse=True)

answer = 0
for i in range(N):
    answer += K // arr[i]
    K = K % arr[i]
print(answer)
