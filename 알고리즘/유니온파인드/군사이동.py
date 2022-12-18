# 첫 줄에 p와 w가 공백을 사이에 두고 주어집니다. (2 ≤ p ≤ 1 000; 1 ≤ w ≤ 50 000)
#
# 다음 줄에 Baekjoon World의 수도 c와 Cube World의 수도 v가 공백을 사이에 두고 주어집니다. (0 ≤ c, v < p; c ≠ v)
#
# 다음 w줄에 길이 연결하는 두 지점 wstart, wend,와 길의 너비 wwidth가 공백을 사이에 두고 주어집니다. (0 ≤ wstart, wend < p; wstart ≠ wend; 1 ≤ wwidth ≤ 1 000)
import sys

P, W = map(int, sys.stdin.readline().split())
C, V = map(int, sys.stdin.readline().split())
arr = []
uf = [-1] * (P + 1)


def find(a):
    if uf[a] < 0:
        return a
    uf[a] = find(uf[a])
    return uf[a]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    uf[b] = a


for i in range(W):
    arr.append(list(map(int, sys.stdin.readline().split())))
arr.sort(key=lambda x: x[2], reverse=True)
for [a, b, w] in arr:
    merge(a, b)
    if find(C) == find(V):
        print(w)
        break

