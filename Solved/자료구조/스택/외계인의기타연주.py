from collections import deque

if __name__ == "__main__":
    N, P = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    stack = [deque([]) for _ in range(7)]
    answer = 0
    for s, p in arr:
        if not stack[s]:
            stack[s].appendleft(p)
            answer += 1
        else:
            while stack[s] and stack[s][0] > p:
                stack[s].popleft()
                answer += 1
            if not stack[s] or stack[s][0] != p:
                stack[s].appendleft(p)
                answer += 1
    print(answer)
