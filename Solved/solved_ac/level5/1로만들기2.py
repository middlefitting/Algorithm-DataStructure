# import sys
# from collections import deque
#
# N = int(sys.stdin.readline())
# answer_arr = [deque([])]
# answer = [1000000]
# temp_arr = deque([N])
# dp = [0] * (N + 1)
#
# def dfs(temp_n, depth) :
#     if temp_n == 1:
#         if answer[0] > depth:
#             answer[0] = depth
#             answer_arr[0] = temp_arr.copy()
#         return
#     if temp_n % 3 == 0:
#         temp_arr.append(temp_n // 3)
#         dfs(temp_n // 3, depth + 1)
#         temp_arr.pop()
#     elif temp_n % 2 == 0:
#         temp_arr.append(temp_n // 2)
#         dfs(temp_n // 2, depth + 1)
#         temp_arr.pop()
#     else:
#         temp_arr.append(temp_n - 1)
#         dfs(temp_n - 1, depth + 1)
#         temp_arr.pop()
#
# dfs(N, 0)
# print(answer[0])
# for i in answer_arr[0]:
#     print(i, end=" ")
# print()

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
  elif (x % 3 == 0) :
    dp[x] = min(dp[x], ftDP(x // 3) + 1)
  elif (x % 2 == 0) :
    dp[x] = min(dp[x], ftDP(x // 2) + 1)
  return (dp[x])

def ft_printDP(x) :
  print(x, end=" ")
  if (x == 1) :
    return (0)
  if ((x % 3 == 0) and (x % 2 == 0)) :
    low = min(dp[x - 1] ,dp[x // 3], dp[x // 2])
    if(low == dp[x -1]) :
      ft_printDP(x-1)
    elif (low == dp[x // 3]):
      ft_printDP(x // 3)
    elif (low == dp[x // 2]):
      ft_printDP(x // 2)

  elif (x % 3 == 0) :
    low = min(dp[x - 1], dp[x // 3])
    if(low == dp[x -1]) :
      ft_printDP(x-1)
    elif (low == dp[x // 3]):
      ft_printDP(x // 3)

  elif (x % 2 == 0) :
    low = min(dp[x - 1], dp[x // 2])
    if(low == dp[x -1]) :
      ft_printDP(x-1)
    elif (low == dp[x // 2]):
      ft_printDP(x // 2)
  else:
    ft_printDP(x - 1)

for i in range(2, N + 1) :
  ftDP(i)
print(dp[N])
ft_printDP(N)
print()