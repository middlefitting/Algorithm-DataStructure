from collections import deque
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
    uf[b] = a


if __name__ == "__main__":
    ind = 0
    while True:
        ind += 1
        N, M = map(int, sys.stdin.readline().split())
        if N == 0 and M == 0:
            break
        uf = [-1] * (N + 1)
        answer = 0
        s = [[] for _ in range(N + 1)]
        vec = [[] for _ in range(N + 1)]
        for _ in range(M):
            a, b = map(int, sys.stdin.readline().split())
            if a == 0 or b == 0:
                continue
            vec[a].append(b)
            vec[b].append(a)
            merge(a, b)

        for i in range(1, N + 1):
            s[find(i)].append(i)

        for ts in s:
            if len(ts) == 0:
                continue
            else:
                temp = 0
                for i in ts:
                    temp += len(vec[i])
                if temp / 2 == len(ts) - 1:
                    answer += 1
        if answer == 0:
            print(f'Case {ind}: No trees.')
        elif answer == 1:
            print(f'Case {ind}: There is one tree.')
        else:
            print(f'Case {ind}: A forest of {answer} trees.')
