import sys
from collections import deque

sin = sys.stdin.readline

if __name__ == "__main__":
    N = int(input())
    arr = deque(list(map(int, input().split())))
    dp = [0] * 21
    dp[arr.popleft()] = 1
    target = arr.pop()

    if target > 20 or target < 0:
        print(0)
        exit(0)

    while arr:
        x = arr.popleft()
        next_dp = [0] * 21
        for i in range(21):
            if i + x <= 20:
                next_dp[i + x] += dp[i]
            if i - x >= 0:
                next_dp[i - x] += dp[i]
        dp = next_dp
    print(dp[target])
