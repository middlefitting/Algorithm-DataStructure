from collections import deque

if __name__ == "__main__":
    N = int(input())
    answer = 0
    queue = deque([])
    p = list(map(int, input().split()))
    T = int(input())
    vec = [[] for _ in range(N + 1)]

    for i in range(N):
        if i == T:
            continue
        if p[i] != -1:
            vec[p[i]].append(i)
        else:
            queue.append(i)

    while queue:
        x = queue.popleft()
        if len(vec[x]) == 0:
            answer += 1
            continue
        for i in vec[x]:
            queue.append(i)

    print(answer)
