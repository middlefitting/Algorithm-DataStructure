from collections import deque

for _ in range(int(input())):
    N, s = map(str, input().split())
    N = int(N)
    queue = deque(list(s))
    idx = 0
    while queue:
        idx += 1
        c = queue.popleft()
        if N == idx:
            continue
        print(c, end="")
    print("")
