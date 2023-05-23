N, M, K = map(int, input().split())
answer = 0
answer += min(M, K)
answer += min(N - M, N - K)
print(answer)