#1일때 1개의 경우 존재, 2일때 1개의 경우 추가
import sys
sys.setrecursionlimit(10**5)

N = int(input())
dp = [0] * 1001
dp[1] = 1
dp[2] = 2

def ftDP(x) :
  if (dp[x] != 0) :
    return (dp[x] % 10007)
  dp[x] = ftDP(x - 1) + ftDP(x - 2)
  return (dp[x] % 10007)

print(ftDP(N))