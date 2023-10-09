N = int(input())
answer = 0
a, b, c = map(int, input().split())
answer += min(a, N)
answer += min(b, N)
answer += min(c, N)
print(answer)
