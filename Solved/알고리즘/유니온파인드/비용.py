import sys
import heapq


def find(a):
    if uf[a] < 0:
        return a
    uf[a] = find(uf[a])
    return find(uf[a])


def merge(a, b, w):
    a = find(a)
    b = find(b)
    if a == b:
        weight[0] -= w
        return
    answer[0] = (answer[0] + uf[a] * uf[b] * weight[0]) % 10**9
    uf[a] += uf[b]
    uf[b] = a
    weight[0] -= w


if __name__ == "__main__":
    answer = [0]
    weight = [0]
    N, M = map(int, sys.stdin.readline().split())
    uf = [-1] * (N + 1)
    lines = []
    for _ in range(M):
        a, b, w = map(int, sys.stdin.readline().split())
        weight[0] += w
        heapq.heappush(lines, [-1 * w, a, b])
    while lines:
        w, a, b = heapq.heappop(lines)
        merge(a, b, w * -1)
    print(answer[0])
