import sys

N, M = map(int, sys.stdin.readline().split())
arr = []
ms = [-1] * (N + 1)
for _ in range(M):
    arr.append(list(map(int, sys.stdin.readline().split())))

arr.sort(key=lambda x: x[2])


def find(a):
    if ms[a] < 0:
        return a
    ms[a] = find(ms[a])
    return ms[a]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return False
    ms[b] = a
    return True

answer = 0
count = 0
for [a, b, c] in arr:
    if merge(a, b):
        answer += c
        count += 1
    if count == (N - 1):
        print(answer)
        break

