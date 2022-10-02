import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
lines = deque([])
p = [-1] * N
parents = []

for i in range(N):
    parents.append([i])

for _ in range(M):
    lines.append(list(map(int, sys.stdin.readline().split())))


def find(n):
    if p[n] < 0:
        return n
    p[n] = find(p[n])
    return find(p[n])


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return True
    if abs(p[a]) >= abs(p[b]):
        p[a] += p[b]
        for i in parents[b]:
            p[i] = a
            parents[a].append(i)
    else:
        p[b] += p[a]
        for i in parents[a]:
            p[i] = b
            parents[b].append(i)
    return False

answer = 0
result = False

while lines:
    temp, link = lines.popleft()
    answer += 1
    if merge(temp, link):
        result = True
        print(answer)
        break

if not result:
    print(0)