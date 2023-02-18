import sys

sys.setrecursionlimit(10 ** 5)


def sticker(c, status, arr, dp):
    if v[c][status]:
        return dp[c][status]
    if status == 0:
        v[c][status] = 1
        dp[c][status] = max(sticker(c - 1, 0, arr, dp), sticker(c - 1, 1, arr, dp), sticker(c - 1, 2, arr, dp))
        return max(sticker(c - 1, 0, arr, dp), sticker(c - 1, 1, arr, dp), sticker(c - 1, 2, arr, dp))
    else:
        ps = 1
        if status == 1:
            ps = 2
        v[c][status] = 1
        dp[c][status] = max(sticker(c - 1, 0, arr, dp) + arr[c][status - 1], sticker(c - 1, ps, arr, dp) + arr[c][status - 1])
        return dp[c][status]


if __name__ == '__main__':
    for _ in range(int(input())):
        N = int(input())
        arr = [[] for i in range(N)]
        temp = list(map(int, input().split()))
        temp2 = list(map(int, input().split()))
        for i in range(N):
            arr[i].append(temp[i])
            arr[i].append(temp2[i])
        dp = [[0, 0, 0] for i in range(N)]
        v = [[0, 0, 0] for i in range(N)]
        v[0][0] = 1
        v[0][1] = 1
        v[0][2] = 1
        dp[0][0] = 0
        dp[0][1] = arr[0][0]
        dp[0][2] = arr[0][1]
        sticker(N - 1, 0, arr, dp)
        sticker(N - 1, 1, arr, dp)
        sticker(N - 1, 2, arr, dp)
        print(max(dp[N - 1]))
