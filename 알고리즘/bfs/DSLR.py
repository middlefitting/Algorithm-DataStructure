import sys
from collections import deque

T = int(sys.stdin.readline())
for i in range(T):
    A, B = map(int, sys.stdin.readline().split())
    v = [0] * 10000
    # p = [0] * 10000
    # a = ['0'] * 10000
    queue = deque([])
    queue.append([A, ''])
    v[A] = 1
    #
    # def check(y, action):
    #     if v[y] == 0:
    #         queue.append(y)
    #         v[y] = 1
    #         p[y] = x
    #         a[y] = action

    while queue:
        x, answer = queue.popleft()
        if x == B:
            print(answer)
            break

        # y = (x * 2) % 10000
        y = (2 * x) % 10000
        if not v[y]:
            queue.append([y, answer + 'D'])
            v[y] = 1
        # check(y, 'D')

        y = x - 1
        if x == 0:
            y = 9999
        if not v[y]:
            queue.append([y, answer + 'S'])
            v[y] = 1

        tho = x // 1000
        hun = (x % 1000) // 100
        ten = (x % 100) // 10
        one = (x % 10)

        y = hun * 1000 + ten * 100 + one * 10 + tho
        if not v[y]:
            queue.append([y, answer + 'L'])
            v[y] = 1
        # check(y, 'L')

        y = one * 1000 + tho * 100 + hun * 10 + ten
        if not v[y]:
            queue.append([y, answer + 'R'])
            v[y] = 1
        # check(y, 'R')

    # answer = deque([])
    # next = B
    # while True:
    #     answer.append(a[next])
    #     next = p[next]
    #     if next == 0:
    #         break
    # answer.pop()
    # while answer:
    #     print(answer.pop(), end="")
    # print()

