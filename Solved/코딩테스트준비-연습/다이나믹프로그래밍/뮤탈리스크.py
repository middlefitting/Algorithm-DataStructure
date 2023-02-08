dp = [[[0] * 61 for _ in range(61)] for _ in range(61)]
mv = [[9,3,1], [9, 1, 3], [1,9,3], [1,3,9], [3,1,9], [3,9,1]]
a = 0
b = 0
c = 0
N = int(input())
scv = list(map(int, input().split()))
a = scv[0]
if N > 1:
    b = scv[1]
if N > 2:
    c = scv[2]


def attck(a, b, c, d1, d2, d3):
    a -= d1
    b -= d2
    c -= d3
    if a < 0:
        a = 0
    if b < 0:
        b = 0
    if c < 0:
        c = 0
    return [a, b, c]


def dfs(a, b, c ,depth):
    if a == 0 and b ==0 and c == 0:
        return
    for d1 ,d2, d3 in mv:
        ta, tb, tc = attck(a, b, c, d1, d2, d3)
        if dp[ta][tb][tc] == 0:
            dp[ta][tb][tc] = depth
            dfs(ta, tb, tc, depth + 1)
        if dp[ta][tb][tc] != 0:
            if dp[ta][tb][tc] > depth:
                dp[ta][tb][tc] = depth
                dfs(ta, tb, tc, depth + 1)


dfs(a, b, c, 1)
print(dp[0][0][0])
