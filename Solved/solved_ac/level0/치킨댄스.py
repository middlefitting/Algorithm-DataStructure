N = int(input())
c, m= map(int, input().split())
print(min(N, m + c // 2))
