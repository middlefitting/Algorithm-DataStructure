import sys


def find(a):
    if uf[a] < 0:
        return a
    uf[a] = find(uf[a])
    return find(uf[a])


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    uf[a] += uf[b]
    uf[b] = a
    fill[a] += fill[b]


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    uf = [-1] * (M + 1)
    fill = [0] * (M + 1)
    for i in range(N):
        a, b = map(int, sys.stdin.readline().split())
        merge(a, b)
        if uf[find(a)] * -1 > fill[find(a)]:
            fill[find(a)] += 1
            print("LADICA")
        else:
            print("SMECE")

