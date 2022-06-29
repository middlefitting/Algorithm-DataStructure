import sys
sys.setrecursionlimit(10**5)

N = int(input())
dp =  [0] * (N + 1)

def ftDP(x) :
  if (x == 1) :
    return (0)
  if (dp[x] != 0) :
    return (dp[x])
  dp[x] = ftDP(x - 1) + 1
  if ((x % 3 == 0) and (x % 2 == 0)) :
    dp[x] = min(dp[x], ftDP(x // 3) + 1, ftDP(x // 2) + 1)
  if (x % 3 == 0) :
    dp[x] = min(dp[x], ftDP(x // 3) + 1)
  elif (x % 2 == 0) :
    dp[x] = min(dp[x], ftDP(x // 2) + 1)
  return (dp[x])

#파이썬에서 setrecursionlimit를 설정해도 재귀의 깊이가 깊어지면 메모리에서 문제가 된다
for i in range(2, N + 1) :
  ftDP(i)
print(dp[N])